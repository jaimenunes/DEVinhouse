package com.veiculos.api.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "veiculo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo {
    @Id
    private String placa;
    private String tipoVeiculo;
    private String cor;
    private Integer anoDeFabricacao;
    private Integer qtdMultas;
}
