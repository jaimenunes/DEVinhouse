const uneDobraRetorna = (arr, ...args) =>{
    if(!Array.isArray(arr)){
        console.log('Um array deve ser informado como primeiro parametro')
        return
    }
    if(args.length == 0){
        return arr
    }else{
        for(let i = 0; i < args.length; i++){
            let newValue = args[i] * 2
            arr.push(newValue)
        }
        return arr
    }
}

const r1 = uneDobraRetorna([1, 2, 3], 4, 4)
console.log(r1) // [1, 2, 3, 8, 8]

const r2 = uneDobraRetorna([2], 10, 4, 8) 
console.log(r2) // [2, 20, 8, 16]

const r3 = uneDobraRetorna([6, 8]) 
console.log(r3) // [6, 8]