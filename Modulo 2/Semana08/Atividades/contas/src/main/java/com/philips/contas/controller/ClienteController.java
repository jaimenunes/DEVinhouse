package com.philips.contas.controller;

import com.philips.contas.model.Cliente;
import com.philips.contas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/cliente")

@RestController
public class ClienteController {
    private final ClienteService clienteService;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")

    @Autowired
    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping
    public void addCliente(@RequestBody Cliente cliente){
        clienteService.addCliente(cliente);
    }

    @GetMapping
    public List<Cliente> retornaLista() {
        return clienteService.retornaLista();
    }
    @GetMapping(path = "{id}")
    public Cliente encontrarCliente(@PathVariable("id") int id){
        return clienteService.encontrarCliente(id);
    }
    @DeleteMapping(path = "{id}")
    public void deletarCliente(@PathVariable("id") int id){
        clienteService.deletarCliente(id);
    }
    @PutMapping(path = "{id}")
    public void alterarCliente(@PathVariable("id") int id, @RequestBody Cliente cliente){
        clienteService.alterarCliente(id, cliente);
    }
}
