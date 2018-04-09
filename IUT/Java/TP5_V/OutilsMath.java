/****************************************
 *  classe OutilMath
 * Version 2 - TP5
 *****************************************/

/**
 * donne des outils pour faire quelques operations mathematiques
 * 
 * @author vthomas
 * 
 */
class OutilsMath {

	/**
	 * fait l'arrondi d'un double
	 * 
	 * @param x
	 *            double dont on veut l'arrondi
	 * @return l'arrondi du double
	 */
	int calculerArrondi(double x) {
		return (int) (Math.round(x));
	}

	/**
	 * calcule la racine entier
	 * 
	 * @param i
	 *            nombre dont on veut la racine
	 * @return racine du nombre
	 */
	int calculerRacineEntiere(int i) {
		return calculerArrondi(Math.sqrt(i));
	}
}
