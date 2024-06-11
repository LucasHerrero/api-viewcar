package com.concesionario.controller;

import com.concesionario.entity.User;
import com.concesionario.service.AuthenticationService;
import com.concesionario.service.EmailService;
import com.concesionario.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

import com.concesionario.entity.PasswordReset;
import com.concesionario.entity.PasswordResetRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class PasswordController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    // Endpoint para solicitar el cambio de contraseña
    @PostMapping("/password/reset-request")
    public ResponseEntity<?> requestPasswordReset(@RequestBody PasswordResetRequest request) {
        User user = userService.findByUsername(request.getEmail());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Europe/Madrid"));
        if (user.getPasswordResetTokenGeneratedAt() != null && user.getPasswordResetTokenGeneratedAt().plusMinutes(10).isAfter(now)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    "Ya hay una petición activa. Por favor, espera unos minutos antes de solicitar otro cambio de contraseña.");
        }

        String token = UUID.randomUUID().toString();
        user.setPasswordResetToken(token);
        user.setPasswordResetTokenGeneratedAt(now);
        authenticationService.saveUser(user);

        emailService.sendPasswordResetEmail(user, token);

        return ResponseEntity.ok("Correo de restablecimiento de contraseña enviado");
    }

    // Endpoint para validar unicamente el token
    @GetMapping("/password/reset/{token}")
    public ResponseEntity<?> validatePasswordResetToken(@PathVariable String token) {
        User user = authenticationService.findUserByPasswordResetToken(token);

        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token inválido");
        }

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Europe/Madrid"));
        if (user.getPasswordResetTokenGeneratedAt().plusMinutes(10).isBefore(now)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token caducado");
        }

        return ResponseEntity.ok("Token válido");
    }

    // Endpoint para cambiar la contraseña utilizando el token
    @PostMapping("/password/reset")
    public ResponseEntity<?> resetPassword(@RequestBody PasswordReset reset, HttpServletRequest request) {
        User user = authenticationService.findUserByPasswordResetToken(reset.getToken());

        if (user == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token inválido");
        }

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Europe/Madrid"));
        if (user.getPasswordResetTokenGeneratedAt().plusMinutes(10).isBefore(now)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Token caducado");
        }

        String encodedPassword = passwordEncoder.encode(reset.getNewPassword());
        user.setPassword(encodedPassword);
        user.setPasswordResetToken(null);
        user.setPasswordResetTokenGeneratedAt(null);
        authenticationService.saveUser(user);

        String ipAddress = request.getRemoteAddr();
        LocalDateTime changeTime = LocalDateTime.now(ZoneId.of("Europe/Madrid"));
        emailService.sendPasswordChangeConfirmationEmail(user, ipAddress, changeTime);

        return ResponseEntity.ok("Contraseña cambiada con éxito");
    }
}