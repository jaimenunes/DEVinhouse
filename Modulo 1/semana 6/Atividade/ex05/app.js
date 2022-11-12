function obterClienteNoBancoDeDados(idCliente) {
  try {
    const cliente = { nome: "bruce wayne", id: idCliente };
    return cliente;
  } catch {
    console.log("Error");
  } finally {
    console.log("O cliente encontrado foi:");
  }
}

async function processar() {
  const cliente = await obterClienteNoBancoDeDados(7);
  console.log(cliente);
}

processar();
