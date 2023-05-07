package com.veiculos.api.Controller.Requests;

import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoRequest {
    private String placa;
    private String tipoVeiculo;
    private String cor;
    private Integer anoDeFabricacao;
}
