export default class Juros{
    constructor(capitalInicial, taxaAplicada, tempo){
        this.capitalInicial = capitalInicial;
        this.taxaAplicada = taxaAplicada;
        this.tempo = tempo
    }

    calcularJurosSimples(){
        let taxa = this.taxaAplicada / 100
        return (this.capitalInicial * taxa * this.tempo).toFixed(2)
    }

    calcularJurosComposto(){
        let taxa = this.taxaAplicada / 100
        return (this.capitalInicial * (1 + taxa) ** this.tempo).toFixed(2)
    }
}