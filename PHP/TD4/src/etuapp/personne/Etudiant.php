<?php

namespace etuapp\personnapp\personne;
require_once 'src/etuapp/personne/Etudiant.php';


class Etudiant extends Personne {
    protected $noEtudiant, $refFormation, $groupe;

    public function __construct($nom)
    {
	parent::__construct($nom);
    }

    // Exercice 4.2
    public function punition($n, $l) {
	echo "Je fais la punition...";
    }

    public function ajoutNote($mat, $note) {
      $this->notes[$mat][] = $note;
    }

    public function conversionDate($monjour) {
      $jour = array(
        1=> "Lundi",
        2=> "Mardi",
        3=> " Mercredi",
        4=> "Jeudi",
        5=> "Vendredi",
        6=> "Samedi",
        7=> "Dimanche",
      )
      return $jour[$monjour]
    }
}

?>
