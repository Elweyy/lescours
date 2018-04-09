/**
 * Created by canals on 25/01/2017.
 */
'use strict'

// Eleve : SPACHER Loic

// Exercie 1 Tableau :

// Question 1:

function range(a,b) {
  let t=[];
  if (a<b){
    t.push(a);
    for(a; a<=b;a++){
      t.push(a);
    }
    return t;
  }else {
    for(b; b<=a;b++){
      t.push(b);
    }
    return t;
  }
}
console.log(range(1,5));
console.log(range(5,1));

// Question 2 :

function sum1(t){
  let sum = 0;
  for( let i=0; i<t.length;i++){
    sum+=t[i];
  }
  return sum;
}

function sum2(t){
  let sum=0;
  let sumElem = (element) => {sum += element};
  t.forEach(sumElem);
  return sum;
}

function sum3(t){
  let sum = (acc,elem) => acc+elem;
  return t.reduce(sum,0);
}

let t = [1,2,3];

console.log("sum1 :" + sum1(t));
console.log("sum2 :" + sum2(t));
console.log("sum3 :" + sum3(t));

// Question 3 :

function avg1(t){
  let sum = 0;
  for( let i=0; i<t.length;i++){
    sum+=t[i];
  }
  return (sum/t.length);
}

function avg2(t){
  let sum=0;
  let sumElem = (element) => {sum += element};
  t.forEach(sumElem);
  return (sum/t.length);
}

function avg3(t){
  let sum = (acc,elem) => acc+elem;
  return t.reduce(sum,0)/t.length;
}

console.log("avg1 :" + avg1(t));
console.log("avg2 :" + avg2(t));
console.log("avg3 :" + avg3(t));

// Question 4:

function bloup(string,pattern){
  let t=[];
  string.forEach((element)=> {if(element.includes(pattern))
                            {t.push(element.toUpperCase());}
                            });
  return t;
}


let stringElement = ["conception","compétition","chaton","bob"];

console.log("Test :" + bloup(stringElement,"co"));

// Question 5 :

function bloup2(string,pattern){

  let contain = (element) => element.includes(pattern);
  let t = string.filter(contain);
  let maj = (element) => element.toUpperCase();
  let result = t.map(maj);
  return result;
}

console.log("Test2 :" + bloup2(stringElement,"co"));


// Question 6 :

function complete(string,testFnct,transFnct){
  return string.filter(testFnct).map(transFnct);
  }

let pattern = "on";
let testFnct = (element) => element.includes(pattern);
let transFnct = (element) => element.toUpperCase();

//console.log("complete : "+complete(bloup,testFnct,transFnct));


// Exercice 2 Objets :

// Question 1 :

function formalisationEntiers(tabInt){
  let numbers = {};
  numbers.nbElements = tabInt.length;
  numbers.sum = sum3(tabInt);
  numbers.avg = avg3(tabInt);
  return numbers;
}

let listeNumbers = [0,1,2,3,4,5];
let objetEntiers = formalisationEntiers(listeNumbers);
console.log("formalisationEntiers");
for (var i in objetEntiers) {
   if (objetEntiers.hasOwnProperty(i)) {
       console.log("\tobjetEntiers." + i + " = " + objetEntiers[i] + "\n");
   }
 }


console.log("Exo 2.1: " + formalisationEntiers(t));


// Question 2 :


let student = {
  numero: 1,
  nom: "Dosch",
  prenom: "Phil",
  birth: new Date('January 16,1996 03:24:00'),
  mail: "dosch.phil@gmail.com",
  notes: [],


// Question 3:

  age() {  let date = new Date();
          return Math.floor((date.getTime() - this.birth.getTime()) / 31536000000);},
  affichInfo() { console.log(this.nom.toUpperCase() + this.prenom + "\n");
                 console.log(this.birth.getDate() +"/"
               + this.birth.getMonth()+"/"
               + this.birth.getFullYear());
              },


// Question 4 :

  ajoutNote(mat,x) { let note = { matiere: mat,
                                  note : x};
                     this.notes.push(note);
                  }
}

console.log(student);
student.affichInfo();
console.log(student.age());
student.ajoutNote("Com", 17);
console.log(student.notes);


// Question 5 :

student.ajoutNote("Java", 2);
student.ajoutNote("HTML", 18);
student.ajoutNote("JS", 18);
student.ajoutNote("Eco", 13);

function averageMarks(obj){
  let average = 0;
  obj.notes.forEach(function(element){
    average += element.note;
  });
  return average / obj.notes.length;
}

console.log("Moyenne : " + averageMarks(student));



// Question 6 :

function Student(numero,nom,prenom,jour,mois,annee,mail){
  this.numero = numero;
  this.nom = nom;
  this.prenom = prenom;
  this.birth = new Date(annee,mois,jour);
  this.notes = []
 };

 Student.prototype.age = function(){
   let date = new Date();
   return Math.floor((date.getTime() - this.birth.getTime()) / 31536000000);
 };

 Student.prototype.affichInfo = function() {
   console.log(this.nom.toUpperCase() + " " + this.prenom + "\n");
   console.log(this.birth.getDate() +"/"
   + this.birth.getMonth()+"/"
   + this.birth.getFullYear());
 };

 Student.prototype.ajoutNote = function(mat,x) {
   let note = { matiere: mat, note : x};
   this.notes.push(note);
 };

 let loic = new Student(1,"Spacher","Loic",16,1,1996,"loic.spacher@gmail.com");
 console.log("Affichage du résultat du constructeur");
 loic.affichInfo();

// Question 7


function studentsBirthday(tabStudents,month){
  return tabStudents.filter((element) => element.birth.getMonth() === month);
}

let elise = new Student(1,"Moreau","Elise",14,7,1993,"moreau.elise13@gmail.com");
let nicolas = new Student(1,"Lardier","Nicolas",22,4,1997,"nico-lardier@outlook.fr");
let gaetan = new Student(1,"Lagraviere","Gaetan",25,1,1990,"gaetan.lagraviere@gmail.com");
let tabStudents = [loic, nicolas, gaetan, elise];
console.log("Les eleves nés un mois de janvier");
let birthdayStudent = studentsBirthday(tabStudents,0);
birthdayStudent.forEach(element => element.affichInfo());

// Question 8 :

function olderThan(tabStudents, age){
    return tabStudents.filter((element) => element.age() > age);
}

let oldestStudents = olderThan(tabStudents,22);
console.log("Les vieux élèves :");
oldestStudents.forEach(element => element.affichInfo());



//Question 9 :

function groupeEtudiants(nomgpe,formation,liste,annee){
        this.nomgpe = nomgpe;
        this.formation = formation;
        this.liste = liste;
        this.annee = annee;
}

let groupeEtudiant = new groupeEtudiants("Les étudiants les plus beaux", "AS", tabStudents, 2018);

// Question 10 :

groupeEtudiants.prototype.ajouterEtudiant = function(student) {
    this.liste.push(student);
}

groupeEtudiants.prototype.comterNombreEtudiant = function() {
    return this.liste.length;
}

groupeEtudiants.prototype.moyenneEtudiantGroupe = function() {
    return this.liste.map(element => {
        return {
            nom : element.nom,
            moyenne : averageMarks(element)
        };
    });
}

groupeEtudiants.prototype.moyenneGroupeMatiere = function(subject) {
    let notes = [];
    this.liste.forEach(function(student){
        notes = notes.concat(student.notes
            .filter(note => note.matiere === subject)
            .map(note => note.note)
        );
    });
    return notes.reduce((prev,current) => prev + current, 0) / notes.length
}

let mehdi = new Student(1,"Maaroufi","Mehdi",14,8,1990,"mehdi.maarouf@gmail.com");
groupeEtudiant.ajouterEtudiant(mehdi);

console.log("Nombre d'élèves dans groupe : ");
console.log(groupeEtudiant.comterNombreEtudiant());

console.log("Moyenne des élèves :");

groupeEtudiant.liste.forEach(element => element.ajoutNote("JS", Math.round(Math.random() * 20)));

let moyenneGrp = groupeEtudiant.moyenneEtudiantGroupe();
moyenneGrp.forEach(element => console.log(element));

console.log("Moyenne des élèves en Javascript :");
console.log(groupeEtudiant.moyenneGroupeMatiere("JS"));

// Question 11 :

groupeEtudiants.prototype.cadeau = function(month,subject){
    let students = studentsBirthday(this.liste,month);
    students.forEach(student => {
        student.notes.forEach(note => {
            if (note.matiere === subject)
                note.note = Math.min(note.note + 2,20);
        });
    });
}


console.log("Moyenne des élèves en Javascript avant l'anniversaire:");
groupeEtudiant.liste.forEach(element => console.log(element.nom + " : " + element.notes.filter(element => element.matiere === "JS").map(element => element.note)));
groupeEtudiant.cadeau(0,"JS");


console.log("Moyenne des élèves en Javascript après l'anniversaire:");
groupeEtudiant.liste.forEach(element => console.log(element.nom + " : " + element.notes.filter(element => element.matiere === "JS").map(element => element.note)));
