package com.julianaferreira.controller;

import com.julianaferreira.model.Cliente;
import com.julianaferreira.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api2/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Endpoint para listar todos os clientes
    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    // Endpoint para buscar um cliente por ID
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id);
    }

    // Endpoint para criar um novo cliente
    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente) {
        return clienteService.criarCliente(cliente);
    }

    // Endpoint para atualizar um cliente existente
    @PutMapping("/{id}")
    public Cliente atualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.atualizarCliente(id, cliente);
    }

    // Endpoint para deletar um cliente por ID
    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id) {
        clienteService.deletarCliente(id);
    }
}
