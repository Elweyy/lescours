import static libtest.Lanceur.*;
import static libtest.OutilTest.*;



/**
 * classe charg�e de tester les constructeur de rectangle
 * @author vthomas
 *
 */
public class Test1ConstructeurVide {
	
	/**
	 * test constructeur vide
	 */
	public void test_1_ConstructeurVide()
	{
		UnRectangle r=new UnRectangle();
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
		//appelle la m�thode statique de Lanceur
		lancer(new Test1ConstructeurVide(),args);
	}

}
