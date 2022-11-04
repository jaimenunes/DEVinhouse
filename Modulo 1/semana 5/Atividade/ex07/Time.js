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

    computarPartida(partida){
        if(partida.siglaTimeA == this.sigla){
            if(partida.golsTimeA > partida.golsTimeB){
                this.vitorias++
            }else if(partida.golsTimeA < partida.golsTimeB){
                this.derrotas++
            }else{
                this.empates++
            }
            this.golsMarcados += partida.golsTimeA
            this.golsSofridos += partida.golsTimeB
        }else if(partida.siglaTimeB == this.sigla){
            if(partida.golsTimeB > partida.golsTimeA){
                this.vitorias++
            }else if(partida.golsTimeB < partida.golsTimeA){
                this.derrotas++
            }else{
                this.empates++
            }
            this.golsMarcados += partida.golsTimeB
            this.golsSofridos += partida.golsTimeA
        }else{
            throw Error('Time informado incorretamente')
        }
    }

    exibirSituação(){
        console.log(
            `nome: ${this.nome},
             sigla: ${this.sigla},
             vitórias: ${this.vitorias},
             derrotas: ${this.derrotas},
             empates: ${this.empates},
             gols marcados: ${this.golsMarcados},
             gols sofridos: ${this.golsSofridos}
             jogos: ${this.numeroDeJogos},
             pontos: ${this.numeroDePontos}
            `
        )
    }
}