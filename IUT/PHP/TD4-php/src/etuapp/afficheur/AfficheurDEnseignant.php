<?php
namespace etuapp\personnapp\afficheur;
require_once 'src/etuapp/afficheur/AfficheurDePersonne.php';
require_once 'src/etuapp/personne/Enseignant.php';

use etuapp\personnapp\personne as p;

class AfficheurDEnseignant extends AfficheurDePersonne {

    /* Appel au super-construteur */
    public function __construct(p\Enseignant $p) {
        parent::__construct($p);
    }

    public function vueDetail() {
        $conjoint = null;

	if (! is_null ($this->p->conjoint)) {
            $a = new AfficheurDEnseignant($this->p->conjoint);
            $conjoint = $a->vueCourte();
        }
	else
	    $conjoint = '<h4>pas de conjoint</h4>';

        $html = '<div>' . '<h3>'. $this->p->nom . ' ' . $this->p->prenom .
		'</h3>' . '<h4>Discipline :' . $this->p->codeDiscipline .
		'</h4>' . '<h4>composante : ' . $this->p->composante .
		'</h4>' . '<h4>Bureau' . $this->p->noBureau .
		'</h4>' . '<h4>' .$this->p->age .' ans </h4>' .
		'<h4>' . $this->p->adr . '</h4>' .
		'<h4>' . $this->p->codep . ' ' . $this->p->ville .
		'</h4>' . '<h4>' . $this->p->mail . '</h4>' .
		'<h4>' .  $this->p->mobile . '</h4>' .
		'<h4>' . $this->p->idSkype . '</h4>' .
		'</div>';

        if (is_null($conjoint))
            return $html;

        return $html . '<h4>Conjoint : </h4>' . $conjoint;
    }
}
