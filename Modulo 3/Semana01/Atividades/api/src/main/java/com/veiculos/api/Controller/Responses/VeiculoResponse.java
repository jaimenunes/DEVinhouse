package com.veiculos.api.Controller.Responses;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoResponse {
    private String placa;
    private String tipoVeiculo;
    private String cor;
    private Integer anoDeFabricacao;
}
