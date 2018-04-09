import static libtest.Lanceur.*;
import static libtest.OutilTest.*;



/**
 * classe chargée de tester les constructeur de rectangle
 * @author vthomas
 *
 */
public class Test6ConstructeurCopie {
	
	
	
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
		lancer(new Test6ConstructeurCopie(),args);
	}

}
