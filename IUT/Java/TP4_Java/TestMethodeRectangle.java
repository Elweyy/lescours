import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

/**
 * classe de etst pour le TD4
 * methode sans resultat
 * 
 * @author vthomas
 * 
 */
public class TestMethodeRectangle {

	/**
	 * modifie largeur quand tout va bien
	 */
	public void test_1_ModifieLargeurNormal() {
		UnRectangle r = new UnRectangle();
		assertEquals("pas la bonne largeur initiale", 1, r.largeur);
		r.modifierLargeur(1);
		assertEquals("ne modifie pas la largeur", 2, r.largeur);
	}

	/**
	 * modifie largeur quand elle devient negative
	 */
	public void test_2_ModifieLargeurNegative() {
		UnRectangle r = new UnRectangle();
		assertEquals("pas la bonne largeur initiale", 1, r.largeur);
		r.modifierLargeur(-12);
		assertEquals("la largeur ne peut pas etre negative", 1, r.largeur);
	}

	/**
	 * modifie largeur quand elle devient egal a 0
	 */
	public void test_3_ModifieLargeurNulle() {
		UnRectangle r = new UnRectangle();
		assertEquals("pas la bonne largeur initiale", 1, r.largeur);
		r.modifierLargeur(-1);
		assertEquals("la largeur ne peut pas etre nulle", 1, r.largeur);
	}

	/**
	 * modifie hauteur quand tout va bien
	 */
	public void test_4_ModifieHauteurNormal() {
		UnRectangle r = new UnRectangle();
		assertEquals("pas la bonne hauteur initiale", 1, r.hauteur);
		r.modifierHauteur(1);
		assertEquals("ne modifie pas la hauteur", 2, r.hauteur);
	}

	/**
	 * modifie largeur quand elle devient negative
	 */
	public void test_5_ModifieHauteurNegative() {
		UnRectangle r = new UnRectangle();
		assertEquals("pas la bonne hauteur initiale", 1, r.hauteur);
		r.modifierHauteur(-12);
		assertEquals("la hauteur ne peut pas etre negative", 1,
				r.hauteur);
	}

	/**
	 * modifie largeur quand elle devient egal a 0
	 */
	public void test_6_ModifieHauteurNulle() {
		UnRectangle r = new UnRectangle();
		assertEquals("pas la bonne hauteur initiale", 1, r.hauteur);
		r.modifierLargeur(-1);
		assertEquals("la hauteur ne peut pas etre nulle", 1,
				r.hauteur);
	}

	/**
	 * fait un test de rotation
	 */
	public void test_7_Rotation() {
		UnRectangle r = new UnRectangle(new UnPoint(10, 20), 100, 200);
		r.faireRotation();
		assertEquals("mauvaise abscisse du coin", -190,
				r.coin.abscisse);
		assertEquals("mauvaise ordonee du coin", 20, r.coin.ordonnee);
		assertEquals("mauvaise hauteur du rectangle", 100, r.hauteur);
		assertEquals("mauvaise largeur du rectangle", 200, r.largeur);
	}

	/**
	 * fait un test de symetrie du point
	 */
	public void test_8_SymetriePoint() {
		UnPoint p = new UnPoint(10, 20);
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
		UnRectangle r = new UnRectangle(new UnPoint(10, 20), 100, 200);
		r.faireSymetrie();
		assertEquals("mauvaise abscisse du coin", -180,
				r.coin.abscisse);
		assertEquals("mauvaise ordonee du coin", 110, r.coin.ordonnee);
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
		lancer(new TestMethodeRectangle(), args);
	}

}
