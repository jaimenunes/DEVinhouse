package com.minimarket.miniMarket.service;

import com.minimarket.miniMarket.model.Cliente;
import com.minimarket.miniMarket.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    ClienteRepository clienteRepository;
    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public void salvar(Cliente cliente){
        clienteRepository.save(cliente);
    }
}
