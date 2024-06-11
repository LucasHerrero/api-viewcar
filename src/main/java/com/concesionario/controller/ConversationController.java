package com.concesionario.controller;

import com.concesionario.entity.Conversation;
import com.concesionario.entity.Message;
import com.concesionario.entity.Reply;
import com.concesionario.repository.ConversationRepository;
import com.concesionario.repository.MessageRepository;
import com.concesionario.repository.ReplyRepository;
import com.concesionario.service.EmailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ConversationController {
    @Autowired
    private ConversationRepository conversationRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Autowired
    private EmailService emailService;

    @PostMapping("/messages")
    public ResponseEntity<?> createMessage(@RequestBody Message message) {
        // Buscar una conversación existente con el mismo correo electrónico
        Conversation conversation = conversationRepository.findByEmail(message.getEmail()).orElse(null);

        // Si no existe una conversación con el mismo correo electrónico, crear una
        // nueva
        if (conversation == null) {
            conversation = new Conversation();
            conversation.setEmail(message.getEmail()); // Establecer el correo electrónico del usuario en la
                                                       // conversación
            conversationRepository.save(conversation);
        }

        // Asociar el mensaje con la conversación y guardar el mensaje
        message.setSendAt(LocalDateTime.now(ZoneId.of("Europe/Madrid")));
        message.setConversation(conversation);
        messageRepository.save(message);

        // Crear un objeto Map para devolver el mensaje y el ID de la conversación
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Mensaje creado con éxito");
        response.put("conversationId", conversation.getId());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/conversations/{conversationId}/messages")
    public ResponseEntity<?> createMessage(@PathVariable Long conversationId, @RequestBody Message message) {
        Conversation conversation = conversationRepository.findById(conversationId).orElse(null);
        if (conversation == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conversación no encontrada");
        }

        message.setSendAt(LocalDateTime.now(ZoneId.of("Europe/Madrid")));
        message.setConversation(conversation);
        messageRepository.save(message);
        return ResponseEntity.status(HttpStatus.CREATED).body("Mensaje creado con éxito");
    }

    @GetMapping("/conversations")
    public ResponseEntity<?> getConversation(@RequestParam(required = false) Long id, @RequestParam(required = false) String email) {
        if (id != null) {
            Conversation conversation = conversationRepository.findById(id).orElse(null);
            if (conversation == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conversación no encontrada");
            }
            return ResponseEntity.ok(conversation);
        } else if (email != null) {
            Conversation conversation = conversationRepository.findByEmail(email).orElse(null);
            if (conversation == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conversación no encontrada");
            }
            return ResponseEntity.ok(conversation);
        } else {
            return ResponseEntity.ok(conversationRepository.findAll());
        }
    }

    @PostMapping("/conversations/{conversationId}/reply")
    public ResponseEntity<?> replyToConversation(@PathVariable Long conversationId, @RequestBody String replyText) {
        Conversation conversation = conversationRepository.findById(conversationId).orElse(null);
        if (conversation == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conversación no encontrada");
        }

        Reply reply = new Reply();
        reply.setConversation(conversation);
        reply.setText(replyText);
        reply.setSentAt(LocalDateTime.now(ZoneId.of("Europe/Madrid")));
        Reply savedReply = replyRepository.save(reply);

        emailService.sendReplyEmail(conversation, replyText);

        return ResponseEntity.ok(savedReply);
    }
}