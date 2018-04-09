<?php
namespace etuapp\personnapp\afficheur;
require_once 'src/etuapp/personne/Personne.php';

use etuapp\personnapp\personne as p;

abstract class AfficheurDePersonne {
    public $p ;

    public function __construct(p\Personne $p) {
        $this->p = $p;
    }

    public function vueCourte()
    {
	return '<div>' .
	       '<p>' .
	       $this->pers->nom .
	       ' ' .
	       $this->pers->prenom .
	       ', habite à ' .
	       $this->pers->ville .
	       '</p>'.
               '</div>';
    }

    /* Cette méthode passe abstraite */
    public abstract function vueDetail() ;

    public function afficher ($sel) {
        $content=null;

        switch ($sel) {
            case 'short': {
                $content = $this->vueCourte();
                break;
            }
            case 'long': {
                $content = $this->vueDetail();
                break;
            }
        }

	/* Affichage en utilisant la syntae HereDoc
	   (3ième syntaxe de définition des chaînes)*/
        echo <<<END
<!DOCTYPE html>
<html>
  <head lang="fr">
    <meta charset="utf-8">
    <title>Affichage de personne</title>
  </head>

  <body>
    $content
  </body>
</html>
END;

    }
}
