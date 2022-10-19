const makeArray = (arr1, arr2) =>{
    if(!Array.isArray(arr1) || !Array.isArray(arr2)){
        console.log("deve ser informado dois arrays")
        return
    }
    let novoArray = arr1.concat(...arr2)
    console.log(novoArray)
}

makeArray([1, 2, 3], [4, 5, 6])