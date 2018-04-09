import static libtest.Lanceur.*;
import static libtest.OutilTest.*;


/**
 * classe chargée de tester les constructeur de rectangle
 * @author vthomas
 *
 */
public class Test2Constructeur2Int {
	
	
	
	/**
	 * test constructeur largeur et hauteur
	 */
	public void test_2_Constructeur2Int()
	{
		UnRectangle r=new UnRectangle(2,2);
		assertEquals(2, r.hauteur, "pas bonne hauteur");
		assertEquals(2, r.largeur, "pas bonne largeur");
		assertEquals(0, r.coin.abscisse, "pas bonne abscisse");
		assertEquals(0, r.coin.ordonnee, "pas bonne ordonne");		
	}
	
	/**
	 * test constructeur largeur et hauteur avec largeur negative
	 */
	public void test_3_Constructeur2IntParamNegatif()
	{
		UnRectangle r=new UnRectangle(-2,2);
		assertEquals(2, r.hauteur, "pas bonne hauteur");
		assertEquals(1, r.largeur, "pas bonne largeur");
		assertEquals(0, r.coin.abscisse, "pas bonne abscisse");
		assertEquals(0, r.coin.ordonnee, "pas bonne ordonne");		
	}
	
	/**
	 * test constructeur largeur et hauteur avec largeur negative
	 */
	public void test_4_Constructeur2IntParamNegatif()
	{
		UnRectangle r=new UnRectangle(3,-2);
		assertEquals(1, r.hauteur, "pas bonne hauteur");
		assertEquals(3, r.largeur, "pas bonne largeur");
		assertEquals(0, r.coin.abscisse, "pas bonne abscisse");
		assertEquals(0, r.coin.ordonnee, "pas bonne ordonne");		
	}
	
	
	
	/**
	 * lancement des tests
	 */
	public static void main(String args[])
	{
		lancer(new Test2Constructeur2Int(),args);
	}

}
