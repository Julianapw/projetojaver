package com.julianaferreira;

import com.julianaferreira.controller.ClienteController;
import com.julianaferreira.model.Cliente;
import com.julianaferreira.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClienteTest {

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Juliana Ferreira");
        cliente.setTelefone(999999999L);
        cliente.setCorrentista(true);
        cliente.setSaldoCc(1000f);
    }

    @Test
    void listarTodos_DeveRetornarListaDeClientes() {
        when(clienteService.listarTodos()).thenReturn(Collections.singletonList(cliente));

        List<Cliente> clientes = clienteController.listarTodos();

        assertEquals(1, clientes.size());
        assertEquals("Juliana Ferreira", clientes.get(0).getNome());
        verify(clienteService, times(1)).listarTodos();
    }

    @Test
    void buscarPorId_DeveRetornarCliente() {
        when(clienteService.buscarPorId(1L)).thenReturn(cliente);

        Cliente resultado = clienteController.buscarPorId(1L);

        assertEquals("Juliana Ferreira", resultado.getNome());
        verify(clienteService, times(1)).buscarPorId(1L);
    }
}
