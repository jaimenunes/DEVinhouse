package com.veiculos.api.Service;

import com.veiculos.api.Exceptions.RegistroExistenteException;
import com.veiculos.api.Exceptions.RegistroNaoEncontradoException;
import com.veiculos.api.Exceptions.VeiculoComMultasException;
import com.veiculos.api.Model.Veiculo;
import com.veiculos.api.Repository.VeiculoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class VeiculoServiceTest {
    @Mock
    private VeiculoRepository veiculoRepository;

    @InjectMocks
    private VeiculoService veiculoService;

    @Test
    @DisplayName("Insere um veiculo com sucesso")
    void inserir_sucesso() {
        Veiculo veiculo = Veiculo.builder()
                .placa("ABC-123")
                .tipoVeiculo("carro")
                .cor("preto")
                .anoDeFabricacao(2018)
                .qtdMultas(0)
                .build();
        Mockito.when(veiculoRepository.existsById(Mockito.anyString())).thenReturn(false);
        Mockito.when(veiculoRepository.save(Mockito.any(Veiculo.class))).thenReturn(veiculo);
        var resultado = veiculoService.inserir(veiculo);
        assertNotNull(resultado);
        assertEquals(veiculo, resultado);
    }

    @Test
    @DisplayName("Insere um veiculo com erro, caso a placa já exista")
    void inserir_erro(){
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca("ABC-123");
        Mockito.when(veiculoRepository.existsById(Mockito.anyString())).thenReturn(true);
        assertThrows(RegistroExistenteException.class, () -> veiculoService.inserir(veiculo));
    }

    @Test
    @DisplayName("Listar veiculos cadastrados")
    void consultar() {
        List<Veiculo> registros =
                List.of(
                        new Veiculo("ABC-123", "carro", "azul", 2020),
                        new Veiculo("ZXC-456", "caminhao", "prata", 2022)
                );
        Mockito.when(veiculoRepository.findAll()).thenReturn(registros);
        List<Veiculo> veiculoList = veiculoService.consultar();
        assertEquals(2, veiculoList.size());
        assertEquals("ABC-123", veiculoList.get(0).getPlaca());
    }
    @Test
    @DisplayName("Lista vazia veiculos cadastrados")
    void consultar_vazio() {
        List<Veiculo> veiculosList = veiculoService.consultar();
        assertTrue(veiculosList.isEmpty());
    }

    @Test
    @DisplayName("Consulta veiculo pela placa")
    void consultaId() {
        Veiculo veiculo = new Veiculo("ABC-123", "carro", "azul", 2020);
        Mockito.when(veiculoRepository.findById(Mockito.anyString())).thenReturn(Optional.of(veiculo));
        Veiculo resultado = veiculoService.consultaId("ABC-123");
        assertNotNull(resultado);
        assertEquals(veiculo, resultado);
    }
    @Test
    @DisplayName("Consulta veiculo pela placa com erro")
    void consulta_erro() {
        Mockito.when(veiculoRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());
        assertThrows(RegistroNaoEncontradoException.class, () -> veiculoService.consultaId("ABC-123"));
    }


    @Test
    @DisplayName("Deleta veiculo")
    void deletaVeiculo() {
        Veiculo veiculo = new Veiculo("ABC-123", "carro", "azul", 2020);
        Mockito.when(veiculoRepository.existsById(Mockito.anyString())).thenReturn(true);
        Mockito.when(veiculoRepository.findById(Mockito.anyString())).thenReturn(Optional.of(veiculo));
        assertDoesNotThrow(() -> veiculoService.deletaVeiculo(veiculo.getPlaca()));
    }

    @Test
    @DisplayName("Deleta veiculo erro, sem placa cadastrada")
    void deletaVeiculo_erro_placa() {
        Mockito.when(veiculoRepository.existsById(Mockito.anyString())).thenReturn(false);
        assertThrows(RegistroExistenteException.class, () -> veiculoService.deletaVeiculo("ABC-123"));
    }

    @Test
    @DisplayName("Deleta veiculo erro, com multas")
    void deletaVeiculo_erro_multa() {
        Veiculo veiculo = new Veiculo("ABC-123", "carro", "azul", 2020,1);
        Mockito.when(veiculoRepository.existsById(Mockito.anyString())).thenReturn(true);
        Mockito.when(veiculoRepository.findById(Mockito.anyString())).thenReturn(Optional.of(veiculo));
        assertThrows(VeiculoComMultasException.class, () -> veiculoService.deletaVeiculo(veiculo.getPlaca()));
    }

    @Test
    @DisplayName("Adiciona multa no veiculo")
    void adicionarMulta() {
        Veiculo veiculo = new Veiculo("ABC-123", "carro", "azul", 2020);
        Mockito.when(veiculoRepository.findById(Mockito.anyString())).thenReturn(Optional.of(veiculo));
        Veiculo resposta = veiculoService.adicionarMulta("ABC-123");
        assertEquals(1, veiculo.getQtdMultas());
    }
    @Test
    @DisplayName("Adiciona multa no veiculo, erro placa não encontrada")
    void adicionarMulta_erro() {
        Mockito.when(veiculoRepository.findById(Mockito.anyString())).thenReturn(Optional.empty());
        assertThrows(RegistroNaoEncontradoException.class, () -> veiculoService.adicionarMulta("ABC-123"));
    }
}