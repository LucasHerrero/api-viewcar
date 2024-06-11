package com.concesionario.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.concesionario.entity.Conversation;
import com.concesionario.entity.Message;
import com.concesionario.entity.User;

@Service
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @Autowired
    private JavaMailSender mailSender;

    public void sendWelcomeEmail(User user) {
        new Thread(() -> {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("no-responder@neatly.es");
            message.setTo(user.getEmail());
            message.setSubject("Bienvenido a Viewcar");
            message.setText("Hola " + user.getFirstName() + ",\n\nGracias por registrarte en Concesionario!");

            try {
                logger.info("Intentando enviar correo de bienvenida a {}", user.getEmail());
                mailSender.send(message);
                logger.info("Correo de bienvenida enviado a {}", user.getEmail());
            } catch (Exception e) {
                logger.error("Error al enviar correo de bienvenida a {}", user.getEmail(), e);
            }
        }).start();
    }

    // Funcion para recuperar contraseña de un usuario
    public void sendPasswordResetEmail(User user, String token) {
        new Thread(() -> {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("no-responder@neatly.es");
            message.setTo(user.getEmail());
            message.setSubject("Restablecimiento de contraseña");
            message.setText("Hola " + user.getFirstName()
                    + ",\n\nHemos recibido una solicitud para restablecer tu contraseña. "
                    + "Por favor, haz clic en el siguiente enlace para completar el proceso:\n"
                    + "http://localhost:4200/cambio-contraseña?t=" + token
                    + "\n\nSi no has solicitado un restablecimiento de contraseña, por favor, ignora este correo.");

            try {
                logger.info("Intentando enviar correo de restablecimiento de contraseña a {}", user.getEmail());
                mailSender.send(message);
                logger.info("Correo de restablecimiento de contraseña enviado a {}", user.getEmail());
            } catch (Exception e) {
                logger.error("Error al enviar correo de restablecimiento de contraseña a {}", user.getEmail(), e);
            }
        }).start();
    }

    public void sendPasswordChangeConfirmationEmail(User user, String ipAddress, LocalDateTime changeTime) {
        new Thread(() -> {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("no-responder@neatly.es");
            message.setTo(user.getEmail());
            message.setSubject("Confirmación de cambio de contraseña");
            message.setText("Hola " + user.getFirstName()
                    + ",\n\nTu contraseña ha sido cambiada con éxito a las " + changeTime.format(DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy"))
                    + " desde la dirección IP: " + ipAddress
                    + ".\n\nSi no reconoces esta actividad, por favor, contacta con atención al cliente.");

            try {
                logger.info("Intentando enviar correo de confirmación de cambio de contraseña a {}", user.getEmail());
                mailSender.send(message);
                logger.info("Correo de confirmación de cambio de contraseña enviado a {}", user.getEmail());
            } catch (Exception e) {
                logger.error("Error al enviar correo de confirmación de cambio de contraseña a {}", user.getEmail(), e);
            }
        }).start();
    }

    // En EmailService.java
    public void sendReplyEmail(Conversation conversation, String reply) {
        new Thread(() -> {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("no-responder@neatly.es");
            message.setTo(conversation.getEmail());
            message.setSubject("Respuesta a tu mensaje");
            message.setText("Hola,\n\nHas recibido una respuesta a tu mensaje:\n\n" + reply);

            try {
                logger.info("Intentando enviar correo de respuesta a {}", conversation.getEmail());
                mailSender.send(message);
                logger.info("Correo de respuesta enviado a {}", conversation.getEmail());
            } catch (Exception e) {
                logger.error("Error al enviar correo de respuesta a {}", conversation.getEmail(), e);
            }
        }).start();
    }
}