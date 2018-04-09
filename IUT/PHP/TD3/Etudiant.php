<?php
  require 'Personne.php';
  class Etudiant extends Personne {
    protected $num_etu,$ref_form,$groupe;

    public function __construct($n, $p,$a,$vi,$cp,$ma,$tel,$id,$num_e,$ref_f,$grp){
      parent::__construct($n, $p,$a,$vi,$cp,$ma,$tel,$id);
      $this->num_etu =$num_e;
      $this->ref_form=$ref_f;
      $this->groupe=$grp;
    }

    public function punition($n,$l){
      echo " Je fais la punition ...";
    }
  }
