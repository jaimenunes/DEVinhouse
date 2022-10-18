const resultado = document.getElementById("resultado");
let valor = prompt("Valor de ínicio?");
let raizString = prompt("Valor de raíz?");
let inicio = parseInt(valor);
let raiz = parseInt(raizString);
let sum = inicio;
for (let i = 1; i < 10; i++) {
  sum += raiz;
}

resultado.innerHTML = `Resultado é ${sum}`;
