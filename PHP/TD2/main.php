<?php
  require 'Personnes.php';

  $personne1 = new Personnes("Moreau");
  $personne1 ->prenom ="Elise";
  $personne1 ->age = 24;



  $personne2 = new Personnes("Maaroufi");
  $personne2 ->prenom ="Mehdi";
  $personne2 ->age = 26;

  echo $personne1->__toString()."<br>";
  echo $personne2->__toString();



  ?>
