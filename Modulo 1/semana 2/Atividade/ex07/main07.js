let date = new Date();
let days = date.getDate();
let month = date.getMonth() + 1;

if ((month == 12 && days >= 22) || (month <= 3 && days <= 21)) {
  alert("Verão");
} else if ((month >= 3 && days >= 22) || (month <= 6 && days <= 21)) {
  alert("Outono");
} else if ((month >= 6 && days >= 22) || (month <= 9 && days <= 21)) {
  alert("Inverno");
} else {
  alert("Primavera");
}
