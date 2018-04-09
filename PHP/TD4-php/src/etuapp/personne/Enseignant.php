<?php
namespace etuapp\personnapp\personne;
require_once 'src/etuapp/personne/Personne.php';


class Enseignant extends Personne {
    protected $codeDiscipline, $composante, $noBureau, $kids;

    public function __construct($nom)
    {
	    parent::__construct($nom);
      $this->kids = array();
    }

    public function sumAges(Array $tab)
    {
      $sum = 0;
      foreach($tab as $value){
        $sum += $value;
      }
      return $sum;
    }
}

?>
