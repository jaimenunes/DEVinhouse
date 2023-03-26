package com.philips.contas.repository;

import com.philips.contas.model.Cliente;

import java.util.List;

public interface ClienteInterface {
    void salvarCliente(Cliente cliente);
     List<Cliente> retornaLista();
    void deletarCliente(int id);
    Cliente encontrarCliente(int id);
    void alterarCliente(int id, Cliente cliente);
}
