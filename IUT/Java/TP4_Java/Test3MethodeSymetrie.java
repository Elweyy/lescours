import static libtest.Lanceur.*;
import static libtest.OutilTest.*;


/**
 * classe de etst pour le TD4
 * methode sans resultat
 * 
 * @author vthomas
 * 
 */
public class Test3MethodeSymetrie {

		
	
	/**
	 * fait un test de symetrie du point
	 */
	public void test_8_SymetriePoint() {
		UnPoint p=new UnPoint(10, 20);
		p.faireSymetrie();
		assertEquals("mauvaise abscisse du point symetrique", 20,
				p.abscisse);
		assertEquals("mauvaise ordonnee du point symetrique", 10,
				p.ordonnee);	
	}
	
	/**
	 * fait un test de symetrie
	 */
	public void test_9_Symetrie() {
		UnRectangle r = new UnRectangle(
				new UnPoint(10, 20), 100, 200);
		r.faireSymetrie();
		assertEquals("mauvaise abscisse du coin", -180,
				r.coin.abscisse);
		assertEquals("mauvaise ordonee du coin", 110,
				r.coin.ordonnee);
		assertEquals("mauvaise hauteur du rectangle", 100,
				r.hauteur);
		assertEquals("mauvaise largeur du rectangle", 200,
				r.largeur);		
	}

	/**
	 * lancement des tests
	 * 
	 * @param args
	 *            vide
	 */
	public static void main(String[] args) {
		lancer(new Test3MethodeSymetrie(),args);
	}

}
