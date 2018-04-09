package libtest;

/**
 * cree une classe d'Exception qui remonte sans verifier le try catch
 * 
 * @author vthomas
 */
class LanceurTimeOut extends Exception {


	/**
	 * constructeur avec un message
	 * 
	 * @param s
	 *            message d'erreur
	 */
	public LanceurTimeOut(String s) {
		super(s);
	}

}