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
    const resultado = await users(4)
    console.log(resultado)
    resultado.forEach(element => {
        let div = document.createElement('div')
        let image = document.createElement('img')
        image.src = element.picture.large
        let p =  document.createElement('p')
        p.innerHTML = element.name.first
        div.appendChild(image)
        div.appendChild(p)
        main.appendChild(div)
    });
}

imprime()