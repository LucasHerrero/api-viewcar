package com.concesionario.service;

import com.concesionario.entity.User;
import com.concesionario.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    public User register(User user) {
        if (user.getPassword() == null) {
            throw new IllegalArgumentException("La contraseña no puede ser nula");
        }

        // Comprobar si ya existe un usuario con el mismo correo electrónico
        List<User> existingUsers = userRepository.findByEmail(user.getEmail());
        if (!existingUsers.isEmpty()) {
            throw new IllegalArgumentException("Ya existe un usuario con este correo electrónico");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRegistrationDate(new Date());

        userRepository.save(user);

        emailService.sendWelcomeEmail(user);
        return user;
    }

    public User findByUsername(String username) {
        List<User> users = userRepository.findByEmail(username);

        if (users.isEmpty()) {
            return null;
        }

        // Si hay más de un usuario con el mismo correo electrónico, puedes decidir qué
        // hacer.
        // En este ejemplo, simplemente tomamos el primer usuario de la lista.
        return users.get(0);
    }


}