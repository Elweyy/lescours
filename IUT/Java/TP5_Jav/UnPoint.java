/**
 * classe UnPoint (etudiant TD5) modelise des points
 *
 * @author vthomas
 *
 */
class UnPoint {

	/**
	 * attribut coordoonees du point
	 */
	int abscisse, ordonnee;

	/**
	 * constructeur vide construit un point en (0,0)
	 */
	UnPoint() {
		this.abscisse = 0;
		this.ordonnee = 0;
	}

	/**
	 * constructeur par copie de point construit un nouveau point avec les memes
	 * coordonnees (en (0,0) si le parametre est null)
	 *
	 * @param p
	 *            point origine
	 */
	UnPoint(UnPoint p) {
		if (p != null) {
			this.abscisse = p.abscisse;
			this.ordonnee = p.ordonnee;
		} else {
			this.abscisse = 0;
			this.ordonnee = 0;
		}
	}

	/**
	 * construit un point de coordonnees donnees
	 *
	 * @param a
	 *            abscisse du point construit
	 * @param o
	 *            ordonnee du point construit
	 */
	UnPoint(int a, int o) {
		this.abscisse = a;
		this.ordonnee = o;
	}

	/**
	 * constructeur � partir de deux doubles
	 *
	 * @param a
	 *            abscisse du point construit
	 * @param o
	 *            ordonne du point construit
	 */
	UnPoint(double a, double o) {
		OutilsMath m= new OutilsMath ();
		this.abscisse= m.calculerArrondi(a);
		this.ordonnee= m.calculerArrondi(o);
	}




	/**
	 * m�thode qui demande au point de se d�placer
	 *
	 * @param dx
	 *            variation selon les abscisses
	 * @param dy
	 *            variation selon les ordonnees
	 */
	void seTranslater(int dx, int dy) {
		this.abscisse = this.abscisse + dx;
		this.ordonnee = this.ordonnee + dy;
	}

	/**
	 * m�thode qui demande au point de faire son sym�trique
	 */
	void faireSymetrie() {
		// TODO recup�rer du TD4
	}

	/**
	 * m�thode qui demande de claculer la distance avec un deuxi�me point
	 *
	 * @param p
	 *            deuxieme point
	 *
	 * @return distance entre this et p
	 */
	int calculerDistance(UnPoint p) {
		int res=0;
		OutilsMath m =new OutilsMath();
		int dist2 = this.calculerCarreDistance(p);
		res = m.calculerRacineEntiere(dist2);
		return(res);
	}

	/**
	 * m�thode qui demande de claculer la distance au carre avec un deuxi�me
	 * point
	 *
	 * @param p
	 *            deuxieme point
	 *
	 * @return distance entre this et p
	 */
	int calculerCarreDistance(UnPoint p) {
		int res=0;
		res= (this.abscisse - p.abscisse)*(this.abscisse - p.abscisse)+(this.ordonnee - p.ordonnee)*(this.ordonnee - p.ordonnee);
		return res;
	}

}
