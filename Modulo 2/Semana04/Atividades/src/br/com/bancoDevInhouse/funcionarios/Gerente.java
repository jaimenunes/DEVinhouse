package br.com.bancoDevInhouse.funcionarios;

final public class Gerente extends Funcionario{
    @Override
    public String obterCargo() {
        return "Sou Gerente";
    }
}
