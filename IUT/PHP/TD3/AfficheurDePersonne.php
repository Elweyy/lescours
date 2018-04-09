<?php
  require_once 'Personne.php';
  class AfficheurDePersonne{

    public $personne;

    public function __construct($personne){
      $this->personne = $personne;
    }

    public function vueCourte(){
      return'<div>'. $this->personne->nom .' '. $this->personne->prenom . ' a ' . $this->personne->age. ' ans </div></br>';
    }

    public function vueDetail(){
      return'<div>'. $this->personne->nom .' '. $this->personne->prenom . ' a ' . $this->personne->age. ' ans et
             habite à '.$this->personne->ville." (".$this->personne->code_postal.")".'. Son mail est ' . $this->personne->mail. ', son téléphone est ' .
             $this->personne->tel_mobile . ' et son identifiant skype est '. $this->personne->identifiant_skype .'. '.
            '</div></br>';
    }

    public function afficher($sel){
      if ($sel === 1){
        echo $this->vueCourte();
      }
      else{
        echo $this->vueDetail();
      }
      return 0;
    }
  }
?>
