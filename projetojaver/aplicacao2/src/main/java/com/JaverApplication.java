package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JaverApplication {

    public static void main(String[] args) {
        SpringApplication.run(JaverApplication.class, args);
        System.out.println("Aplicação Javer está rodando...");
    }
}
