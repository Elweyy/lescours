<?php
  abstract class Personne{
    protected $nom,$prenom,$age,$adresse,$ville,$code_postal,$mail,$tel_mobile,$identifiant_skype;

    public function __construct($n, $p,$a,$vi,$cp,$ma,$tel,$id){
      $this->nom = $n;
      $this->prenom = $p;
      $this->age = $a;
      $this->ville = $vi;
      $this->code_postal = $cp;
      $this->mail = $ma;
      $this->tel_mobile = $tel;
      $this->identifiant_skype = $id;
    }


    public function __get($at) {
      if ( property_exists ($this,$at)) {
        return $this->$at;
      }
      else throw new Exception ("$at : invalid property");
      }

    public function punition($n,$l){
      echo " Je fais la punition ...";
    }

    public function __set($at, $val) {
      if(property_exists($this,$at)) {
        $this->$at = $val;
        return $this->$at;
      } else throw new Exception ("$at : invalid property");
    }

    public function __toString(){
      return '{ "nom":"' .$this->nom.'",
                "prenom":"' .$this->prenom.'",
                "age":"' .$this->age.'"
              }';
    }
  }
 ?>
