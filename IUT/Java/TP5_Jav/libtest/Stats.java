package libtest;

/**
 * stocke les statistiques des logs de test
 * 
 * @author vthomas
 * 
 */
public class Stats {

	/**
	 * le nombre de tests
	 */
	int nbTests;

	/**
	 * le nombre de tests ok, echecs et erreurs
	 */
	int nbOk, nbEchec, nbErreur;

	/**
	 * retourne l'affichage des statistiques
	 */
	public String toString() {
		String r = "";
		r += "nb test:" + this.nbTests;
		r += "\n" + "nb Ok:" + this.nbOk;
		r += "\n" + "nb Echec:" + this.nbEchec;
		r += "\n nb erreur:" + this.nbErreur;
		return (r);
	}
}
