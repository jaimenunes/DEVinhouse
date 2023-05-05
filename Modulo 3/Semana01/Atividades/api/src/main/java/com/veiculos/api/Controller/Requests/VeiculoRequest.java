package com.veiculos.api.Controller.Requests;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class VeiculoRequest {
    private String placa;
    private String tipoVeiculo;
    private String cor;
    private Integer anoDeFabricacao;
    private Integer qtdMultas;
}
