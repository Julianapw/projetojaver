package com.julianaferreira.service;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.julianaferreira.dto.ClienteDto;

@FeignClient(name = "clienteDbService", url = "http://localhost:8081/clientes")
public interface ClienteDbClient {

    @GetMapping
    List<ClienteDto> listarTodos();

    @GetMapping("/{id}")
    ClienteDto obterCliente(@PathVariable("id") Long id);

    @PostMapping
    ClienteDto criarCliente(@RequestBody ClienteDto cliente);

    @PutMapping("/{id}")
    ClienteDto atualizarCliente(@PathVariable("id") Long id, @RequestBody ClienteDto cliente);

    @DeleteMapping("/{id}")
    void deletarCliente(@PathVariable("id") Long id);

    @GetMapping("/buscar")
    List<ClienteDto> buscarClientes(@RequestParam(required = false) long nome);
}
