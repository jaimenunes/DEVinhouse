const retornoEmpresa1 = new Promise((resolve, reject) => {
  setTimeout(resolve, 2000, "Empresa 1");
});

const retornoEmpresa2 = new Promise((resolve, reject) => {
  setTimeout(resolve, 5000, "Empresa 2");
});

Promise.race([retornoEmpresa1, retornoEmpresa2])
  .then((value) => console.log(value))
  .catch((erro) => console.log(erro))
  .finally(() => {
    console.log("Essa empresa foi mais rápida");
  });
