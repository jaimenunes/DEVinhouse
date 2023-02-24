package br.com.bancoDevInhouse.contas;

import br.com.bancoDevInhouse.contas.interfaces.Operavel;

public class ContaCorrente extends Conta implements Operavel {
    @Override
    public void depositar(Double valor) {
        Double valorAnterior = obterSaldo();
        Double valorAtual = valorAnterior + valor;
        setSaldo(valorAtual);
    }

    @Override
    public void sacar(Double valor) {
        Double valorAnterior = obterSaldo();
        Double valorAtual = valorAnterior - valor;
        setSaldo(valorAtual);
    }

    @Override
    public Double obterSaldo() {
        return super.obterSaldo();
    }
}
