package com.julianaferreira.projetofinal;

import com.julianaferreira.model.Cliente;
import com.julianaferreira.repository.ClienteRepository;
import com.julianaferreira.service.ClienteService;
import com.julianaferreira.service.OutroService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;  // Mockando o repositório de clientes

    @Mock
    private OutroService outroService;  // Mockando o OutroService

    @InjectMocks
    private ClienteService clienteService;  // A instância do ClienteService que será testada

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa os mocks
        cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Juliana");
        cliente.setTelefone(1234567890L);
        cliente.setCorrentista(true);
        cliente.setScoreCredito(850.0f);
        cliente.setSaldoCc(1000.0f);
    }

    @Test
    void testCriarCliente() {
        // Simulando o comportamento do repositório ao salvar um cliente
        when(clienteRepository.save(Mockito.any(Cliente.class))).thenReturn(cliente);

        Cliente clienteSalvo = clienteService.criarCliente(cliente);

        // Verificando se o cliente foi salvo corretamente
        assertNotNull(clienteSalvo);
        assertEquals(cliente.getNome(), clienteSalvo.getNome());
        verify(clienteRepository, times(1)).save(cliente);  // Verifica se o método save foi chamado uma vez
    }

    @Test
    void testBuscarPorId() {
        // Simulando o comportamento do repositório ao buscar um cliente
        when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

        Cliente clienteBuscado = clienteService.buscarPorId(1L);

        // Verificando se o cliente foi encontrado corretamente
        assertNotNull(clienteBuscado);
        assertEquals(cliente.getId(), clienteBuscado.getId());
    }

    @Test
    void testBuscarPorIdClienteNaoEncontrado() {
        // Simulando o comportamento do repositório quando o cliente não for encontrado
        when(clienteRepository.findById(2L)).thenReturn(Optional.empty());

        // Verificando se a exceção é lançada quando o cliente não for encontrado
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            clienteService.buscarPorId(2L);
        });

        assertEquals("Cliente não encontrado com o ID: 2", exception.getMessage());
    }

    @Test
    void testAtualizarCliente() {
        // Simulando o comportamento do repositório ao atualizar um cliente
        when(clienteRepository.existsById(1L)).thenReturn(true);
        when(clienteRepository.save(Mockito.any(Cliente.class))).thenReturn(cliente);

        cliente.setNome("Juliana Ferreira");
        Cliente clienteAtualizado = clienteService.atualizarCliente(1L, cliente);

        // Verificando se o cliente foi atualizado corretamente
        assertNotNull(clienteAtualizado);
        assertEquals("Juliana Ferreira", clienteAtualizado.getNome());
    }

    @Test
    void testDeletarCliente() {
        // Simulando o comportamento do repositório ao deletar um cliente
        when(clienteRepository.existsById(1L)).thenReturn(true);

        clienteService.deletarCliente(1L);

        // Verificando se o método deleteById foi chamado
        verify(clienteRepository, times(1)).deleteById(1L);
    }

    @Test
    void testDeletarClienteNaoEncontrado() {
        // Simulando o comportamento do repositório quando o cliente não for encontrado
        when(clienteRepository.existsById(2L)).thenReturn(false);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            clienteService.deletarCliente(2L);
        });

        assertEquals("Cliente não encontrado com o ID: 2", exception.getMessage());
    }
}
