/****************************************
 *  classe UnTriangle
 * Version 2 - TP5
 *****************************************/

/**
 * classe unTriangle (etudiant TP5) modelise des triangles sous la
 * forme de trois points
 *
 * @author vthomas
 *
 */

class UnTriangle {

	/**
	 * attributs du triangle les trois sommets du triangle
	 */
	UnPoint A, B, C;

	/**
	 * construit un triangle � partir de trois points les attributs
	 * doivent etre d'autres references que les references des
	 * parametres
	 *
	 * @param a
	 *            sommet A
	 * @param b
	 *            sommet B
	 * @param c
	 *            sommet C
	 */
	UnTriangle(UnPoint a, UnPoint b, UnPoint c) {
		this.A= new UnPoint(a);
		this.B= new UnPoint(b);
		this.C= new UnPoint(c);
		if ( B.calculerDistance(C)==0) {
			B.seTranslater (0,1);
		}
		if ( A.calculerDistance(B)==0) {
			A.seTranslater (0,1);
		}
}

	/**
	 * constructeur par copie les attributs du nouveau triangle
	 * doivent avoir des references diff�rentes
	 *
	 * @param t
	 *            triangle origine
	 */
	UnTriangle(UnTriangle t) {
		if (t !=null) {
			this.A= new UnPoint(t.A);
			this.B= new UnPoint(t.B);
			this.C= new UnPoint(t.C);
		}else {
			this.A= new UnPoint(3,0);
			this.B= new UnPoint(2,0);
			this.C= new UnPoint(5,3);
		}
	}


	/**
	 * methode demandant au triangle de se translater
	 *
	 * @param dx
	 *            variation selon l'axe abscisse
	 * @param dy
	 *            variation selon axe ordonnee
	 */
	void seTranslater(int dx, int dy) {
		this.A.seTranslater(dx,dy);
		this.B.seTranslater(dx,dy);
		this.C.seTranslater (dx,dy);
	}

	/**
	 * teste si le triangle est un triangle-rectangle
	 *
	 * @return vrai si et seulement si le triangle est rectangle
	 */
	boolean etreRectangle() {
		boolean rectangle=false ;
		if (A.calculerCarreDistance(B)==A.calculerCarreDistance(C)+B.calculerCarreDistance(C)){
			rectangle= true;
		}
		if (A.calculerCarreDistance(C)==A.calculerCarreDistance(B)+B.calculerCarreDistance(B)){
			rectangle = true;
		}
		if (C.calculerCarreDistance(B)==A.calculerCarreDistance(B)+B.calculerCarreDistance(C)){
			rectangle= true;
	}

			return (rectangle);
	}

	/**
	 * retourne le centre du cercle circonsrit au triangle
	 *
	 * @return centre du cercle circonscrit
	 */
	UnPoint calculerCentreCercleCirconscrit() {
		// resultat
		UnPoint res;
			if ((this.A.abscisse == this.B.abscisse && this.B.abscisse == this.C.abscisse)||
			(this.A.ordonnee == this.B.ordonnee && this.B.ordonnee == this.C.ordonnee)) {
		res=null;
	} else {
		double x = this.calculerXCirconscrit();
		double y = this.calculerYCirconscrit();
		res = new UnPoint(x,y);
	}
		return res;
	}

	/**
	 * retourne le rayon du cercle du centrecirconscrit
	 *
	 * @return rayon cercle circonscrit
	 */
	int calculerRayonCercleCirconscrit() {
		int resultat = 0;
		UnPoint center;
		center=this.calculerCentreCercleCirconscrit();
		if (center !=null) {
			resultat = center.calculerDistance(this.A);
		}

		return (resultat);
	}

	/**
	 * retourne le denominateur pour faire les calculs du cercle
	 * circonscrit
	 *
	 * @return denominateur cercle circonscrit
	 */
	double calculerDivCirconscrit() {
		int yC = this.C.ordonnee;
		int yA = this.A.ordonnee;
		int yB = this.B.ordonnee;
		int xA = this.A.abscisse;
		int xB = this.B.abscisse;
		int xC = this.C.abscisse;
		double div = 2.0 * ((yC - yA) * (xB - xA) - (xC - xA) * (yB - yA));
		return (div);
	}

	/**
	 * retourne l'abscisse du cercle circonscrit
	 *
	 * @return abscisse cercle circonscrit
	 */
	double calculerXCirconscrit() {
		int yC = this.C.ordonnee;
		int yA = this.A.ordonnee;
		int yB = this.B.ordonnee;
		int xA = this.A.abscisse;
		int xB = this.B.abscisse;
		int xC = this.C.abscisse;
		double div = this.calculerDivCirconscrit();
		int x = (yC - yA) * (yB - yA) * (yB - yC) + (xA + xB) * (xB - xA)
				* (yC - yA) - (xA + xC) * (xC - xA) * (yB - yA);
		return x / div;
	}

	/**
	 * retourne l'ordonnee du cercle circonscrit
	 *
	 * @return ordonnee cercle circonscrit
	 */
	double calculerYCirconscrit() {
		int yC = this.C.ordonnee;
		int yA = this.A.ordonnee;
		int yB = this.B.ordonnee;
		int xA = this.A.abscisse;
		int xB = this.B.abscisse;
		int xC = this.C.abscisse;
		double div = -this.calculerDivCirconscrit();
		int y = (xC - xA) * (xB - xA) * (xB - xC) + (yA + yB) * (yB - yA)
				* (xC - xA) - (yA + yC) * (yC - yA) * (xB - xA);
		return y / div;
	}

}
