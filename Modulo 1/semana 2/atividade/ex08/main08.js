var count = 0;
for (let i = 2; i <= 1000; i++) {
  var divisores = 0;
  var number = i;
  for (let j = 1; j <= number; j++) {
    if (number % j == 0) {
      divisores++;
    }
  }
  if (divisores == 2) {
    console.log(number);
    count++;
  }
}
console.log(`No total são ${count} números primos.`);
