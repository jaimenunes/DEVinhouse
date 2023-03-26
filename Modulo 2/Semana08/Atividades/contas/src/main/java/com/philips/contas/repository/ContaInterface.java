package com.philips.contas.repository;

import com.philips.contas.model.Cliente;
import com.philips.contas.model.Conta;

import java.util.List;

public interface ContaInterface {
    void addConta(Conta conta);
    List<Conta> retornaLista();

    void deletaConta(int id);
    void alteraConta(int id, Conta conta);

    Conta encontraConta(int id);
    void deposito(int id, Integer valor);

    void saque(int id, Integer valor);
}
