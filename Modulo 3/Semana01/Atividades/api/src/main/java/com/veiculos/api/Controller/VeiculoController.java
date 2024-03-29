package com.veiculos.api.Controller;

import com.veiculos.api.Controller.Requests.VeiculoRequest;
import com.veiculos.api.Controller.Responses.VeiculoResponse;
import com.veiculos.api.Model.Veiculo;
import com.veiculos.api.Service.VeiculoService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/veiculos")
@Slf4j
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;

    private ModelMapper modelMapper = new ModelMapper(); // criando instancia pq só será usado aquo

    @PostMapping
    public ResponseEntity<VeiculoResponse> adicionar(@RequestBody VeiculoRequest request) {
        Veiculo veiculo = modelMapper.map(request, Veiculo.class);
        veiculo = veiculoService.inserir(veiculo);
        var resp = modelMapper.map(veiculo, VeiculoResponse.class);
        return ResponseEntity.created(URI.create(veiculo.getPlaca())).body(resp);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoResponse>> consultaTodosVeiculos(){
        List<Veiculo> veiculos = veiculoService.consultar();
        List<VeiculoResponse> responses = veiculos.stream()
                .map(v -> modelMapper.map(v, VeiculoResponse.class)).toList();
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/{placa}")
    public ResponseEntity<VeiculoResponse> consultaVeiculo(@PathVariable("placa") String placa){
        Veiculo veiculo = veiculoService.consultaId(placa);
        VeiculoResponse response = modelMapper.map(veiculo, VeiculoResponse.class);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{placa}")
    public ResponseEntity deletaVeiculo(@PathVariable("placa") String placa){
        veiculoService.deletaVeiculo(placa);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{placa}/multas")
    public ResponseEntity<VeiculoResponse> adicionaMulta(@PathVariable("placa") String placa){
        var veiculo = veiculoService.adicionarMulta(placa);
        var resp = modelMapper.map(veiculo, VeiculoResponse.class);
        return ResponseEntity.ok(resp);
    }
}
