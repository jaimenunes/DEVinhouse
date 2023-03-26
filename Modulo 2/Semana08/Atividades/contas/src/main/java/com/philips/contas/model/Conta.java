package com.philips.contas.model;


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
    public Conta(Cliente cliente){
        this.cliente = cliente;
        this.id = IdCounter++;
    }
}
