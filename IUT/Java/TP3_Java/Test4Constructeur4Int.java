import static libtest.Lanceur.*;
import static libtest.OutilTest.*;



/**
 * classe chargée de tester les constructeur de rectangle
 * @author vthomas
 *
 */
public class Test4Constructeur4Int {
	
	
	
	/**
	 * test constructeur avec 4 entiers
	 */
	public void test_7_Constructeur4Int()
	{
		UnRectangle r=new UnRectangle(10,20,30,40);
		assertEquals(30, r.largeur, "pas bonne largeur");
		assertEquals(40, r.hauteur, "pas bonne hauteur");
		assertEquals(10, r.coin.abscisse, "pas bonne abscisse");
		assertEquals(20, r.coin.ordonnee, "pas bonne ordonne");		
	}
	
	/**
	 * test constructeur avec 4 entiers
	 */
	public void test_8_Constructeur4IntLargeurNegative()
	{
		UnRectangle r=new UnRectangle(10,20,-30,40);
		assertEquals(1, r.largeur, "pas bonne largeur");
		assertEquals(40, r.hauteur, "pas bonne hauteur");
		assertEquals(10, r.coin.abscisse, "pas bonne abscisse");
		assertEquals(20, r.coin.ordonnee, "pas bonne ordonne");		
	}
	
	/**
	 * test constructeur avec 4 entiers
	 */
	public void test_9_Constructeur4IntHauteurNegative()
	{
		UnRectangle r=new UnRectangle(10,20,30,-40);
		assertEquals(30, r.largeur, "pas bonne largeur");
		assertEquals(1, r.hauteur, "pas bonne hauteur");
		assertEquals(10, r.coin.abscisse, "pas bonne abscisse");
		assertEquals(20, r.coin.ordonnee, "pas bonne ordonne");		
	}
	
	/**
	 * test constructeur avec 4 entiers
	 */
	public void test_10_Constructeur4IntHauteurLargeurNegatives()
	{
		
		UnRectangle r=new UnRectangle(10,20,-30,-40);
		assertEquals(1, r.largeur, "pas bonne largeur");
		assertEquals(1, r.hauteur, "pas bonne hauteur");
		assertEquals(10, r.coin.abscisse, "pas bonne abscisse");
		assertEquals(20, r.coin.ordonnee, "pas bonne ordonne");		
	}
	
	
	/**
	 * lancement des tests
	 */
	public static void main(String args[])
	{
		lancer(new Test4Constructeur4Int(),args);
	}

}
