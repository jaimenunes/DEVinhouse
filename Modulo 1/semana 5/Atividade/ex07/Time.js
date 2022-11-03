export default class Time{
    constructor(nome, sigla, vitorias, empates, derrotas, golsMarcados, golsSofridos){
        this.nome = nome;
        this.sigla = sigla;
        this.vitorias = vitorias;
        this.empates = empates;
        this.derrotas = derrotas;
        this.golsMarcados = golsMarcados;
        this.golsSofridos = golsSofridos;
    }

    get numeroDeJogos(){
        return this.vitorias + this.empates + this.derrotas
    }

    get numeroDePontos(){
        return (this.vitorias * 3) + (this.empates * 1) + (this.derrotas * 0)

    }
}