package com.philips.contas.controller;

import com.philips.contas.model.Conta;
import com.philips.contas.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ContaController {
    private final ContaService contaService;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")

    @Autowired
    public ContaController(ContaService contaService){
        this.contaService = contaService;
    }
    public void addConta(Conta conta){
        contaService.addConta(conta);
    }

    public List<Conta> retornaLista(){
        return contaService.retornaLista();
    }
    public void deletaConta(int id){
        contaService.deletaConta(id);
    }
    public void alteraConta(int id,Conta conta){
        contaService.alteraConta(id, conta);
    }

    public Conta encontraConta(int id){
        return contaService.encontraConta(id);
    }

    public void deposito(int id, Integer valor){
        contaService.deposito(id, valor);
    }

    public void saque(int id, Integer valor){
        contaService.saque(id, valor);
    }
}
