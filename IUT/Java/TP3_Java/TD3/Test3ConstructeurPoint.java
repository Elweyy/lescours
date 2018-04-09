import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

/**
 * classe chargée de tester les constructeur de rectangle
 * 
 * @author vthomas
 * 
 */
public class Test3ConstructeurPoint {

	/**
	 * test constructeur avec Point
	 */
	public void test_5_ConstructeurPoint() {
		UnPoint p = new UnPoint(10, 20);
		UnRectangle r = new UnRectangle(p);
		assertEquals(1, r.hauteur, "pas bonne hauteur");
		assertEquals(1, r.largeur, "pas bonne largeur");
		assertEquals(10, r.coin.abscisse, "pas bonne abscisse");
		assertEquals(20, r.coin.ordonnee, "pas bonne ordonne");
		assertEquals(false, r.coin==p, "les references doivent etre differentes");
		
	}

	/**
	 * test constructeur avec Point
	 */
	public void test_6_ConstructeurPointNull() {
		UnPoint p = null;
		UnRectangle r = new UnRectangle(p);
		assertEquals(1, r.hauteur, "pas bonne hauteur");
		assertEquals(1, r.largeur, "pas bonne largeur");
		assertEquals(0, r.coin.abscisse, "pas bonne abscisse");
		assertEquals(0, r.coin.ordonnee, "pas bonne ordonne");
	}

	/**
	 * lancement des tests
	 */
	public static void main(String args[]) {
		lancer(new Test3ConstructeurPoint(),args);
	}

}
