import Juros from "./Juros.js";

const jurosSimples = new Juros(10000, 7, 24)
console.log(jurosSimples.calcularJurosSimples())

const jurosComposto = new Juros(10000, 15, 10)
console.log(jurosComposto.calcularJurosComposto())