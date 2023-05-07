package com.veiculos.api.Controller.Responses;

import lombok.*;

@Data
public class VeiculoResponse {
    private String placa;
    private String tipoVeiculo;
    private String cor;
    private Integer anoDeFabricacao;
    private Integer qtdMultas;
}
