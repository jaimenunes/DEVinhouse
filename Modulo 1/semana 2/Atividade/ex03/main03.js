var numero = prompt("Qual número deseja verficar a tabuada? (número inteiro)");
var texto = "";
for (let i = 0; i <= 10; i++) {
  texto += `${numero} x ${i} = ${numero * i} \n`;
}
alert(texto);
