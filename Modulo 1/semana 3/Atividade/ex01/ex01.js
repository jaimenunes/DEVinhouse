// function procuraMinMax(arr){
//     if(arr === null || arr == undefined || arr.length == 0){
//         console.log("Não é possível encontrar")
//     }else{
//         let menor = Math.min(...arr)
//         let maior = Math.max(...arr)
//         console.log(`O menor valor é ${menor} e o maior valor é ${maior}`)
//     }    
// }

const procuraMinMax = (arr) =>{
    if(arr === null || arr == undefined || arr.length == 0){
        console.log("Não é possível encontrar")
    }else{
        let menor = Math.min(...arr)
        let maior = Math.max(...arr)
        console.log(`O menor valor é ${menor} e o maior valor é ${maior}`)
    }    
}

procuraMinMax([56, 65, 64, -3, 23, 42, -15, 65, 14, 32, 78, 70, 47])
procuraMinMax([])
procuraMinMax([1])
procuraMinMax([1, -1])
procuraMinMax(null)
procuraMinMax([-2,-2,-2,-2])
procuraMinMax([20,10, 30])