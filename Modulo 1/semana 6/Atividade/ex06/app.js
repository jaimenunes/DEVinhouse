
const getAge = async (name) =>{
    const response = await fetch(`https://api.agify.io/?country_id=BR&name=${name}`)
    const data = await response.json()
    console.log(`A média de idade do nome ${data.name} no Brasil é de ${data.age} anos`)
}

getAge('jaime')