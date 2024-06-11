package com.concesionario.repository;

import com.concesionario.entity.Conversation;
import com.concesionario.entity.Reply;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByConversation(Conversation conversation);
}