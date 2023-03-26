package com.philips.contas.service;

import com.philips.contas.model.Conta;
import com.philips.contas.repository.ContaInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    private final ContaInterface contaInterface;
    @Autowired

    public ContaService(ContaInterface contaInterface){
        this.contaInterface = contaInterface;
    }

    public void addConta(Conta conta){
       contaInterface.addConta(conta);
    }

    public List<Conta> retornaLista(){
        return contaInterface.retornaLista();
    }
    public void deletaConta(Integer id){
        contaInterface.deletaConta(id);
    }
    public void alteraConta(Integer id,Conta conta){
        contaInterface.alteraConta(id, conta);
    }

    public Conta encontraConta(Integer id){
        return contaInterface.encontraConta(id);
    }

    public void deposito(Integer id, Integer valor){
        contaInterface.deposito(id, valor);
    }

    public void saque(Integer id, Integer valor){
        contaInterface.saque(id, valor);
    }

    public List<Conta> transferencia(Integer idContaSaque, Integer idContaDeposito, Integer valor){
        return contaInterface.transferencia(idContaSaque, idContaDeposito, valor);
    }
}
