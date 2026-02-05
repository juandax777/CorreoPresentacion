package org.example.service;

import org.example.model.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * Envía un correo electrónico simple
     * @param emailRequest Objeto con los datos del correo (destinatario, asunto, cuerpo)
     * @return true si se envió correctamente, false en caso contrario
     */
    public boolean sendEmail(EmailRequest emailRequest) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(emailRequest.getTo());
            message.setSubject(emailRequest.getSubject());
            message.setText(emailRequest.getBody());

            // Opcional: puedes configurar el remitente
            // message.setFrom("tu-correo@gmail.com");

            mailSender.send(message);

            System.out.println("Correo enviado exitosamente a: " + emailRequest.getTo());
            return true;

        } catch (Exception e) {
            System.err.println("Error al enviar el correo: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Envía un correo con parámetros individuales
     * @param to Destinatario
     * @param subject Asunto
     * @param body Cuerpo del mensaje
     * @return true si se envió correctamente, false en caso contrario
     */
    public boolean sendEmail(String to, String subject, String body) {
        EmailRequest emailRequest = new EmailRequest(to, subject, body);
        return sendEmail(emailRequest);
    }
}