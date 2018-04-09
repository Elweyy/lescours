'use strict'

/* Exercice 1 */
/* Question 1 */
function range(a,b){
  let t =[];
  if (a<b){
    for (a; a <= b ; a++ ) {t.push(a);}
    return t;
  }
  for (b; b <=a ; b++ ) {t.push(b);}
  return t;
}

console.log(" range 1 : " + range(1,5));
console.log(" range 2 : " + range(5,1));


/*Question 2*/
function sum1(t){
  let sum = 0;
  for(let i = 0; i < t.length ; i++){
    sum += t[i];
  }
  return sum;
}

function sum2(t){
  let sum = 0;
  t.forEach((element) => {sum += element;});
  return sum;
}

function sum3(t){
  let sum = ( acc, elem ) => acc + elem ;
  return t.reduce(sum,0);
}

let t = [0,1,2,3,4,5];

console.log("sum 1 :" + sum1(t));
console.log("sum 2 :" + sum2(t));
console.log("sum 3 :" + sum3(t));


/* Question 3 */

function avg1(t){
  let sum = 0;
  for(let i = 0; i < t.length ; i++){
    sum += t[i];
  }
  return sum / t.length;
}

function avg2(t){
  let sum = 0;
  let sumElement = (element) => {sum += element;};
  t.forEach(sumElement);
  return sum / t.length;
}

function avg3(t){
  let sum = ( acc, elem ) => acc + elem ;
  let result = t.reduce(sum,0) / t.length;
  return result;
}

let t2 = [0,1,2,3,4,5];

console.log("avg 1 :" + avg1(t2));
console.log("avg 2 :" + avg2(t2));
console.log("avg 2 :" + avg3(t2));


/* Question 4 */

function concatPattern(string,pattern){
  let t = [];
  let verif =
 string.forEach((element) => {if(element.includes(pattern))
                                {t.push(element.toUpperCase());}
                             });
  return t;
}

let listeStrings = ["bonbon","con","savon","rameau","non","rond"];
console.log("concat Pattern : " + concatPattern(listeStrings, "on"));

/* Question 5 */

function concatPattern2(string,pattern){
  let t = [];
  t = string.filter( (element) => element.includes(pattern)).map((element) => element.toUpperCase());
  return t;
}

console.log("concat Pattern : " + concatPattern2(listeStrings, "on"));

/* Question 6 */
function complete(string,testFnct,transFnct){
  return string.filter(testFnct).map(transFnct);
  }

let pattern = "on";
let testFnct = (element) => element.includes(pattern);
let transFnct = (element) => element.toUpperCase();


console.log("complete : "+complete(listeStrings,testFnct,transFnct));

/*Exercice 2 */
/*Question 1*/

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


/* Question 2 */

let student = {
  numero: 1,
  nom: "Dupont",
  prenom: "Jack",
  birth: new Date('December 17,1995 03:24:00'),
  mail: "dupont.jack@gmail.com",
  notes: [],
  /* Question 3*/
  age() {  let date = new Date();
          return Math.floor((date.getTime() - this.birth.getTime()) / 31536000000);},
  affichInfo() { console.log(this.nom.toUpperCase() + this.prenom + "\n");
                 console.log(this.birth.getDate() +"/"
               + this.birth.getMonth()+"/"
               + this.birth.getFullYear());
              },
  /* Question 4 */
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

/*Question  5*/


student.ajoutNote("BDD", 7);
student.ajoutNote("HTML", 18);
student.ajoutNote("Java", 11);
student.ajoutNote("Anglais", 13);

function averageMarks(obj){
  let average = 0;
  obj.notes.forEach(function(element){
    average += element.note;
  });
  return average / obj.notes.length;
}

console.log("Moyenne : " + averageMarks(student));

/* Question 6 */
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

 let elise = new Student(1,"Moreau","Elise",24,7,1993,"moreau.elise13@gmail.com");
 console.log("Affichage du résultat du constructeur");
 elise.affichInfo();

/* Question 7 */

function studentsBirthday(tabStudents,month){
  return tabStudents.filter((element) => element.birth.getMonth() === month);
}

let loic = new Student(1,"Spacher","Loic",16,0,1996,"loic.spacher@gmail.com");
let nicolas = new Student(1,"Lardier","Nicolas",22,1,1997,"nico-lardier@outlook.fr");
let gaetan = new Student(1,"Lagraviere","Gaetan",25,0,1990,"gaetan.lagraviere@gmail.com");
let tabStudents = [loic, nicolas, gaetan, elise];
console.log("Les eleves nés un mois de janvier");
let birthdayStudent = studentsBirthday(tabStudents,0);
birthdayStudent.forEach(element => element.affichInfo());

/* Question 8 */

function olderThan(tabStudents, age){
    return tabStudents.filter((element) => element.age() > age);
}

let oldestStudents = olderThan(tabStudents,22);
console.log("Les vieux élèves :");
oldestStudents.forEach(element => element.affichInfo());

/*Question 9 */

function studentsGroup(nomgpe,formation,liste,annee){
        this.nomgpe = nomgpe;
        this.formation = formation;
        this.liste = liste;
        this.annee = annee;
}

let studentsGrp = new studentsGroup("Les Rebelles du bac à sable", "AS", tabStudents, 2018);

/*Question 10 */

//Ajouter un élève au groupe
studentsGroup.prototype.addStudent = function(student) {
    this.liste.push(student);
}

//Compter le nombre d'élèves du groupe
studentsGroup.prototype.countStudents = function() {
    return this.liste.length;
}

//Calculer la moyenne générale de chaque étudiant du groupe
studentsGroup.prototype.studentGlobalAverage = function() {
    return this.liste.map(element => {
        return {
            nom : element.nom,
            moyenne : averageMarks(element)
        };
    });
}

//Calculer la moyenne du groupe pour une matière donnée
studentsGroup.prototype.studentsGlobalAverage = function(subject) {
    let notes = [];
    this.liste.forEach(function(student){
        notes = notes.concat(student.notes
            .filter(note => note.matiere === subject)
            .map(note => note.note)
        );
    });
    return notes.reduce((prev,current) => prev + current, 0) / notes.length
}

let matheo = new Student(1,"Allard","Matheo",12,0,1998,"matheo.allard@gmail.com");
studentsGrp.addStudent(matheo);

console.log("Nombre d'élèves du groupe : ");
console.log(studentsGrp.countStudents());

console.log("Moyenne des élèves :");
//Ajout de notes pour les élèves
studentsGrp.liste.forEach(element => element.ajoutNote("Maths", Math.round(Math.random() * 20)));
studentsGrp.liste.forEach(element => element.ajoutNote("Com", Math.round(Math.random() * 20)));
studentsGrp.liste.forEach(element => element.ajoutNote("BDD", Math.round(Math.random() * 20)));
let averages = studentsGrp.studentGlobalAverage();
averages.forEach(element => console.log(element));

console.log("Moyenne des élèves en maths :");
console.log(studentsGrp.studentsGlobalAverage("Maths"));

/*Question 11 */

studentsGroup.prototype.giftMark = function(month,subject){
    let students = studentsBirthday(this.liste,month);
    students.forEach(student => {
        student.notes.forEach(note => {
            if (note.matiere === subject)
                note.note = Math.min(note.note + 2,20);
        });
    });
}


console.log("Moyenne des élèves en maths avant l'anniversaire:");
studentsGrp.liste.forEach(element => console.log(element.nom + " : " + element.notes.filter(element => element.matiere === "Maths").map(element => element.note)));
studentsGrp.giftMark(0,"Maths");
console.log("Moyenne des élèves en maths après l'anniversaire:");
studentsGrp.liste.forEach(element => console.log(element.nom + " : " + element.notes.filter(element => element.matiere === "Maths").map(element => element.note)));
