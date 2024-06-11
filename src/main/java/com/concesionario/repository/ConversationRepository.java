package com.concesionario.repository;

import com.concesionario.entity.Conversation;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationRepository extends JpaRepository<Conversation, Long> {
    Optional<Conversation> findByEmail(String email);
}