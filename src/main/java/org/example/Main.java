package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        System.out.println("==============================================");
        System.out.println("   Aplicación de Correo Iniciada");
        System.out.println("   Puerto: 8080");
        System.out.println("   Endpoint: POST http://localhost:8080/api/email/send");
        System.out.println("   Test: GET http://localhost:8080/api/email/test");
        System.out.println(" Pagina http://localhost:8080/index.html");
        System.out.println("==============================================");
    }
}