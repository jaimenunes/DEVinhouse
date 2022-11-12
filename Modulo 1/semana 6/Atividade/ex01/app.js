function sleep(valor) {
  return new Promise((resolve, reject) => {
    setTimeout(() => resolve(valor), 3000);
  });
}

sleep("Passou aqui").then((resultado) => {
  console.log(resultado);
});
