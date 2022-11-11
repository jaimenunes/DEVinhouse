const main = document.getElementById('main')

const getUsers = async(number) =>{
    const response = await fetch(`https://randomuser.me/api/?results=${number}`)
    const data = await response.json()
    try{
        return data.results
    }
    catch{
        console.log('erro')
    }
}

async function user(){
    const resultado = await getUsers(10)
    resultado.forEach(user=>{
        imprime(user)
    })
}

function imprime(user){
    let divMain = document.createElement('div')
    let divInfo = document.createElement('div')
    let image = document.createElement('img')
    let pName =  document.createElement('p')
    let pEmail =  document.createElement('p')
    let pAdress =  document.createElement('p')
    divInfo.classList.add('info')
    image.src = user.picture.large
    pName.innerText = `${user.name.title} ${user.name.first} ${user.name.last}`
    pEmail.innerText = user.email
    pAdress.innerText = `${user.location.street.name} - ${user.location.street.number} ${user.location.state} - ${user.location.city} - ${user.location.country}`
    divMain.appendChild(image)
    divInfo.appendChild(pName)
    divInfo.appendChild(pEmail)
    divInfo.appendChild(pAdress)
    divMain.appendChild(divInfo)
    main.appendChild(divMain)
}
window.addEventListener('load', user)