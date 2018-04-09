/**
 * Classe UnCercle modelise des cercles Version 2 - TP5
 *
 * deux cas se produisent
 * - soit le cercle est asocie a un triangle circonscrit
 * vaut vrai et centre et rayon sont vides
 * - soit le cercle n'est pas associe a
 * un triangle circonscrit vaut faux et associe est vide
 */

class UnCercle {
	/**
	 * vaut true si le cercle est circonscrit a un triangle
	 */
	private boolean circonscrit;

	/**
	 * triangle (�ventuel) auquel le cercle est circonscrit
	 */
	private UnTriangle associe;

	/**
	 * centre et rayons (eventuel) du cercle s'il est non circonscrit
	 * a un triangle
	 */
	private UnPoint centre;
	private int rayon;

	/**
	 * constructeur de Cercle non circonscrit a un triangle
	 *
	 * @param x
	 *            abscisse du centre
	 * @param y
	 *            ordonnee du centre
	 * @param r
	 *            rayon du cercle
	 */
	UnCercle(int x, int y, int r) {
		this.centre = new UnPoint(x,y);
		this.rayon = r;
			}

	/**
	 * constructeur de Cercle non circonscrit a un triangle
	 *
	 * @param c
	 *            centre du cercle
	 * @param r
	 *            rayon du cercle
	 */
	UnCercle(UnPoint c, int r) {
		if (c != null){
		this.centre = new UnPoint(c);
		}
		else {
			this.centre = new UnPoint(0,0);
		}
		this.rayon = r;
			}

	/**
	 * constructeur de Cercle circonscrit a un triangle
	 *
	 * @param t
	 *            triangle pour construire cercle
	 */
	UnCercle(UnTriangle t) {
		if (t == null) {
			t = new UnTriangle(new UnPoint(0,0),new UnPoint(1,0),new UnPoint(2,3));
		}
		this.associe = new UnTriangle(t);
		this.centre = t.calculerCentreCercleCirconscrit();
		this.rayon = t.calculerRayonCercleCirconscrit();
		this.circonscrit = true;
	}
	/**
	 * constructeur par copie de Cercle
	 *
	 * @param c
	 *            information d'origine
	 */
	 UnCercle(UnCercle c) {

		//cercle non existant
 		if (c == null) {
 			c = new UnCercle(2,3,5);
 		}
		//cercle existant mais pas circonscrit
 		if (c.circonscrit != true) {
 			this.centre = new UnPoint(c.centre);
 			this.rayon = c.rayon;
 		}//cercle existant mais circonscrit
 		if (c.circonscrit == true && c.associe != null) {
 			this.circonscrit = true;
 			this.associe = new UnTriangle(c.associe);
 		}
 	}

	/**
	 * methode qui retourne le centre
	 *
	 * @return centre du cercle
	 */
	 UnPoint retournerCentre() {
 		UnPoint res = null;
 		// TODO a completer
 		if (this.circonscrit == true && this.associe != null) {
 				res = this.associe.calculerCentreCercleCirconscrit();
 		}
 		else {
 			res = this.centre;
 		}

 		return res;
 	}

	/**
	 * methode qui retourne le rayon
	 *
	 * @return rayon du cercle
	 */
	 int retournerRayon() {
 		int res = 0;
 		if (this.circonscrit == true && this.associe != null) {
 				res = this.associe.calculerRayonCercleCirconscrit();
 		}
 		else {
 			res = this.rayon;
 		}

 		return res;
 	}


	/**
	 * methode qui deplace le cercle
	 *
	 * @param dx
	 *            variation selon axe des abscisses
	 * @param dy
	 *            variation selon axe des ordonn�es
	 */
	 void seTranslater(int dx, int dy) {

 		this.centre.seTranslater(dx,dy);

 	}
	/**
	 * permet de savoir si le cercle est construit a partir d'un
	 * triangle
	 *
	 * @return attribut circonscrit
	 */
	public boolean getCirconscrit() {
		return this.circonscrit;
	}

}
