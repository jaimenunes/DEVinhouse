package br.com.bancoDevInhouse.produto;

import br.com.bancoDevInhouse.produto.interfaces.Tributavel;

public class Produto implements Tributavel {
    private Double valor;
    private Double valorImposto;

    public Produto(Double valor, Double valorImposto){
        this.valor = valor;
        this.valorImposto = valorImposto;
    }
    @Override
    public Double CalcularValorComImposto() {
        return valor + valorImposto;
    }
}
