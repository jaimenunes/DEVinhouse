package com.philips.contas.repository;

import com.philips.contas.model.Conta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContaRepository implements ContaInterface{
    private final List<Conta> listaContas = new ArrayList<>();

    @Override
    public void addConta(Conta conta){
        listaContas.add(conta);
    }

    @Override
    public List<Conta> retornaLista(){
        return listaContas;
    }
    @Override
    public void deletaConta(int id){
        int index = id - 1;
        listaContas.remove(index);
    }
    @Override
    public void alteraConta(int id,Conta conta){
        int index = id -1;
        listaContas.set(index, conta);
    }

    @Override
    public Conta encontraConta(int id){
        int index = id -1;
        return listaContas.get(index);
    }

    @Override
    public void deposito(int id, Integer valor){
        int index = id -1;
        Conta conta = listaContas.get(index);
        Integer novoSaldo = conta.getSaldo() + valor;
        conta.setSaldo(novoSaldo);
    }

    @Override
    public void saque(int id, Integer valor){
        int index = id -1;
        Conta conta = listaContas.get(index);
        Integer novoSaldo = conta.getSaldo() - valor;
        if(novoSaldo >= 0){
            conta.setSaldo(novoSaldo);
        }else{
            System.out.println("A conta não possui saldo para realizar essa transação");
        }
    }
}
