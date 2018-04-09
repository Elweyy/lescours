<?php
 class Personnes {
 public $nom, $prenom, $age ;
 public function __construct($n) {
   $this->nom=$n;
 }

 public function __toString() {
   return ' {"nom":"' .$this->nom.'",
             "prenom":"' .$this->prenom.'",
             "age":"' .$this->age.'",

           }';
 }
}
 ?>
