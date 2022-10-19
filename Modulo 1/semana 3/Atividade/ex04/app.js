const object1 = {a: 1, b:2}
const object2 = {c: 3, d:4}

const concatObject = (obj1, obj2) =>{
    let novoObj = {
        ...obj1,
        ...obj2
    }
    console.log(novoObj)
}
concatObject(object1, object2)