const pessoa = {
    nome: 'Ada',
    idade: 36,
    profissao: 'matemática'
  };

  const destruct = ({nome, idade, profissao}) =>{
      return `Esta é ${nome}, tem ${idade} anos e é ${profissao}`
  }

  console.log(destruct(pessoa))