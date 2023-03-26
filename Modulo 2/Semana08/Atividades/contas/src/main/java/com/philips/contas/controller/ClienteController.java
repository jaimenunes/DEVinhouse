package com.philips.contas.controller;

import com.philips.contas.model.Cliente;
import com.philips.contas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;

public class ClienteController {
    private final ClienteService clienteService;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")

    @Autowired
    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    public void addCliente(Cliente cliente){
        clienteService.addCliente(cliente);
    }
    public Cliente encontrarCliente(int id){
        return clienteService.encontrarCliente(id);
    }
    public void deletarCliente(int id){
        clienteService.deletarCliente(id);
    }
    public void alterarCliente(int id, Cliente cliente){
        clienteService.alterarCliente(id, cliente);
    }
}
