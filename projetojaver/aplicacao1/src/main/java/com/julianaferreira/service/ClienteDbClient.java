package com.julianaferreira.service;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import com.julianaferreira.dto.ClienteDto;

@FeignClient(name = "clienteDbService", url = "http://localhost:8082") //declara cliente feign para chamar APIs externas
public interface ClienteDbClient {

    @GetMapping
    List<ClienteDto> listarTodos(); //envia requisição get e retorna cliente DTO

    @GetMapping("/{id}")
    ClienteDto obterCliente(@PathVariable Long id); //envia requisição get para buscar um id específico

    @PostMapping
    ClienteDto criarCliente(@RequestBody ClienteDto cliente); //envia post com um json e retorna cliente criado

    @PutMapping("/{id}")
    ClienteDto atualizarCliente(@PathVariable Long id, @RequestBody ClienteDto cliente); //envia requisição put com dados do cliente no corpo da requisição

    @DeleteMapping("/{id}")
    void deletarCliente(@PathVariable Long id); //envia requisição delete para remover o cliente
}
