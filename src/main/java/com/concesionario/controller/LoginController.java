package com.concesionario.controller;

import com.concesionario.security.JWTAuthtenticationConfig;
import com.concesionario.service.AuthenticationService;
import com.concesionario.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.concesionario.entity.LoginRequest;
import com.concesionario.entity.AuthResponse;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class LoginController {

    @Autowired
    JWTAuthtenticationConfig jwtAuthtenticationConfig;

    @Autowired
    private AuthenticationService authenticationService;

    // Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = authenticationService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if (user != null) {
            // Generar y establecer el token JWT aquí
            String token = jwtAuthtenticationConfig.getJWTToken(loginRequest.getUsername());

             // Crear y devolver la respuesta de autenticación
            AuthResponse response = new AuthResponse();
            response.setUsername(loginRequest.getUsername());
            response.setToken(token);
            return ResponseEntity.ok(response);
        }

        // Si el usuario no existe o la contraseña es incorrecta, devolver UNAUTHORIZED
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrectos");
    }
}