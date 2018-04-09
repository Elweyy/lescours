import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

/**
 * classe de test pour le TP05
 * methode avec resultat
 * 
 * @author vthomas
 * 
 */
public class TestMethodeUnTriangle {

	/**
	 * test du constructeur cas normal
	 * trois points existants
	 */
	public void test_3_constructeurTriangleNormal() {
		UnPoint p = new UnPoint(10, 10);
		UnPoint p1 = new UnPoint(20, 10);
		UnPoint p2 = new UnPoint(10, 20);
		UnTriangle t = new UnTriangle(p, p1, p2);

		// verfie les references des points
		assertEquals(true, t.A != p,
				"les references du parametre et de A sont les memes");
		assertEquals(true, t.B != p1,
				"les references du parametre et de B sont les memes");
		assertEquals(true, t.C != p2,
				"les references du parametre et de C sont les memes");

		assertEquals(true, t.A != null, "A doit etre non null");
		assertEquals(true, t.B != null, "B doit etre non null");
		assertEquals(true, t.C != null, "C doit etre non null");

		// verifie les valeurs
		assertEquals(10, t.A.abscisse, "l'abscisse de A n'est pas bonne");
		assertEquals(10, t.A.ordonnee, "l'ordonnee de A n'est pas bonne");
		assertEquals(10, t.B.ordonnee, "l'ordonnee de B n'est pas bonne");
		assertEquals(20, t.B.abscisse, "l'absisse de B n'est pas bonne");
		assertEquals(10, t.C.abscisse, "l'absisse de C n'est pas bonne");
		assertEquals(20, t.C.ordonnee, "l'ordonnee de C n'est pas bonne");
	}

	/**
	 * test du constructeur cas de pointsnull
	 * certains points sont null
	 */
	public void test_4_constructeurPointNull() {
		UnPoint p = new UnPoint(10, 10);
		UnPoint p1 = new UnPoint(20, 10);
		UnPoint p2 = new UnPoint(10, 20);
		UnTriangle t = new UnTriangle(p, p1, null);

		// verfie les references des points
		assertEquals(true, t.A != p,
				"les references du parametre et de A sont les memes");
		assertEquals(true, t.B != p1,
				"les references du parametre et de B sont les memes");
		assertEquals(true, t.C != null,
				"la reference de C ne devrait pas etre null");

		// verifie les valeurs
		assertEquals(10, t.A.abscisse, "l'abscisse de A n'est pas bonne");
		assertEquals(10, t.A.ordonnee, "l'ordonnee de A n'est pas bonne");
		assertEquals(10, t.B.ordonnee, "l'ordonnee de B n'est pas bonne");
		assertEquals(20, t.B.abscisse, "l'absisse de B n'est pas bonne");
		assertEquals(0, t.C.abscisse, "l'absisse de C n'est pas bonne");
		assertEquals(0, t.C.ordonnee, "l'ordonnee de C n'est pas bonne");

		t = new UnTriangle(null, p1, p2);
		assertEquals(true, t.A != null,
				"la reference de A ne devrait pas etre null");

		t = new UnTriangle(p, null, p2);
		assertEquals(true, t.B != null,
				"la reference de B ne devrait pas etre null");
	}

	/**
	 * test du constructeur par copie - cas normal
	 */
	public void test_5_constructeurRectangle() {
		UnPoint p = new UnPoint(10, 10);
		UnPoint p1 = new UnPoint(20, 10);
		UnPoint p2 = new UnPoint(10, 20);
		UnTriangle t = new UnTriangle(p, p1, p2);
		UnTriangle t2 = new UnTriangle(t);

		// verfie les references des points
		assertEquals(true, t.A != t2.A,
				"les references de A sont les memes sur les deux rectangles");
		assertEquals(true, t.B != t2.B,
				"les references de A sont les memes sur les deux rectangles");
		assertEquals(true, t.C != t2.C,
				"les references de A sont les memes sur les deux rectangles");
	}

	/**
	 * test du constructeur par copie - cas de rectangle null
	 */
	public void test_6_constructeurRectangleNull() {
		UnTriangle t = null;
		UnTriangle t2 = new UnTriangle(t);

		// verfie les references des points
		assertEquals(true, t2.A != null,
				"les references de A sont les memes sur les deux triangles");
		assertEquals(true, t2.B != null,
				"les references de A sont les memes sur les deux triangles");
		assertEquals(true, t2.C != null,
				"les references de A sont les memes sur les deux triangles");
	}

	/**
	 * test de se translater - cas normal
	 */
	public void test_7_translaterRectangle() {

		UnTriangle t2 = new UnTriangle(new UnPoint(10, 10),
				new UnPoint(20, 30), new UnPoint(40, 50));
		t2.seTranslater(1, -2);

		// verfie les references des points
		assertEquals(true, t2.A != null, "A doit etre non null");
		assertEquals(true, t2.B != null, "B doit etre non null");
		assertEquals(true, t2.C != null, "C doit etre non null");

		// verfie les coordonnées du triangle
		assertEquals(11, t2.A.abscisse, "erreur abscisse de A");
		assertEquals(8, t2.A.ordonnee, "erreur ordonnee de A");
		assertEquals(21, t2.B.abscisse, "erreur abscisse de B");
		assertEquals(28, t2.B.ordonnee, "erreur ordonnee de B");
		assertEquals(41, t2.C.abscisse, "erreur abscisse de C");
		assertEquals(48, t2.C.ordonnee, "erreur ordonnee de C");
	}

	/**
	 * test de estRectangle - cas resultat true
	 */
	public void test_8_estRectangle() {

		UnTriangle t = new UnTriangle(new UnPoint(0, 0), new UnPoint(1, 0),
				new UnPoint(0, 1));

		// verfie les coordonnées du triangle
		assertEquals(true, t.etreRectangle(),
				"le triangle devrait etre rectangle");
	}

	/**
	 * test de estRectangle - cas resultat false
	 */
	public void test_9_estRectangleFaux() {

		UnTriangle t = new UnTriangle(new UnPoint(10, 0), new UnPoint(1, 0),
				new UnPoint(0, 1));

		// verfie les coordonnées du triangle
		assertEquals(false, t.etreRectangle(),
				"le triangle ne devrait pas etre rectangle");
	}

	/**
	 * test de caclulerCentre - cas normal
	 */
	public void test_10_centreCirconscrit() {

		UnTriangle t = new UnTriangle(new UnPoint(0, 0), new UnPoint(100, 0),
				new UnPoint(0, 100));
		UnPoint centre = t.calculerCentreCercleCirconscrit();
		// verifie que lepoint n'est pas null
		assertEquals(true, centre != null, "le centre n'est pas calculé (null)");
		// verfie les coordonnées du triangle
		assertEquals(50, centre.abscisse,
				"l'abscisse du centre n'est pas bonne");
		assertEquals(50, centre.ordonnee,
				"l'ordonnee du centre n'est pas bonne");

	}

	/**
	 * test de caclulerCentre - cas points alignes
	 */
	public void test_11_centreCirconscritAlignes() {

		UnTriangle t = new UnTriangle(new UnPoint(0, 0), new UnPoint(100, 0),
				new UnPoint(200, 0));
		UnPoint centre = t.calculerCentreCercleCirconscrit();
		// verifie que lepoint n'est pas null
		assertEquals(true, centre == null, "le centre devrait etre null)");
	}

	/**
	 * test de cacluler Rayon - cas normal
	 */
	public void test_12_rayonCirconscrit() {

		UnTriangle t = new UnTriangle(new UnPoint(0, 0), new UnPoint(100, 0),
				new UnPoint(0, 100));
		// verifie que lepoint n'est pas null
		assertEquals(71, t.calculerRayonCercleCirconscrit(),
				"le rayon du cercle devrait etre 71)");
	}

	/**
	 * lancement des tests
	 * 
	 * @param args
	 *            vide
	 */
	public static void main(String[] args) {
		lancer(new TestMethodeUnTriangle(), args);
	}

}
