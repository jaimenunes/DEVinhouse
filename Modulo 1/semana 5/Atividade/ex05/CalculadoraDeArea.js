export default class CalculadoraDeArea{
    constructor(tipo, base, altura){
        this.tipo = tipo
        this.base = base
        this.altura = altura
    }

    calcular(){
        let newTipo = this.tipo.toUpperCase()
        if(newTipo === "QUADRADO" || newTipo === "RETANGULO"){
            return this.base * this.altura
        }else if(newTipo === "TRIANGULO"){
            return ( this.base * this.altura ) / 2
        }
    }
}