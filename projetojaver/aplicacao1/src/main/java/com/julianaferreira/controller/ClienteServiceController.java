package com.julianaferreira.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.julianaferreira.dto.ClienteDto;
import com.julianaferreira.service.ClienteDbClient;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteServiceController {

    private final ClienteDbClient clienteDbClient;

    public ClienteServiceController(ClienteDbClient clienteDbClient) {
        this.clienteDbClient = clienteDbClient;
    }

    // Criar cliente (POST)
    @PostMapping
    public ResponseEntity<?> criarCliente(@RequestBody ClienteDto clienteDto) {
        // Validação para saldo negativo ou null
        if (clienteDto.getSaldoCc() == null || clienteDto.getSaldoCc() < 0) {
            return ResponseEntity.badRequest().body("O saldo não pode ser negativo ou nulo.");
        }

        // O cálculo do score já acontece no DTO
        ClienteDto clienteCriado = clienteDbClient.criarCliente(clienteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCriado);
    }

    // Buscar todos os clientes (GET)
    @GetMapping
    public ResponseEntity<List<ClienteDto>> listarClientes() {
        List<ClienteDto> clientes = clienteDbClient.listarTodos();
        return ResponseEntity.ok(clientes);
    }

    // Atualizar cliente (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarCliente(@PathVariable Long id, @RequestBody ClienteDto clienteDto) {
        // Garante que o ID seja atualizado corretamente
        clienteDto.setId(id);

        // Se o saldo for null ou negativo, retorna erro
        if (clienteDto.getSaldoCc() == null || clienteDto.getSaldoCc() < 0) {
            return ResponseEntity.badRequest().body("O saldo não pode ser negativo ou nulo.");
        }

        ClienteDto clienteAtualizado = clienteDbClient.atualizarCliente(id, clienteDto);
        return ResponseEntity.ok(clienteAtualizado);
    }

    // Deletar cliente (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable Long id) {
        clienteDbClient.deletarCliente(id);
        return ResponseEntity.ok("Cliente deletado com sucesso.");
    }
}
