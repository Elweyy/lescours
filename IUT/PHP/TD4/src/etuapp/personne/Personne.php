<?php
namespace etuapp\personnapp\personne;
require_once 'src/etuapp/personne/Personne.php';

abstract class Personne {
    protected $nom, $prenom, $age, $adr, $ville;
    protected $codep, $mail, $mobile, $idSkype;

    public function __construct($nom)
    {
	$this->nom = $nom;
    }

    public function __toString()
    {
	return '{ "nom" :"' . $this->nom . '",
                  "prenom" : "' . $this->prenom . '",
                  "age" : ' . $this->age . ' ,
                  "adr" : "' . $this->adr . '",
                  "ville" :"' . $this->ville . '",
                  "zip" :"' . $this->codep . '",
                  "mail" :"' . $this->mail . '",
                  "mobile" :"' . $this->mobile . '",
                  "idSkype" :"' . $this->idSkype . '"
                }' ;
    }

    // Getter magique
    public function __get($attname) {
        if (property_exists($this, $attname))
	    return $this->$attname ;
    }

    // Setter magique
    public function __set($attname, $attval) {
        if (property_exists($this, $attname)) {
            $this->$attname = $attval;
            return $this->$attname;
        }
    }

    // Exercice 4.1
    public function compter() {
        $i=0;

        for ($i = 0; $i <= $this->age; $i++)
	    print $i . '<br>';
        while ($i >= 0)
	    print $i-- . '<br>';
    }

    // Exercice 4.3
    public function ageN($n) {
        $anneNaiss = intval(date('Y')) - $this->age;
        return $n - $anneNaiss;
    }
}

?>
