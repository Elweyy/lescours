import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

/**
 * classe de etst pour le TD4
 * methode sans resultat
 * 
 * @author vthomas
 * 
 */
public class Test2MethodeRotation {

	/**
	 * fait un test de rotation
	 */
	public void test_7_Rotation() {
		UnRectangle r = new UnRectangle(new UnPoint(10, 20), 100, 200);
		r.faireRotation();
		assertEquals("mauvaise abscisse du coin", -190, r.coin.abscisse);
		assertEquals("mauvaise ordonee du coin", 20, r.coin.ordonnee);
		assertEquals("mauvaise hauteur du rectangle", 100, r.hauteur);
		assertEquals("mauvaise largeur du rectangle", 200, r.largeur);
	}

	/**
	 * lancement des tests
	 * 
	 * @param args
	 *            vide
	 */
	public static void main(String[] args) {
		lancer(new Test2MethodeRotation(), args);
	}

}
