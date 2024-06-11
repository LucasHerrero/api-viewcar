package com.concesionario.repository;

import com.concesionario.entity.Message;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByEmail(String email);

    Optional<Message> findByIdAndConversationId(Long id, Long conversationId);
}