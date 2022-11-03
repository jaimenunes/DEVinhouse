class Animal {
  constructor(nome, idade, som) {
    this.nome = nome;
    this.idade = idade;
    this.som = som;
  }
}

export class Cachorro extends Animal {
  constructor(nome, idade) {
    super(nome, idade, "latido");
  }
}

export class Gato extends Animal {
  constructor(nome, idade) {
    super(nome, idade, "miado");
  }
}
