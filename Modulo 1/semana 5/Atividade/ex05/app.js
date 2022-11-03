import CalculadoraDeArea from "./CalculadoraDeArea.js";

const quadrado = new CalculadoraDeArea('quadrado', 4, 4)
console.log(quadrado.calcular())

const triangulo = new CalculadoraDeArea('triangulo', 6, 8)
console.log(triangulo.calcular())

const retangulo = new CalculadoraDeArea('retangulo', 4, 6)
console.log(retangulo.calcular())