const somaRest = (a=0, b=0, ...args) => {
    let sum = 0;
    if(args.length == 0){
        sum = a + b;
    }else{
        for(let i = 0; i < args.length; i++){
            sum += args[i]
        }
        sum += a + b
    }
    console.log(sum)
}

somaRest(15,15,15,15)