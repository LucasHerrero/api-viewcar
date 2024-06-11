package com.concesionario.service;

import com.concesionario.entity.User;
import com.concesionario.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User authenticate(String username, String password) {
        List<User> users = userRepository.findByEmail(username);

        if (users.isEmpty()) {
            return null;
        }

        // Si hay más de un usuario con el mismo correo electrónico, puedes decidir qué hacer.
        // En este ejemplo, simplemente tomamos el primer usuario de la lista.
        User user = users.get(0);

        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }

        return null;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User findUserByPasswordResetToken(String token) {
        return userRepository.findByPasswordResetToken(token);
    }
}