package com.julianaferreira.projetofinal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import com.julianaferreira.controller.ClienteServiceController;
import com.julianaferreira.dto.ClienteDto;
import com.julianaferreira.service.ClienteDbClient;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClienteServiceController.class)
public class ClienteServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteDbClient clienteDBClient;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private ClienteDbClient clienteDBClientInjectado;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveRetornarListaDeClientes() throws Exception {
        // Mockando a resposta do ClienteDBClient
        List<ClienteDto> clientes = Arrays.asList(new ClienteDto());
        when(clienteDBClient.buscarClientes()).thenReturn(clientes);

        // Chamando a API e verificando a resposta
        mockMvc.perform(get("/clientes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"nome\":\"Juliana\",\"email\":\"juliana@email.com\"}]"));
    }

    @Test
    void deveBuscarClientesDoBanco() {
        // Mockando a resposta do banco de dados
        ClienteDto[] respostaMock = {new ClienteDto()};
        when(restTemplate.getForObject("http://banco-api/clientes", ClienteDto[].class))
                .thenReturn(respostaMock);

        // Chamando o método e verificando o resultado
        
        ClienteDto[] resultado = ((List<ClienteDto>) clienteDBClientInjectado.buscarClientes()).toArray(new ClienteDto[0]);
        assertEquals(1, resultado.length);
        assertEquals("Juliana", resultado[0].getNome());
    }
}
