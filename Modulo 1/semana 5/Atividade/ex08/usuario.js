export default class Usuario{
    constructor(nome, email, senha){
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    autenticar(emailInformado, senhaInformada){
        return (this.email === emailInformado && senhaInformada === this.senha)
    }
}