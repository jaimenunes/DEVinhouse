import Usuario from "./usuario.js";

const form = document.getElementById('formUsuario')
const usuario = new Usuario('Jaime', 'test@test.com', '123456789')

form.addEventListener('submit', ()=>{
    event.preventDefault();
    const email = event.target.email.value;
    const senha = event.target.senha.value;
    const verifica = usuario.autenticar(email, senha)
    !verifica ? falha() : sucesso()
})

function falha(){
    alert("Credenciais inválidas, tente novamente!")
    form.classList.add('wrong')
}
function sucesso(){
    alert("Autenticação realizada com sucesso!")
    form.classList.remove('wrong')
    form.classList.add('sucess')
}