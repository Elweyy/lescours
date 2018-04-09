/**
 * classe UnPoint modelise des points
 **/
class UnPoint {

	/**
	 * attributs coordonnees du point
	 **/
	int abscisse, ordonnee;

	/**
	 * constructeur vide initialise un point (0,0)
	 **/
	UnPoint() {
		this.abscisse = 0;
		this.ordonnee = 0;
	}

	/**
	 * constructeur a deux entiers
	 *
	 * @param a
	 *            abscisse du point cree
	 * @param o
	 *            ordonnee du point cree
	 */
	UnPoint(int a, int o) {
		this.abscisse = a;
		this.ordonnee = o;
	}
	UnPoint(UnPoint c){
		if(c==null){
			this.abscisse=0;
			this.ordonnee=0;
		}
		else{ this.abscisse= c.abscisse;
				 this.ordonnee= c.ordonnee;
		}
	}
	// TODO a completer
}
