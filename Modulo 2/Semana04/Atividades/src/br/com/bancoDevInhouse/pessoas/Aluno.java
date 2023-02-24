package br.com.bancoDevInhouse.pessoas;

public class Aluno extends Pessoa{
    private String matricula;

    public Aluno(String matricula, String nome, String sobrenome){
        super(nome, sobrenome);
        this.matricula = matricula;
    }

    public String registrar(){
        return "Sou o " + obterNomeCompleto() + " e minha matricula é " + this.matricula;
    }
}
