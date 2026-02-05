package org.example.controller;

import org.example.model.EmailRequest;
import org.example.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins = "*") // Permite peticiones desde cualquier origen
public class EmailController {

    @Autowired
    private EmailService emailService;

    /**
     * Endpoint para enviar correos electrónicos
     * POST /api/email/send
     * @param emailRequest Objeto JSON con los datos del correo
     * @return ResponseEntity con el resultado de la operación
     */
    @PostMapping("/send")
    public ResponseEntity<Map<String, Object>> sendEmail(@RequestBody EmailRequest emailRequest) {
        Map<String, Object> response = new HashMap<>();

        try {
            // Validaciones básicas
            if (emailRequest.getTo() == null || emailRequest.getTo().isEmpty()) {
                response.put("success", false);
                response.put("message", "El campo 'to' es obligatorio");
                return ResponseEntity.badRequest().body(response);
            }

            if (emailRequest.getSubject() == null || emailRequest.getSubject().isEmpty()) {
                response.put("success", false);
                response.put("message", "El campo 'subject' es obligatorio");
                return ResponseEntity.badRequest().body(response);
            }

            if (emailRequest.getBody() == null || emailRequest.getBody().isEmpty()) {
                response.put("success", false);
                response.put("message", "El campo 'body' es obligatorio");
                return ResponseEntity.badRequest().body(response);
            }

            // Intentar enviar el correo
            boolean enviado = emailService.sendEmail(emailRequest);

            if (enviado) {
                response.put("success", true);
                response.put("message", "Correo enviado exitosamente");
                response.put("to", emailRequest.getTo());
                response.put("subject", emailRequest.getSubject());
                return ResponseEntity.ok(response);
            } else {
                response.put("success", false);
                response.put("message", "Error al enviar el correo");
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Error en el servidor: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    /**
     * Endpoint de prueba para verificar que el servicio está funcionando
     * GET /api/email/test
     */
    @GetMapping("/test")
    public ResponseEntity<Map<String, String>> test() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "OK");
        response.put("message", "Servicio de correo funcionando correctamente");
        return ResponseEntity.ok(response);
    }
}