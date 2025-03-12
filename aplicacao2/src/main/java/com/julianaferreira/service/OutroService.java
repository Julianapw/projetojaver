package com.julianaferreira.service;

import org.springframework.stereotype.Service;

import com.julianaferreira.repository.ClienteRepository;

@Service
public class OutroService {
    public OutroService(ClienteRepository clienteRepository) {
    }

    public void performAction() {
        
        System.out.println("Executando ação no OutroService");
    }
}
