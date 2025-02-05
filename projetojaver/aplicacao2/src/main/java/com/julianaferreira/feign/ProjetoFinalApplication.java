package com.julianaferreira.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients // Habilita o Feign Client
public class ProjetoFinalApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProjetoFinalApplication.class, args);
    }
}
