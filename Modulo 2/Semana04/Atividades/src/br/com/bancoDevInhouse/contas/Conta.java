package br.com.bancoDevInhouse.contas;

abstract public class Conta {
    private Double saldo = 0d;

    protected Double obterSaldo(){
        return this.saldo;
    }

    protected void setSaldo(Double valor){
        this.saldo = valor;
    }


}
