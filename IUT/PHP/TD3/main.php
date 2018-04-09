<?php

  require 'Personne.php';
  require 'AfficheurDePersonne.php';
  require 'Etudiant.php';
  require 'Enseignant.php';

  $personne1 = new Enseignant("Herbert","Louis",12,"Lyon","69009","louis.herbert@gmail.com","0647521513", "ProutProut");
  $personne2 = new Etudiant("Spacher","Loïc",22,"Nancy","54000","loic.spacher@gmail.com","0647521523","Elwey");

  $affichpers1 = new AfficheurDePersonne($personne1);
  $affichpers2 = new AfficheurDePersonne($personne2);

  echo "<!doctype html>
    <html>
        <head>
        </head>
          <body>
          ";
  $affichpers1->afficher(1)."</br>";
  $affichpers2->afficher(2)."</br>";
  echo "</body>
    </html>";

?>
