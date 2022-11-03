import Fatura from "./Fatura.js";

const melao = new Fatura(123, "Melão", 5, 5);

const valor = melao.obterValorTotal();
const valorGet = melao.valorTotal;

console.log(valor); // 6
console.log(valorGet); // 6
