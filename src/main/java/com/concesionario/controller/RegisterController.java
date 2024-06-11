package com.concesionario.controller;

import com.concesionario.entity.User;
import com.concesionario.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class RegisterController {
    @Autowired
    private UserService userService;

    // Post
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User request) {
        try {
            User user = new User();
            user.setFirstName(request.getFirstName());
            user.setSecondLastName(request.getSecondLastName());
            user.setEmail(request.getEmail());
            user.setPhone(request.getPhone());
            user.setPassword(request.getPassword());

            userService.register(user);
            return new ResponseEntity<>("Usuario registrado con éxito", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}