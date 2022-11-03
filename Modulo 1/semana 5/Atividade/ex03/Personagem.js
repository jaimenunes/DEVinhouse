export default class Personagem {
  constructor(nome) {
    this.nome = nome;
    this.percentualVida = 100;
  }

  sofreuDano(percentualDano) {
    let vidaAtual = this.percentualVida - percentualDano;
    this.percentualVida = vidaAtual;
    if (this.percentualVida <= 0) {
      console.log("Seu personagem morreu!!");
      return;
    }
  }

  usouKitMedico() {
    this.percentualVida += 10;
    this.percentualVida > 100
      ? (this.percentualVida = 100)
      : this.percentualVida;
  }
}
