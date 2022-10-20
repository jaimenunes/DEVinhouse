let palavra = "ana";

const palindromoFinder = (text) => {
  if (typeof text !== "string") {
    console.log("Insira uma palavra ou frase");
  }
  let newText = text.toLowerCase().split("").reverse().join("");

  newText == text ? console.log(newText == text) : console.log(newText == text);
};

palindromoFinder(palavra);
