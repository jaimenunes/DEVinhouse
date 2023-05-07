package com.veiculos.api.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.veiculos.api.Controller.Requests.VeiculoRequest;
import com.veiculos.api.Exceptions.RegistroExistenteException;
import com.veiculos.api.Exceptions.RegistroNaoEncontradoException;
import com.veiculos.api.Exceptions.VeiculoComMultasException;
import com.veiculos.api.Model.Veiculo;
import com.veiculos.api.Service.VeiculoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest
class VeiculoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private ModelMapper modelMapper = new ModelMapper();

    @MockBean
    private VeiculoService service;

    @Test
    @DisplayName("Cadastra veiculo")
    void incluir_sucesso() throws Exception {
        VeiculoRequest request = new VeiculoRequest("ABC-123", "carro", "azul", 2020);
        Veiculo veiculo = modelMapper.map(request, Veiculo.class);
        String requestJson = objectMapper.writeValueAsString(request);
        Mockito.when(service.inserir(Mockito.any(Veiculo.class))).thenReturn(veiculo);
        mockMvc.perform(post("/api/veiculos")
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.placa", is(notNullValue())))
                .andExpect(jsonPath("$.placa", is(veiculo.getPlaca())));
    }

    @Test
    @DisplayName("Quando inclusao com placa jah existente, deve retornar erro")
    void incluir_jaCadastrado() throws Exception {
        Mockito.when(service.inserir(Mockito.any(Veiculo.class))).thenThrow(RegistroExistenteException.class);
        VeiculoRequest req = new VeiculoRequest("ABC-143", "carro", "azul", 2020);
        String requestJson = objectMapper.writeValueAsString(req);
        mockMvc.perform(post("/api/veiculos")
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isConflict())  // 409
                .andExpect(jsonPath("$.erro", containsStringIgnoringCase("Registro já cadastrado!")));
    }

    @Test
    @DisplayName("Retorna lista com todos o valores")
    void consultaTodosVeiculos() throws Exception {
        List<Veiculo> registros =
                List.of(
                        new Veiculo("ABC-123", "carro", "azul", 2020),
                        new Veiculo("ZXC-456", "caminhao", "prata", 2022)
                );
        Mockito.when(service.consultar()).thenReturn(registros);
        mockMvc.perform(get("/api/veiculos")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].placa",is("ABC-123")))
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    @DisplayName("Quando não houver veículos cadastrados, deve retornar lista vazia")
    void consultar_vazio() throws Exception {
        mockMvc.perform(get("/api/veiculos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is(empty())));
    }

    @Test
    @DisplayName("Busca veiculo a partir da placa")
    void consultaVeiculo_sucesso() throws Exception {
        Veiculo veiculo = new Veiculo("ABC-123", "carro", "azul", 2020);
        Mockito.when(service.consultaId(Mockito.anyString())).thenReturn(veiculo);
        mockMvc.perform(get("/api/veiculos/ABC-123")
                .content("ABC-123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.placa", is(veiculo.getPlaca())));
    }

    @Test
    @DisplayName("Busca veiculo a partir da placa errada deve retornar erro")
    void consultaVeiculo_placaIncorreta() throws Exception {
        Mockito.when(service.consultaId(Mockito.anyString())).thenThrow(RegistroNaoEncontradoException.class);
        mockMvc.perform(get("/api/veiculos/ABC-123")
                        .content("ABC-123")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.erro", is("Registro não encontrado!")));
    }

    @Test
    @DisplayName("Deleta veiculo")
    void deletaVeiculo_sucesso() throws Exception{
        mockMvc.perform(delete("/api/veiculos/{placa}", "ABC-123")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
    @Test
    @DisplayName("Erro ao deletar veiculo registro não encotrado")
    void deletaVeiculo_erro_placa() throws Exception{
        Mockito.doThrow(RegistroNaoEncontradoException.class).when(service).deletaVeiculo(Mockito.anyString());
        mockMvc.perform(delete("/api/veiculos{placa}", "ABC-123")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
    @Test
    @DisplayName("Erro ao deletar veiculo com multa")
    void deletaVeiculo_erro_multa() throws Exception{
        Mockito.doThrow(VeiculoComMultasException.class).when(service).deletaVeiculo(Mockito.anyString());
        mockMvc.perform(delete("/api/veiculos/{placa}", "ABC-123")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.erro", is("Veículo possui multas e não pode ser excluído!")));
    }

    @Test
    @DisplayName("Quando houver veículo cadastrado com a placa informada, deve retornar sucesso")
    void multar() throws Exception {
        Integer qtdMultas = 2;
        Veiculo veiculo = Veiculo.builder().placa("ABC-123").tipoVeiculo("carro").cor("preto").anoDeFabricacao(2010).qtdMultas(qtdMultas).build();
        Mockito.when(service.adicionarMulta(Mockito.anyString())).thenReturn(veiculo);
        mockMvc.perform(put("/api/veiculos/{placa}/multas", veiculo.getPlaca())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.placa", is(notNullValue())))
                .andExpect(jsonPath("$.qtdMultas", is(qtdMultas)));
    }

    @Test
    @DisplayName("Quando não houver veículo cadastrado com a placa informada, deve lançar exception")
    void multar_erro() throws Exception {
        Mockito.when(service.adicionarMulta(Mockito.anyString())).thenThrow(RegistroNaoEncontradoException.class);
        Veiculo veiculo = Veiculo.builder().placa("ABC-123").tipoVeiculo("carro").cor("preto").anoDeFabricacao(2010).build();
        mockMvc.perform(put("/api/veiculos/{placa}/multas", veiculo.getPlaca())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}