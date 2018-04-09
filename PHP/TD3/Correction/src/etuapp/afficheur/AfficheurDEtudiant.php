<?php

namespace etuapp\affichapp\afficheur;


require_once 'src/etuapp/personne/Personne.php';
require_once 'src/etuapp/personne/Etudiant.php';
use etuapp\personnapp\personne as p;

class AfficheurDEtudiant extends AfficheurDePersonne {

    /* Appel au super-construteur */
    public function __construct(p\Etudiant $p) {
        parent::__construct($p);
    }

    public function vueDetail() {
        $html = '<div>' .
		'<h3>' . $this->p->nom . ' ' . $this->p->prenom . '</h3>' .
		'<h4>N° etudiant : ' . $this->p->noEtudiant . ' </h4>' .
		'<h4>Ref. formation : ' . $this->p->refFormation . ' </h4>' .
		'<h4>N° groupe : ' . $this->p->groupe . ' </h4>' .
		'<h4>' . $this->p->age . 'ans </h4>' .
		'<h4>' . $this->p->adr . '</h4>' .
		'<h4>' . $this->p->codep . ' ' . $this->p->ville . '</h4>' .
		'<h4>' . $this->p->mail . '</h4>' .
		'<h4>' . $this->p->mobile . '</h4>' .
		'<h4>' . $this->p->idSkype . '</h4>' .
		'</div>';

        return $html;
    }
}
