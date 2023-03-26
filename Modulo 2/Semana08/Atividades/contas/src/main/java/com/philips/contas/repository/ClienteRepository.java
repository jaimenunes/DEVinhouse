package com.philips.contas.repository;

import com.philips.contas.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository implements ClienteInterface {
    private static List<Cliente> listaClientes= new ArrayList<Cliente>();
    @Override
    public void salvarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }
    @Override
    public List<Cliente> retornaLista() {
        return listaClientes;
    }

    @Override
    public void deletarCliente(int id) {
        int index = id - 1;
        listaClientes.remove(index);
    }
    @Override
    public Cliente encontrarCliente(int id) {
        int index = id - 1;
        return listaClientes.get(index);
    }
    @Override
    public void alterarCliente(int id, Cliente cliente) {
        int index = id - 1;
        listaClientes.set(index, cliente);
    }
}
