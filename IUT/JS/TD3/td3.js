/**
*Elève : SPACHER Loic
*
* TD3
*/

'use strict'
window.addEventListener("load",(event) => {
    let i = 1
    let ex1 = document.querySelector("#ex1");
    let ex2 = document.querySelector("#ex2");
    let ex3 = document.querySelector("#ex3");
    let ex4i = document.querySelector("#ex4i");
    let ex4b = document.querySelector("#ex4b");

    ex1.addEventListener("click", (event) => {
        logClick();
    });
    ex1.addEventListener("click", (event) => {
        updateButtonClassProfVersion();
    });
    ex1.addEventListener("click", (event) => {
        insertInto(i);
        i+=1
    });
    ex3.addEventListener("click", (event) => {
        clearList();
    });
    ex4b.addEventListener("click",(event) => {
        incrInputValue();
    });

});

// Exercice 1 :

function logClick(){
    console.log("click");
}


// Exercice 2 :
/*
function getRandomColor() {
    var letters = '0123456789ABCDEF';
    var color = '#';
    for (var i = 0; i < 6; i++ ) {
        color += letters[Math.floor(Math.random() * 16)];
    }
    return color;
}

function updateButtonClass(){

    let couleur = getRandomColor();

    let elm = document.getElementById("ex1");

    elm.style.backgroundColor = couleur;

}


window.addEventListener("load",(event) => {
    let ex2 = document.querySelector("#ex1");

    ex2.addEventListener("click", (event) => {
        updateButtonClass();
    });
});
*/
function updateButtonClassProfVersion(){
    event.target.classList.toggle("c1");
    event.target.classList.toggle("c2");

}



// Exercice 3 :

function insertInto(i){
    let elm = document.getElementById("ex2");
    let item = document.createElement('li');
    let t =document.createTextNode('click :'+ i  );
    item.appendChild(t);
    elm.appendChild(item);
}

// Exercice 4 :

function clearList(){
    let noeud = document.getElementById("ex2");
    while(noeud.firstChild){
        noeud.removeChild(noeud.firstChild)
    }
}

// Exercice 5 :

function incrInputValue(){
    let elm = document.getElementById("ex4i");
    elm.value++;
}
