package com.julianaferreira.service;

import com.julianaferreira.model.Cliente;
import com.julianaferreira.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final OutroService outroService;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, OutroService outroService) {
        this.clienteRepository = clienteRepository;
        this.outroService = outroService;
    }

    // Método para listar todos os clientes
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    // Método para buscar um cliente pelo ID
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(() -> 
            new RuntimeException("Cliente não encontrado com o ID: " + id)
        );
    }

    // Método para criar um novo cliente
    public Cliente criarCliente(Cliente cliente) {
        // Lógica adicional usando o OutroService (caso necessário)
        outroService.performAction();
        return clienteRepository.save(cliente);
    }

    // Método para atualizar um cliente existente
    public Cliente atualizarCliente(Long id, Cliente cliente) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado com o ID: " + id);
        }
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    // Método para deletar um cliente pelo ID
    public void deletarCliente(Long id) {
        if (!clienteRepository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado com o ID: " + id);
        }
        clienteRepository.deleteById(id);
    }

    // Método para executar alguma lógica com o OutroService
    public void executeSomeLogic() {
        outroService.performAction();
    }
}
