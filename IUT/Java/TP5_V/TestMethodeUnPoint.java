import static libtest.Lanceur.*;
import static libtest.OutilTest.*;

/**
 * classe de test pour le TP05
 * méthode avec résultat
 * 
 * @author vthomas
 * 
 */
public class TestMethodeUnPoint {

	/**
	 * test la méthode de caclul de la distance au carre
	 */
	public void test_1_calculerCarre()
	{
		UnPoint p=new UnPoint(40,50);
		UnPoint p2=new UnPoint(40,60);
		assertEquals(100, p.calculerCarreDistance(p2), "mauvais calcul horizontal");
		p2=new UnPoint(70,90);
		assertEquals(2500, p.calculerCarreDistance(p2), "mauvais calcul carre distance");
		assertEquals(0, p.calculerCarreDistance(p), "mauvais calcul distance = 0");
	}
	
	/**
	 * test la méthode de caclul de la distance 
	 */
	public void test_2_calculerDistance()
	{
		UnPoint p=new UnPoint(40,50);
		UnPoint p2=new UnPoint(40,60);
		assertEquals(10, p.calculerDistance(p2), "mauvais calcul horizontal");
		p2=new UnPoint(70,90);
		assertEquals(50, p.calculerDistance(p2), "mauvais calcul distance");
		assertEquals(0, p.calculerDistance(p), "mauvais calcul distance = 0");
	}

	/**
	 * lancement des tests
	 * 
	 * @param args
	 *            vide
	 */
	public static void main(String[] args) {
		lancer(new TestMethodeUnPoint(),args);
	}

}
