export default class Fatura {
  constructor(id, descricao, quantia, preco) {
    this.id = id;
    this.descricao = descricao;
    quantia < 0 ? (this.quantia = 0) : (this.quantia = quantia);
    preco < 0 ? (this.preco = 0) : (this.preco = preco);
  }

  obterValorTotal() {
    return this.quantia * this.preco;
  }

  get valorTotal() {
    return this.quantia * this.preco;
  }
}
