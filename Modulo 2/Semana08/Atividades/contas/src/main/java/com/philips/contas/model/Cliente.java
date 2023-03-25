package com.philips.contas.model;

import lombok.*;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@ToString
public class Cliente {
    private long id;
    @NotBlank
    private final String nome;
    @CPF(message = "CPF inválido")
    private final String CPF;
    private static List<Cliente> listaClientes= new ArrayList<Cliente>();

    public void addCliente(Cliente cliente){
        listaClientes.add(cliente);
    }
    public List<Cliente> retornaLista(){
        return listaClientes;
    }

    public void deletarCliente(int id){
        listaClientes.remove(id);
    }

    public Cliente encontrarCliente(int id){
        int index = id - 1;
        return listaClientes.get(index);
    }

    public void alterarCliente(int id, Cliente cliente){
        listaClientes.add(id, cliente);
    }

}
