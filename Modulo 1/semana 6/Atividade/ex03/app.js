function aprovarDadosCadastrais(cliente) {
  return new Promise((resolve, reject) => {
    if (cliente.cpf === 111) {
      resolve(true);
    } else {
      reject(false);
    }
  });
}

function aprovarValorSolicatiado(cliente, valor) {
  return new Promise((resolve, reject) => {
    if (cliente.margem >= valor) {
      resolve(true);
    } else {
      reject(false);
    }
  });
}

const cliente = { cpf: 111, margem: 3000, nome: "Jaime" };
const aprovarDados = aprovarDadosCadastrais(cliente);
const aprovarValor = aprovarValorSolicatiado(cliente, 2000);

Promise.all([aprovarDados, aprovarValor])
  .then(() => console.log("APROVADO"))
  .catch(() => console.log("REPROVADO"))
  .finally(() => console.log("Fim do Processamento"));
