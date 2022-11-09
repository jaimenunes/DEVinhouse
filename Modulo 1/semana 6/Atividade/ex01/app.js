function sleep(valor) {
  new Promise((resolve, reject) => {
    setTimeout(resolve, 3000, valor);
  }).then((res) => console.log(`O parametro passado foi ${valor}`));
}

sleep("Passou aqui");
