package com.philips.contas.model;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class Cliente {
    private int id;
    private static int IdCounter = 0;

    @NotBlank
    private final String nome;
    @CPF(message = "CPF inválido")
    private final String CPF;
    public Cliente(String nome, String cpf){
        this.id = IdCounter++;
        this.nome = nome;
        this.CPF = cpf;
    }
}
