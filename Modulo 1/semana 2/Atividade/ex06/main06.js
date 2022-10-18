var operador = prompt("escolha o operador '*', '+', '-', '/'");
var value1 = prompt("Qual o primeiro valor?");
var value2 = prompt("Qual o segundo valor?");
var num1 = parseInt(value1);
var num2 = parseInt(value2);
var resultado = 0;
if (operador == "+") {
  resultado = num1 + num2;
} else if (operador == "-") {
  resultado = num1 - num2;
} else if (operador == "*") {
  resultado = num1 * num2;
} else {
  resultado = num1 / num2;
}
alert(`O resultado do cálculo é: ${resultado}`);
