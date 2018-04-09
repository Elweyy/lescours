import static libtest.Lanceur.*;
import static libtest.OutilTest.*;




/**
 * classe chargée de tester les constructeur de rectangle
 * @author vthomas
 *
 */
public class Test5ConstructeurPoint2Int {
	
	
	
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
	 * lancement des tests
	 */
	public static void main(String args[])
	{
		lancer(new Test5ConstructeurPoint2Int(),args);
	}

}
