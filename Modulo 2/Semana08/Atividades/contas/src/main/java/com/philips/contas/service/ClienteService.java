package com.philips.contas.service;

import com.philips.contas.model.Cliente;
import com.philips.contas.model.Conta;
import com.philips.contas.repository.ClienteInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteInterface clienteInterface;
    @Autowired
    public ClienteService(ClienteInterface clienteInterface){
        this.clienteInterface = clienteInterface;
    }
    public void addCliente(Cliente cliente){
        clienteInterface.salvarCliente(cliente);
    }

    public List<Cliente> retornaLista() {
        return clienteInterface.retornaLista();
    }

    public Cliente encontrarCliente(int id) {
        return clienteInterface.encontrarCliente(id);
    }

    public void deletarCliente(int id) {
        clienteInterface.deletarCliente(id);
    }

    public void alterarCliente(int id, Cliente cliente){
        clienteInterface.alterarCliente(id, cliente);
    }
}
