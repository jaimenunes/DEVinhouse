const bitcoinToday = async() =>{
    const response = await fetch('https://api.coincap.io/v2/assets/bitcoin')
    const data = await response.json()
    let symbol = data.data.symbol
    let preco = parseFloat(data.data.priceUsd).toFixed(2)
    console.log(`O preço do bitcoin ${symbol} em dólares é $ ${preco}`)
}

bitcoinToday()