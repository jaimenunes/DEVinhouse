package com.philips.contas.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
public class Conta {
    private int id;
    private static int IdCounter = 0;
    private Integer saldo = 0;
    private Cliente cliente;
    public Conta(@JsonProperty("cliente") Cliente cliente){
        this.cliente = cliente;
        this.id = IdCounter++;
    }
}
