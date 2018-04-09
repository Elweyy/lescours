<?php
  require 'Personne.php';
  class Enseignant extends Personne {
    protected $code_discipline,$composante,$num_bureau;

    public function __construct($n, $p,$a,$vi,$cp,$ma,$tel,$id,$code_di,$comp,$num_b){
      parent::__construct($n, $p,$a,$vi,$cp,$ma,$tel,$id);
      $this->code_discipline = $code_di;
      $this->composante= $comp;
      $this->num_bureau= $num_b;
    }
