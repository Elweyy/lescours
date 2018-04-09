import static libtest.Lanceur.*;
import static libtest.OutilTest.*;


/**
 * classe de test pour nombre de connexions
 */
public class TestLogs {


	/**
	 * permet de tester le constructeur sur un cas normal
	 * nombre mois=5
	 */
	public void test_1_constructeurNormal()
	{
		Logs nb=new Logs(5);
		assertEquals("mauvaise taille du tableau", 5, nb.getNbrConnexions().length);
		for (int i=0;i<5;i++)
		{
			assertEquals("mauvaise valeur a l'indice "+i, 0, nb.getNbrConnexions()[i]);
		}
		assertEquals("mauvais min", 0, nb.getMin());
		assertEquals("mauvais max", 0, nb.getMax());
		assertEquals("mauvais moyenne", 0.0, nb.getMoyenne());
	}

	/**
	 * permet de tester le constructeur sur une taille <1
	 */
	public void test_2_constructeurZero()
	{
		Logs nb=new Logs(0);
		assertEquals("mauvaise taille du tableau", 1, nb.getNbrConnexions().length);
		for (int i=0;i<1;i++)
		{
			assertEquals("mauvaise valeur a l'indice "+i, 0, nb.getNbrConnexions()[i]);
		}
		assertEquals("mauvais min", 0, nb.getMin());
		assertEquals("mauvais max", 0, nb.getMax());
		assertEquals("mauvais moyenne", 0.0, nb.getMoyenne());
	}

	/**
	 * permet de tester le fait de corriger des connexions
	 * pas de depassement
	 */
	public void test_3_corrigerConnexion()
	{
		Logs nb=new Logs(5);
		int[] tab=nb.getNbrConnexions();
		//a ne pas faire
		tab[0]=15;
		tab[1]=20;
		tab[2]=52;
		tab[3]=12;
		tab[4]=34;
		int[] nvValeurs={1,2};
		nb.corrigerConnexions(2, nvValeurs);
		assertEquals("modification ne devrait pas avoir ete faite sur tab[1]", 20, tab[1]);
		assertEquals("modification devrait avoir ete faite sur tab[2]", 1, tab[2]);
		assertEquals("modification devrait avoir ete faite sur tab[3]", 2, tab[3]);
		assertEquals("modification ne devrait pas avoir ete faite sur tab[4]", 34, tab[4]);
		assertEquals("max pas mis a jour", 34, nb.getMax());
		assertEquals("min pas mis a jour", 1, nb.getMin());

	}

	/**
	 * permet de tester le fait de corriger des connexions
	 * pas de depassement, mais on arrive a la fin
	 */
	public void test_4_corrigerConnexionFin()
	{
		Logs nb=new Logs(5);
		int[] tab=nb.getNbrConnexions();
		//a ne pas faire
		tab[0]=15;
		tab[1]=20;
		tab[2]=52;
		tab[3]=12;
		tab[4]=34;
		int[] nvValeurs={1,2};
		nb.corrigerConnexions(3, nvValeurs);
		assertEquals("modification ne devrait pas avoir ete faite sur tab[1]", 20, tab[1]);
		assertEquals("modification ne  devrait pas avoir ete faite sur tab[2]", 52, tab[2]);
		assertEquals("modification devrait avoir ete faite sur tab[3]", 1, tab[3]);
		assertEquals("modification devrait avoir ete faite sur tab[4]", 2, tab[4]);
		assertEquals("max pas mis a jour", 52, nb.getMax());
		assertEquals("min pas mis a jour", 1, nb.getMin());
	}

	/**
	 * permet de tester le fait de corriger des connexions
	 * depassement
	 */
	public void test_5_corrigerConnexionDepasse()
	{
		Logs nb=new Logs(5);
		int[] tab=nb.getNbrConnexions();
		//a ne pas faire
		tab[0]=15;
		tab[1]=20;
		tab[2]=52;
		tab[3]=12;
		tab[4]=34;
		int[] nvValeurs={1,2};
		nb.corrigerConnexions(4, nvValeurs);
		assertEquals("modification ne devrait pas avoir ete faite sur tab[1]", 20, tab[1]);
		assertEquals("modification ne devrait pas avoir ete faite sur tab[2]", 52, tab[2]);
		assertEquals("modification ne devrait pas avoir ete faite sur tab[3]", 12, tab[3]);
		assertEquals("modification devrait avoir ete faite sur tab[4]", 1, tab[4]);
		assertEquals("max pas mis a jour", 52, nb.getMax());
		assertEquals("min pas mis a jour", 1, nb.getMin());
	}

	/**
	 * permet de tester le fait de corriger des connexions
	 * sort du tableau
	 */
	public void test_6_corrigerConnexionHorsTableau()
	{
		Logs nb=new Logs(5);
		int[] tab=nb.getNbrConnexions();
		//a ne pas faire
		tab[0]=15;
		tab[1]=20;
		tab[2]=52;
		tab[3]=12;
		tab[4]=34;
		int[] nvValeurs={1,2};
		nb.corrigerConnexions(7, nvValeurs);
		assertEquals("modification ne devrait pas avoir ete faite sur tab[1]", 20, tab[1]);
		assertEquals("modification ne devrait pas avoir ete faite sur tab[2]", 52, tab[2]);
		assertEquals("modification ne devrait pas avoir ete faite sur tab[3]", 12, tab[3]);
		assertEquals("modification ne devrait pas avoir ete faite sur tab[4]", 34, tab[4]);
		assertEquals("max pas mis a jour", 52, nb.getMax());
		assertEquals("min pas mis a jour", 12, nb.getMin());
	}

	/**
	 * permet de tester l'inversion de connexion
	 * tableau de taille impair
	 */
	public void test_7_inverserConnectionsImpair()
	{
		Logs nb=new Logs(5);
		int[] tab=nb.getNbrConnexions();
		//a ne pas faire
		tab[0]=15;
		tab[1]=20;
		tab[2]=52;
		tab[3]=12;
		tab[4]=34;
		nb.inverserConnexions();
		assertEquals("probleme inversion", 34, tab[0]);
		assertEquals("probleme inversion", 12, tab[1]);
		assertEquals("probleme inversion", 52, tab[2]);
		assertEquals("probleme inversion", 20, tab[3]);
		assertEquals("probleme inversion", 15, tab[4]);
	}

	/**
	 * permet de tester l'inversion de connexion
	 * tableau taille paire
	 */
	public void test_8_inverserConnectionsImpair()
	{
		Logs nb=new Logs(4);
		int[] tab=nb.getNbrConnexions();
		//a ne pas faire
		tab[0]=15;
		tab[1]=20;
		tab[2]=52;
		tab[3]=12;
		nb.inverserConnexions();
		assertEquals("probleme inversion", 12, tab[0]);
		assertEquals("probleme inversion", 52, tab[1]);
		assertEquals("probleme inversion", 20, tab[2]);
		assertEquals("probleme inversion", 15, tab[3]);
	}

	/**
	 * permet de tester la correction de valeur
	 *
	 */
	public void test_9_entreNouvelleValeur()
	{
		Logs nb=new Logs(4);
		int[] tab={15,20,52,18};
		nb.corrigerConnexions(0, tab);
		nb.entrerNouveauReleve(3);
		assertEquals("probleme ajout nouvelle valeur", 3, nb.getNbrConnexions()[0]);
		assertEquals("probleme decalage", 15, nb.getNbrConnexions()[1]);
		assertEquals("probleme decalage", 20, nb.getNbrConnexions()[2]);
		assertEquals("probleme decalage", 52, nb.getNbrConnexions()[3]);
		assertEquals("Min pas mis a jour", 3, nb.getMin());
		assertEquals("Max pas mis a jour", 52, nb.getMax());

	}

	/**
	 * permet de tester la correction de valeur
	 * Min disparait
	 */
	public void test_10_entreNouvelleValeurMin()
	{
		Logs nb=new Logs(4);
		int[] tab={15,20,52,12};
		nb.corrigerConnexions(0, tab);
		nb.entrerNouveauReleve(3);
		assertEquals("probleme ajout nouvelle valeur", 3, nb.getNbrConnexions()[0]);
		assertEquals("probleme decalage", 15, nb.getNbrConnexions()[1]);
		assertEquals("probleme decalage", 20, nb.getNbrConnexions()[2]);
		assertEquals("probleme decalage", 52, nb.getNbrConnexions()[3]);
		assertEquals("Min pas mis a jour", 3, nb.getMin());
		assertEquals("Max pas mis a jour", 52, nb.getMax());

	}


	/**
	 * permet de tester la correction de valeur
	 * Une seule valeur
	 */
	public void test_11_entreNouvelleValeurUne()
	{
		Logs nb=new Logs(1);
		int[] tab={15};
		nb.corrigerConnexions(0, tab);
		nb.entrerNouveauReleve(3);
		assertEquals("probleme ajout nouvelle valeur", 3, nb.getNbrConnexions()[0]);
		assertEquals("Min pas mis a jour", 3, nb.getMin());
		assertEquals("Max pas mis a jour", 3, nb.getMax());

	}

	/**
	 * permet de tester le constructeur 2D
	 */
	public void test_12_constructeur2D()
	{
		int[][] tab={{15,25,35,45,55,65,75,85,95,105,115,125},
					 {18,28,38,48,58,68,78,88,98,108,118,128}};
		Logs nb=new Logs(tab);
		assertEquals("probleme ordre construction", 125, nb.getNbrConnexions()[0]);
		assertEquals("probleme ordre construction", 18, nb.getNbrConnexions()[23]);
		assertEquals("Min pas mis a jour", 15, nb.getMin());
		assertEquals("Max pas mis a jour", 128, nb.getMax());

	}

	/**
	 * permet de tester le tri decroissant
	 */
	public void test_13_triDecroissant()
	{
		int[][] tab={{15,25,35,45,55,65,2,85,95,105,115,125},
					 {18,28,156,48,58,68,78,88,98,108,118,128}};
		Logs nb=new Logs(tab);
		nb.trierDecroissantConnexions();
		assertEquals("mauvais tri", 156, nb.getNbrConnexions()[0]);
		assertEquals("mauvais tri", 128, nb.getNbrConnexions()[1]);
		assertEquals("mauvais tri", 15, nb.getNbrConnexions()[22]);
		assertEquals("mauvais tri", 2, nb.getNbrConnexions()[23]);
	}

	/**
	 * permet de tester le tri decroissant
	 */
	public void test_14_triDecroissantBulle()
	{
		int[][] tab={{15,25,35,45,55,65,2,85,95,105,115,125},
					 {18,28,156,48,58,68,78,88,98,108,118,128}};
		Logs nb=new Logs(tab);
		nb.trierDecroissantBulle();
		assertEquals("mauvais tri", 156, nb.getNbrConnexions()[0]);
		assertEquals("mauvais tri", 128, nb.getNbrConnexions()[1]);
		assertEquals("mauvais tri", 15, nb.getNbrConnexions()[22]);
		assertEquals("mauvais tri", 2, nb.getNbrConnexions()[23]);


	}





	/**
	 * lancement des tests
	 * @param args inutile
	 */
	public static void main(String[]args)
	{
		lancer(new TestLogs(),args);
	}

}
