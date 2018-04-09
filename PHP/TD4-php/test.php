<?php

require_once 'src/etuapp/personne/Enseignant.php';
require_once 'src/etuapp/personne/Etudiant.php';
require_once 'src/etuapp/personne/Groupe.php';
require_once 'src/etuapp/afficheur/AfficheurDEnseignant.php';
require_once 'src/etuapp/afficheur/AfficheurDEtudiant.php';

use etuapp\personnapp\personne as p;
use etuapp\personnapp\afficheur as a;

$grp1 = new p\Groupe(1,'Groupe 1','Littérature');

$p1 = new p\Etudiant('Jagger');
$p1->prenom='Mick';
$p1->age=23;
$p1->noEtudiant = 435667;
$p1->refFormation='XDMA234';
$p1->groupe='1';
$p1->addMark(15,'Communication');
$p1->addMark(17,'Anglais');
$p1->addMark(10,'Maths');
$p1->addMarks('7;8;11;6;8','PHP');
//$p1->averageMarksAndComponents();
//$p1->modifyMark('Communication',0,12);
//$p1->averageMarksAndComponents();
$adp1 = new a\AfficheurDEtudiant($p1);
echo $adp1->vueDetail();
$p1->echoMarks();
echo "-----------------------";

$p2 = new p\Etudiant("Aaron");
$p2->prenom='Jacques';
$p2->age=27;
$p2->noEtudiant = 1;
$p2->refFormation='XDMA234';
$p2->groupe='1';
$p2->addMarks('11;18;15;10;19','PHP');
$adp2 = new a\AfficheurDEtudiant($p2);
echo $adp2->vueDetail();
$p2->echoMarks();

echo "-----------------------";
$grp1->addStudent($p1);
$grp1->addStudent($p2);
//$grp1->averageMarksInComponent('PHP');
$arrayTest = $grp1->allMarksandAveragePerStudent('name');
foreach($arrayTest as $num => $student){
  echo "<h4>".$num . ". La moyenne de ". $student->nom . " est égale à " . $student->generalAverage."</h4>";
}

$arrayTest = $grp1->allMarksandAveragePerStudent('mark');
foreach($arrayTest as $num => $student){
  echo "<h4>".$num . ". La moyenne de ". $student->nom . " est égale à " . $student->generalAverage."</h4>";
}
echo "-----------------------";
$p3 = new p\Enseignant('Richards');
$p3->prenom='Keith';
$p3->age=22;
$p3->kids = ['Pete'=> 12, 'Carol' => 13, 'Lucas' => 15];
$p3->codeDiscipline = 27;
$p3->composante='IUT-NC';
$p3->noBureau='0023';

$adp3 = new a\AfficheurDEnseignant($p3);

//echo 'Lundi est le ' . $p1->convertDays('Lundi') . "er jour.</br>";
//echo 'Le 1 er jour est '. $p1->convertDays(1)."</br>";

echo $adp3->vueDetail();
//echo 'Ses enfants ont '.$p3->sumAges($p3->kids).' ans en tout.';

//echo $p1->convertDays($_GET['day']);


?>
