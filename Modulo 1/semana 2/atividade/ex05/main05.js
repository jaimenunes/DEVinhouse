var number = prompt("Digite um valor inteiro");
var value = parseInt(number);
var par = 0;
var impar = 0;
for (let i = 0; i <= value; i++) {
  if (i % 2 == 0) {
    par++;
  } else {
    impar++;
  }
}
alert(
  `entre o número 0 e ${number} existem ${impar} números impares e ${par} números pares`
);
