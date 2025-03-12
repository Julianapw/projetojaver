package com.julianaferreira.projetofinal;

import com.julianaferreira.dto.ClienteDto;
import com.julianaferreira.controller.ClienteServiceController;
import com.julianaferreira.service.ClienteDbClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClienteServiceTest {

    @Mock
    private ClienteDbClient clienteDbClient;

    @InjectMocks
    private ClienteServiceController clienteServiceController;

    private ClienteDto clienteDto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        clienteDto = new ClienteDto(1L, "Juliana", "juliana@example.com", 1234567890L, true, 1000f);
    }

    // Testes para ClienteServiceController

    @Test
    void testCriarCliente_SaldoValido() {
        when(clienteDbClient.criarCliente(clienteDto)).thenReturn(clienteDto);

        ResponseEntity<?> response = clienteServiceController.criarCliente(clienteDto);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testCriarCliente_SaldoInvalido() {
        clienteDto.setSaldoCc(-1000f);

        ResponseEntity<?> response = clienteServiceController.criarCliente(clienteDto);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("O saldo não pode ser negativo ou nulo.", response.getBody());
    }

    @SuppressWarnings("null")
    @Test
    void testListarClientes() {
        List<ClienteDto> clientes = new ArrayList<>();
        clientes.add(clienteDto);

        when(clienteDbClient.listarTodos()).thenReturn(clientes);

        ResponseEntity<List<ClienteDto>> response = clienteServiceController.listarClientes();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void testAtualizarCliente_SaldoValido() {
        when(clienteDbClient.atualizarCliente(1L, clienteDto)).thenReturn(clienteDto);

        ResponseEntity<?> response = clienteServiceController.atualizarCliente(1L, clienteDto);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testAtualizarCliente_SaldoInvalido() {
        clienteDto.setSaldoCc(-1000f);

        ResponseEntity<?> response = clienteServiceController.atualizarCliente(1L, clienteDto);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("O saldo não pode ser negativo ou nulo.", response.getBody());
    }

    @Test
    void testDeletarCliente() {
        doNothing().when(clienteDbClient).deletarCliente(1L);

        ResponseEntity<Void> response = clienteServiceController.deletarCliente(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @SuppressWarnings("null")
    @Test
    void testBuscarClientes() {
        List<ClienteDto> clientes = new ArrayList<>();
        clientes.add(clienteDto);

        when(clienteDbClient.buscarClientes(123L)).thenReturn(clientes);

        ResponseEntity<List<ClienteDto>> response = clienteServiceController.buscarClientes(123L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());
    }

    @Test
    void testObterCliente() {
        when(clienteDbClient.obterCliente(1L)).thenReturn(clienteDto);

        ResponseEntity<ClienteDto> response = clienteServiceController.obterCliente(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(clienteDto, response.getBody());
    }

    // Testes para ClienteDbClient

    @Test
    void testCriarClienteDb() {
        when(clienteDbClient.criarCliente(clienteDto)).thenReturn(clienteDto);

        ClienteDto response = clienteDbClient.criarCliente(clienteDto);

        assertNotNull(response);
        assertEquals(clienteDto.getId(), response.getId());
    }

    @Test
    void testAtualizarClienteDb() {
        when(clienteDbClient.atualizarCliente(1L, clienteDto)).thenReturn(clienteDto);

        ClienteDto response = clienteDbClient.atualizarCliente(1L, clienteDto);

        assertNotNull(response);
        assertEquals(clienteDto.getId(), response.getId());
    }

    @Test
    void testDeletarClienteDb() {
        doNothing().when(clienteDbClient).deletarCliente(1L);

        clienteDbClient.deletarCliente(1L);

        verify(clienteDbClient, times(1)).deletarCliente(1L);
    }

    @Test
    void testListarTodosClientes() {
        when(clienteDbClient.listarTodos()).thenReturn(List.of(clienteDto));

        List<ClienteDto> clientes = clienteDbClient.listarTodos();

        assertNotNull(clientes);
        assertFalse(clientes.isEmpty());
    }

    @Test
    void testBuscarClientesDb() {
        when(clienteDbClient.buscarClientes(123L)).thenReturn(List.of(clienteDto));

        List<ClienteDto> clientes = clienteDbClient.buscarClientes(123L);

        assertNotNull(clientes);
        assertFalse(clientes.isEmpty());
    }

    @Test
    void testObterClienteDb() {
        when(clienteDbClient.obterCliente(1L)).thenReturn(clienteDto);

        ClienteDto response = clienteDbClient.obterCliente(1L);

        assertNotNull(response);
        assertEquals(clienteDto.getId(), response.getId());
    }
}
