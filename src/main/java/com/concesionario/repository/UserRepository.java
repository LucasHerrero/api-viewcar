package com.concesionario.repository;

import com.concesionario.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByEmail(String email);

    User findByPasswordResetToken(String token);
}