package com.philips.contas.repository;

import com.philips.contas.model.Conta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ContaRepository implements ContaInterface{
    private static List<Conta> listaContas = new ArrayList<>();

    @Override
    public void addConta(Conta conta){
            listaContas.add(conta);
    }

    @Override
    public List<Conta> retornaLista(){
        return listaContas;
    }
    @Override
    public void deletaConta(Integer id){
        int index = id - 1;
        listaContas.remove(index);
    }
    @Override
    public void alteraConta(Integer id,Conta conta){
        int index = id -1;
        conta.setId(id);
        listaContas.set(index, conta);
    }

    @Override
    public Conta encontraConta(Integer id){
        int index = id -1;
        return listaContas.get(index);
    }

    @Override
    public void deposito(Integer id, Integer valor){
        int index = id -1;
        Conta conta = listaContas.get(index);
        Integer novoSaldo = conta.getSaldo() + valor;
        conta.setSaldo(novoSaldo);
    }

    @Override
    public void saque(Integer id, Integer valor){
        int index = id - 1;
        Conta conta = listaContas.get(index);
        int novoSaldo = conta.getSaldo() - valor;
        if(novoSaldo >= 0){
            conta.setSaldo(novoSaldo);
        }else{
            System.out.println("A conta não possui saldo para realizar essa transação");
        }
    }
    @Override
    public List<Conta> transferencia(Integer idContaSaque, Integer idContaDeposito, Integer valor){
        List<Conta> contasAtualizadas = new ArrayList<>();
        saque(idContaSaque, valor);
        deposito(idContaDeposito, valor);
        Conta saque = encontraConta(idContaSaque);
        Conta deposito = encontraConta(idContaDeposito);
        contasAtualizadas.add(saque);
        contasAtualizadas.add(deposito);
        return contasAtualizadas;
    }
}
