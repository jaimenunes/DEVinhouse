package com.veiculos.api.Controller;

import com.veiculos.api.Controller.Requests.VeiculoRequest;
import com.veiculos.api.Controller.Responses.VeiculoResponse;
import com.veiculos.api.Service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {
    @Autowired
    private VeiculoService veiculoService;


    @PostMapping
    public ResponseEntity<VeiculoResponse> cadastraVeiculo(@RequestBody VeiculoRequest request){

    }

    @GetMapping
    public ResponseEntity<List<VeiculoResponse>> consultaTodosVeiculos(){

    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoResponse> consultaVeiculo(@PathVariable("id") String id){

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VeiculoResponse> deletaVeiculo(@PathVariable("id") String id){

    }

    @PutMapping("/{id}/multas")
    public ResponseEntity<VeiculoResponse> adicionaMulta(@PathVariable("id") String id){

    }
}
