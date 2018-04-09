import static libtest.Lanceur.lancer;
import static libtest.OutilTest.*;


/**
 * classe chargée de tester les constructeur de rectangle
 * @author vthomas
 *
 */
public class TestUnitaireRectangles {
	
	/**
	 * test constructeur vide
	 */
	public void test_1_ConstructeurVide()
	{
		UnRectangle r=new UnRectangle();
		assertEquals(1, r.hauteur, "pas bonne hauteur");
		assertEquals(1, r.largeur, "pas bonne largeur");
		assertEquals(0, r.coin.abscisse, "pas bonne abscisse");
		assertEquals(0, r.coin.ordonnee, "pas bonne ordonne");		
	}
	
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
		assertEquals(1, r.largeur, "pas bonne largeur");
		assertEquals(2, r.hauteur, "pas bonne hauteur");
		assertEquals(0, r.coin.abscisse, "pas bonne abscisse");
		assertEquals(0, r.coin.ordonnee, "pas bonne ordonne");		
	}
	
	/**
	 * test constructeur largeur et hauteur avec largeur negative
	 */
	public void test_4_Constructeur2IntParamNegatif()
	{
		UnRectangle r=new UnRectangle(3,-2);
		assertEquals(3, r.largeur, "pas bonne largeur");
		assertEquals(1, r.hauteur, "pas bonne hauteur");		
		assertEquals(0, r.coin.abscisse, "pas bonne abscisse");
		assertEquals(0, r.coin.ordonnee, "pas bonne ordonne");		
	}
	
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
	public void test_6_ConstructeurPointNull()
	{
		UnPoint p=null;
		UnRectangle r=new UnRectangle(p);
		assertEquals(1, r.largeur, "pas bonne largeur");
		assertEquals(1, r.hauteur, "pas bonne hauteur");		
		assertEquals(0, r.coin.abscisse, "pas bonne abscisse");
		assertEquals(0, r.coin.ordonnee, "pas bonne ordonne");		
	}
	
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
	 * test constructeur avec point et deux entiers
	 */
	public void test_11_ConstructeurPoint2Int()
	{
		UnPoint p=new UnPoint(10,20);
		UnRectangle r=new UnRectangle(p,30,40);
		assertEquals(30, r.largeur, "pas bonne largeur");
		assertEquals(40, r.hauteur, "pas bonne hauteur");
		assertEquals(10, r.coin.abscisse, "pas bonne abscisse");
		assertEquals(20, r.coin.ordonnee, "pas bonne ordonne");		
		assertEquals(false, r.coin==p, "ne devrait pas avoir meme reference");		
	}
	
	/**
	 * test constructeur avec point et deux entiers
	 */
	public void test_12_ConstructeurPoint2IntPointNull()
	{
		UnPoint p=null;
		UnRectangle r=new UnRectangle(p,30,40);
		assertEquals(30, r.largeur, "pas bonne largeur");
		assertEquals(40, r.hauteur, "pas bonne hauteur");
		assertEquals(0, r.coin.abscisse, "pas bonne abscisse");
		assertEquals(0, r.coin.ordonnee, "pas bonne ordonne");		
	}
	
	
	/**
	 * test constructeur avec point et deux entiers
	 */
	public void test_13_ConstructeurPoint2IntLargeurNegative()
	{
		UnPoint p=new UnPoint(10,20);
		UnRectangle r=new UnRectangle(p,-30,40);
		assertEquals(1, r.largeur, "pas bonne largeur");
		assertEquals(40, r.hauteur, "pas bonne hauteur");
		assertEquals(10, r.coin.abscisse, "pas bonne abscisse");
		assertEquals(20, r.coin.ordonnee, "pas bonne ordonne");		
		assertEquals(false, r.coin==p, "ne devrait pas avoir meme reference");		
	}
	
	
	
	/**
	 * test constructeur avec point et deux entiers
	 */
	public void test_14_ConstructeurPoint2IntLargeurNegativePointNull()
	{
		UnPoint p=null;
		UnRectangle r=new UnRectangle(p,-30,40);
		assertEquals(1, r.largeur, "pas bonne largeur");
		assertEquals(40, r.hauteur, "pas bonne hauteur");
		assertEquals(0, r.coin.abscisse, "pas bonne abscisse");
		assertEquals(0, r.coin.ordonnee, "pas bonne ordonne");		
	}
	
	/**
	 * test constructeur par copie
	 */
	public void test_15_ConstructeurCopie()
	{
		UnRectangle origine=new UnRectangle(10, 20, 30, 40);
		UnRectangle r=new UnRectangle(origine);
		assertEquals(30, r.largeur, "pas bonne largeur");
		assertEquals(40, r.hauteur, "pas bonne hauteur");
		assertEquals(10, r.coin.abscisse, "pas bonne abscisse");
		assertEquals(20, r.coin.ordonnee, "pas bonne ordonne");		
		//reference différente
		assertEquals(false, origine.coin==r.coin, "meme reference dans les rectangles");
	}
	
	/**
	 * test constructeur par copie
	 */
	public void test_16_ConstructeurCopieNull()
	{
		UnRectangle origine=null;
		UnRectangle r=new UnRectangle(origine);
		assertEquals(1, r.largeur, "pas bonne largeur");
		assertEquals(1, r.hauteur, "pas bonne hauteur");
		assertEquals(0, r.coin.abscisse, "pas bonne abscisse");
		assertEquals(0, r.coin.ordonnee, "pas bonne ordonne");		
	}
	
	/**
	 * lancement des tests
	 */
	public static void main(String args[])
	{
		lancer(new TestUnitaireRectangles(),args);
	}

}
