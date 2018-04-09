<?php

require_once 'src/etuapp/personne/Enseignant.php';
require_once 'src/etuapp/personne/Etudiant.php';
require_once 'src/etuapp/afficheur/AfficheurDEnseignant.php';
require_once 'src/etuapp/afficheur/AfficheurDEtudiant.php';

use etuapp\personnapp\personne as p;
use etuapp\affichapp\afficheur as a;

$p1 = new p\Etudiant('Jagger');
$p1->prenom='Mick';
$p1->age=23;
$p1->noEtudiant = 435667;
$p1->refFormation='XDMA234';
$p1->groupe='2E';

$p2 = new p\Enseignant('Richards');
$p2->prenom='Keith';
$p2->age=22;
$p2->codeDiscipline = 27;
$p2->composante='IUT-NC';
$p2->noBureau='0023';


$p3 = new p\Etudiant('Lennon');
$p3->prenom='Bob';
$p3->age=30;
$adp1 = new a\AfficheurDEtudiant($p1);
$adp2 = new a\AfficheurDEnseignant($p2);
$adp3 = new a\AfficheurDEtudiant($p3);
echo $adp1->vueDetail();
echo $adp2->vueDetail();
echo $adp3->vueDetail();

?>
