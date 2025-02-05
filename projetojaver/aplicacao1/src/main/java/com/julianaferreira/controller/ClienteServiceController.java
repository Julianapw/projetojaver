package com.julianaferreira.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.service.connection.ConnectionDetailsNotFoundException;
import org.springframework.web.bind.annotation.*;

import com.julianaferreira.dto.ClienteDto;
import com.julianaferreira.service.ClienteDbClient;

@RestController
@RequestMapping("api1/clientes")
public class ClienteServiceController {

    @Autowired
    private ClienteDbClient clienteDbClient;

    // Criar cliente
    @PostMapping
    public ClienteDto criarCliente(@RequestBody ClienteDto cliente) {
        // Usando BigDecimal para calcular scoreCredito
        BigDecimal saldo = cliente.getSaldoCc(); // Assume que getSaldoCc retorna um BigDecimal
        BigDecimal scoreCredito = saldo.multiply(BigDecimal.valueOf(0.1));
        cliente.setScoreCredito(scoreCredito.floatValue()); // Convertendo para Float
        return clienteDbClient.criarCliente(cliente);
    }

    // Obter cliente por ID com tratamento para cliente não encontrado
    @GetMapping("/{id}")
    public ClienteDto obterCliente(@PathVariable Long id) {
        ClienteDto cliente = clienteDbClient.obterCliente(id);
        if (cliente == null) {
            throw new ConnectionDetailsNotFoundException("Cliente com ID " + id + " não encontrado");
        }
        return cliente;
    }

    // Listar todos os clientes
    @GetMapping
    public List<ClienteDto> listarClientes() {
        return clienteDbClient.listarTodos();
    }

    // Atualizar cliente por ID
    @PutMapping("/{id}")
    public ClienteDto atualizarCliente(@PathVariable Long id, @RequestBody ClienteDto cliente) {
        // Usando BigDecimal para calcular scoreCredito
        BigDecimal saldo = cliente.getSaldoCc();
        BigDecimal scoreCredito = saldo.multiply(BigDecimal.valueOf(0.1));
        cliente.setScoreCredito(scoreCredito.floatValue());
        return clienteDbClient.atualizarCliente(id, cliente);
    }

    // Deletar cliente por ID
    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clienteDbClient.deletarCliente(id);
    }
}
