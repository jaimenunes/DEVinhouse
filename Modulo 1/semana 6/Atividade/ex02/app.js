function getDate() {
  const date = new Date();
  const seg =
    date.getSeconds() < 10 ? `0` + date.getSeconds() : "" + date.getSeconds();
  console.log(`${date.getHours()}:${date.getMinutes()}:${seg}`);
}
setInterval(getDate, 2000);
