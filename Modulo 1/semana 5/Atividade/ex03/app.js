import Personagem from "./Personagem.js";

let personagem = new Personagem("Jaime");

personagem.sofreuDano(5);
console.log(personagem.percentualVida);

personagem.usouKitMedico();
console.log(personagem.percentualVida);
