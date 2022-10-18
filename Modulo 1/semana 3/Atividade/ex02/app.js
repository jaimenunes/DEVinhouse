
const btnInput = document.getElementById("submit")
const text = document.getElementById("text")
const menssagemOla = (nome) =>{
    console.log(`Olá, ${nome}`)
    text.innerHTML = `Olá, ${nome}!`
}
btnInput.addEventListener('click', ()=> {
    const nomeInput = document.getElementById("nomeInput")
    menssagemOla(nomeInput.value),
    nomeInput.value=''
    }  
)
