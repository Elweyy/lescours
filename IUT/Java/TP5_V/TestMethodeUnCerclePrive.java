import static libtest.Lanceur.*;
import static libtest.OutilTest.*;


/**
 * classe de test pour le TD05
 * méthode sans résultat
 * 
 * @author vthomas
 * 
 */
public class TestMethodeUnCerclePrive {

	/**
	 * test le constructeur de cercle avec des int
	 */
	public void test_13_ConstructeurInt()
	{
		UnCercle c=new UnCercle(10, 20, 15);
		assertEquals(true, c.retournerCentre()!=null, "le centre ne doit pas etre null");
		assertEquals(10, c.retournerCentre().abscisse, "mauvaise abscisse");
		assertEquals(20, c.retournerCentre().ordonnee, "mauvaise ordonnee");
		assertEquals(15, c.retournerRayon(), "mauvais rayon");
		assertEquals(false, c.getCirconscrit(), "circonscrit est a faux");
		
	}
	
	/**
	 * test le constructeur de cercle avec unPoint et un int
	 */
	public void test_14_ConstructeurPointInt()
	{
		UnPoint p = new UnPoint(10,20);
		UnCercle c=new UnCercle(p, 15);
		assertEquals(true, c.retournerCentre()!=null, "le centre ne doit pas etre null");
		assertEquals(false, c.retournerCentre()==p, "le centre ne doit pas avoit la meme ref que le parametre");
		assertEquals(10, c.retournerCentre().abscisse, "mauvaise abscisse");
		assertEquals(20, c.retournerCentre().ordonnee, "mauvaise ordonnee");
		assertEquals(15, c.retournerRayon(), "mauvais rayon");
		assertEquals(false, c.getCirconscrit(), "circonscrit est a faux");
		
	}
	
	/**
	 * test le constructeur de cercle avec unPoint null
	 */
	public void test_15_ConstructeurPointNull()
	{
		UnCercle c=new UnCercle(null, 15);
		assertEquals(false, c.retournerCentre()==null, "le centre a la meme ref que le parametre");
		assertEquals(0, c.retournerCentre().abscisse, "mauvaise abscisse");
		assertEquals(0, c.retournerCentre().ordonnee, "mauvaise ordonnee");
		assertEquals(15, c.retournerRayon(), "mauvais rayon");
		assertEquals(false, c.getCirconscrit(), "circonscrit est a faux");
	}
	
	/**
	 * test le constructeur de cercle avec untriangle - cas normal
	 */
	public void test_16_ConstructeurTriangle()
	{
		UnTriangle t = new UnTriangle(new UnPoint(100,0),new UnPoint(0,100),new UnPoint(0,0));
		UnCercle c=new UnCercle(t);
		
		assertEquals(true, c.getCirconscrit(), "circonscrit doit etre a vrai");
		assertEquals(71, t.calculerRayonCercleCirconscrit(),
				"le rayon du cercle devrait etre 71)");
		
		int x=t.calculerCentreCercleCirconscrit().abscisse;
		//verifie independance des references
		t.seTranslater(15,15);
		//on verifie que le cercle est independant du triangle
		assertEquals(x,c.retournerCentre().abscisse,"le cercle ne devrait pas bouger");
		
		
	}
	
	/**
	 * test le constructeur de cercle avec untriangle - cas triangle null
	 */
	public void test_17_ConstructeurTriangleNull()
	{
		UnTriangle t = null;
		UnCercle c=new UnCercle(t);
		assertEquals(true, c.getCirconscrit(), "circonscrit doit etre a vrai");
		assertEquals(true, c.retournerCentre()!=null, "associé ne doit pas etre null");	
	}
	
	/**
	 * test le constructeur de cercle avec Uncercle - cas normal non circonscrit
	 */
	public void test_18_ConstructeurCercleNonCirconscrit()
	{
		UnCercle co=new UnCercle(10, 20, 15);
		UnCercle c=new UnCercle(co);
		assertEquals(true, c.retournerCentre()!=null, "le centre devrait etre non null");
		assertEquals(true, c.retournerCentre()!=co.retournerCentre(), "le centre devrait avoir une autre reference");
		assertEquals(10, c.retournerCentre().abscisse, "mauvaise abscisse");
		assertEquals(20, c.retournerCentre().ordonnee, "mauvaise ordonnee");
		assertEquals(15, c.retournerRayon(), "mauvais rayon");
		assertEquals(false, c.getCirconscrit(), "circonscrit est a faux");
	}
	
	/**
	 * test le constructeur de cercle avec Uncercle - cas normal  circonscrit
	 */
	public void test_19_ConstructeurCercleCirconscrit()
	{
		UnTriangle t = new UnTriangle(new UnPoint(105,0),new UnPoint(0,100),new UnPoint(0,0));
		UnCercle co=new UnCercle(t);
		UnCercle c=new UnCercle(co);
		assertEquals(true, c.getCirconscrit(), "circonscrit doit etre a vrai");

		int x=co.retournerCentre().abscisse;
		//verifie independance des references
		co.seTranslater(15,15);
		//on verifie que le cercle est independant du triangle
		assertEquals(x,c.retournerCentre().abscisse,"le cercle ne devrait pas bouger");
	}
	
	/**
	 * test le constructeur de cercle avec Uncercle - cas Null
	 */
	public void test_20_ConstructeurCercleNull()
	{
		UnCercle c=null;
		UnCercle co=new UnCercle(c);
		assertEquals(false, co.getCirconscrit(), "circonscrit doit etre a false");
		assertEquals(true, co.retournerCentre()!=null, "le centre doit etre non null");
	}
	
	/**
	 * test retournerrayon et retournercentre - cas cercle non circonscrit
	 */
	public void test_21_AccesCercleNonCirconscrit()
	{
		UnCercle co=new UnCercle(10,15,20);
		assertEquals(true, co.retournerCentre()!=null, "le centre doit etre non null");
		assertEquals(10, co.retournerCentre().abscisse, "abscisse du centre doit etre 10");
		assertEquals(15, co.retournerCentre().ordonnee, "ordonnee du centre doit etre 15");
		assertEquals(20, co.retournerRayon(), "le rayon doit etre de 20");		
	}
	
	/**
	 * test retournerrayon et retournercentre - cas cercle  circonscrit
	 */
	public void test_22_AccesCercleCirconscrit()
	{
		UnTriangle t=new UnTriangle(new UnPoint(100,0), new UnPoint(0, 100), new UnPoint());
		UnCercle co=new UnCercle(t);
		assertEquals(true, co.retournerCentre()!=null, "le centre doit etre non null");
		assertEquals(50, co.retournerCentre().abscisse, "abscisse du centre doit etre 50");
		assertEquals(50, co.retournerCentre().ordonnee, "ordonnee du centre doit etre 50");
		assertEquals(71, co.retournerRayon(), "le rayon doit etre de 71");		
	}
	
	


	/**
	 * lancement des tests
	 * 
	 * @param args
	 *            vide
	 */
	public static void main(String[] args) {
		lancer(new TestMethodeUnCerclePrive(),args);
	}

}
