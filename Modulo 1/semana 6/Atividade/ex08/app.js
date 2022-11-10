const main = document.getElementById('main')
const users = async(number) =>{
    const response = await fetch(`https://randomuser.me/api/?results=${number}`)
    const data = await response.json()
    try{
        return data.results
    }
    catch{
        console.log('erro')
    }
}

async function imprime(){
    const resultado = await users(10)
    console.log(resultado)
    resultado.forEach(element => {
        let divMain = document.createElement('div')
        let image = document.createElement('img')
        image.src = element.picture.large
        divMain.appendChild(image)
        let divInfo = document.createElement('div')
        divInfo.classList.add('info')
        let pName =  document.createElement('p')
        pName.innerText = `${element.name.title} ${element.name.first} ${element.name.last}`
        divInfo.appendChild(pName)
        let pEmail =  document.createElement('p')
        pEmail.innerText = element.email
        divInfo.appendChild(pEmail)
        let pAdress =  document.createElement('p')
        pAdress.innerText = `${element.location.street.name} - ${element.location.street.number} ${element.location.state} - ${element.location.city} - ${element.location.country}`
        divInfo.appendChild(pAdress)
        divMain.appendChild(divInfo)
        main.appendChild(divMain)
    });
}

imprime()