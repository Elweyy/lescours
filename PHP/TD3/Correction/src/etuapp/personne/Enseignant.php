<?php

namespace etuapp\personnapp\personne;
require_once 'src/etuapp/personne/Personne.php';


class Enseignant extends Personne {
    protected $codeDiscipline, $composante, $noBureau;

    public function __construct($nom)
    {
	parent::__construct($nom);
    }
}

?>
