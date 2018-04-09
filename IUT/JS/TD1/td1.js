/**
 * Created by canals on 25/01/2017.
 */
'use strict'

// Eleve : SPACHER Loic

/* exercice 1.1 */

function min(a,b) {
  if(a<b){
    return a;
  }
  return b;
}

let max = (a,b) => {
  if(a>b){
    return a;
  }
  return b;
}


console.log( min(3, 4));
console.log( max(3,4));

  // Ex 1.2
  function compteur(){
   for(var x=1; x <=100;x++){
     console.log(x);
     if (x%3 === 0){
       console.log(' woueee');
     }
     if (x%5 === 0){
       console.log(' yooo');
     }
     if (x === 73) {console.log( ' Biinnngooo');}
    }
  }

  // Ex 1.3
  function power(n,x){
   let result = 1;
   for (var a = 0; a < n; a++){
     result *= x;
   }
   return result;
  }

  // Ex 1.4
  function power2(n,x){
   if (n > 1) {x *= power2(n-1,x)};
   return x;
  }

  // Ex 2.1
function creerMultiplicateur(n){
  return (x) =>{ return( x*n)};

}

let cm = creerMultiplicateur(5);
console.log(cm(4)); // ->20

  // Ex 2.2
function creerSequence(init, step) {

  return () => {
    let res = init;
    init += step;
    return res;
  };

}

let cs = creerSequence(1,2);
for(let i=0; i<20; i++)
  console.log(cs());

  // Ex 2.3
function suiteFibo(a,b){
  return() => {
    let c = a;
    a += b;
    let d = b;
    b += a;
    return {a,b};
  }
}

let sf = suiteFibo(1,1);
for(let i=0; i<20; i++)
  console.log(sf());

  // Ex 2.4
function creerMultiplicateurModif(n,x){
  if(x !== undefined)
    return n*x;

  return (a) => {return a*n;};

  }

let cmm = creerMultiplicateurModif(6);
let cmms = creerMultiplicateurModif(5,2);

console.log(cmm(4)); // 24
console.log(cmms); // 10

  //Ex 2.5

  function power3(n,x){
    if(x !== undefined){
       if (n > 1)  x *= power3(n-1,x);
       return x;
     }else{

    return (x) => { return power3(n,x) };
    }
  }

  let pw3 = power3(5);
  let pw3s = power3(5,2);

  console.log(pw3(2));
  console.log(pw3s);

  //Ex 2.6

  function formatter(num, texte){
    let start=num;
      return (texte) => {start++;
                        return  start + " : "+texte;};
  }

  let format =formatter(10);
  console.log(format(" j'aime le chocolat"));
  console.log(format(" j'aime ma maman"));
  console.log(format(" je t'aime pas "));


  // Ex 2.7

  function write(){
    return(phrase) => console.log(phrase);
  }

  let prompt = write("Salut les coupains");

  function writeAlert(phrase){
    return(phrase) =>  console.log(alert(phrase));
  }

  let prompt2 = writeAlert("Salut les potes");

  // Ex 2.8

  function logger(f1,f2){

    return (phrase) => { return f2(f1(phrase));}
  }

  let log = logger(formatter(0),write());
  log('Un jour je serais le meilleur dresseur');
  log(' ');
  log('Je tuerai   Elise');
