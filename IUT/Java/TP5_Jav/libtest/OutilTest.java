package libtest;


/**
 * stocke les m�thodes appel�es dans les classes de test
 * possade des assertEquals et des m�thode de v�rification par introspection
 * 
 * @author vthomas
 *
 */
public class OutilTest {

	/**
	 * methode statique de comparaison
	 */
	public static void assertEquals(Object attendu, Object obtenu, String erreur) {
		// si on test des references null
		if (attendu == null) {
			if (obtenu != null)
				throw new LanceurTestException(erreur + " [attendu=>" + attendu
						+ ", obtenu=>" + obtenu + "]");
		}
		// sinon on peut tester egalite
		else if (!attendu.equals(obtenu))
			throw new LanceurTestException(erreur + " [attendu=>" + attendu
					+ ", obtenu=>" + obtenu + "]");
	}

	/**
	 * methode statique de test qui echoue
	 */
	public static void fail(String erreur) {
		throw new LanceurTestException(erreur);
	}

}
