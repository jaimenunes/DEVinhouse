var sum = 0;
var numero = prompt("Escolha um número para iniciar");
var value = parseInt(numero);
while (value != -1) {
  sum += value;
  numero = prompt("próximo número para soma (-1 para encerrar)");
  var value = parseInt(numero);
}
alert(sum);
