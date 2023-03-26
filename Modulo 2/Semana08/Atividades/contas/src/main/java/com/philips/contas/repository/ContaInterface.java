package com.philips.contas.repository;

import com.philips.contas.model.Cliente;
import com.philips.contas.model.Conta;

import java.util.List;

public interface ContaInterface {
    void addConta(Conta conta);
    List<Conta> retornaLista();

    void deletaConta(Integer id);
    void alteraConta(Integer id, Conta conta);

    Conta encontraConta(Integer id);
    void deposito(Integer id, Integer valor);

    void saque(Integer id, Integer valor);

    List<Conta> transferencia(Integer idContaSaque, Integer idContaDeposito, Integer valor);
}
