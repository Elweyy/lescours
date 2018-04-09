/**
 * classe pour tester la classe PileReference
 * @author vthomas
 *
 */
public class TestPileReference {

	
	/**
	 * verifie la construction d'une pile vide
	 */
	public void test_1_constructeur()
	{
		Pile p=new PileReference();
		Lanceur.assertEquals(true, p.estVidePile(), "le pile devrait etre vide");
	}
	
	/**
	 * verifie l'ajout et le sommet
	 */
	public void test_2_empilerEtSommet1Fois()
	{
		//ajoute 1 dans la pile
		Pile p=new PileReference();
		p.empiler(1);
		
		//test
		Lanceur.assertEquals(false, p.estVidePile(), "la pile ne devrait pas etre vide (1)");
		Lanceur.assertEquals(1, p.sommet(), "le premier element devrait etre '1', celui inséré");
		p.depiler();
		Lanceur.assertEquals(true, p.estVidePile(), "la pile ne devait contenir qu'un element");
	}
	
	/**
	 * verifie l'ajout, depiler et le sommet
	 */
	public void test_3_empilerDepilerEtSommet10Fois()
	{
		//ajoute 1 dans la pile
		Pile p=new PileReference();
		for (int i=0;i<10;i++)
			p.empiler(i*2);
		
		//test
		Lanceur.assertEquals(false, p.estVidePile(), "la pile ne devrait pas etre vide");
		Lanceur.assertEquals(18, p.sommet(), "le premier element devrait etre 18, le dernier inséré");
		p.depiler();
		Lanceur.assertEquals(false, p.estVidePile(), "la pile ne devrait pas contenir qu'un element");
		Lanceur.assertEquals(16, p.sommet(), "le second element devrait etre 16, l'avant dernier inséré");
		//on depiler 8 fois 
		for (int i=0;i<8;i++)
		{
			p.depiler();
		}
		//il ne devrait rester que 0
		Lanceur.assertEquals(false, p.estVidePile(), "la pile ne devrait plus contenir qu'un element");
		Lanceur.assertEquals(0, p.sommet(), "le dernier element devrait etre le premier inséré");
		p.depiler();
		Lanceur.assertEquals(true, p.estVidePile(), "la pile devrait etre desormais vide");	
	}
	
	
	/**
	 * verifie empiler intermediaire
	 */
	public void test_4_empilerApresDepiler()
	{
		Pile p=new PileReference();
		p.empiler(1);
		p.empiler(2);
		p.empiler(3);
		
		//test dernier empilement
		Lanceur.assertEquals(false, p.estVidePile(), "la pile ne devrait pas etre vide (3,2,1)");
		Lanceur.assertEquals(3, p.sommet(), "le premier element devrait etre 3");
		p.depiler();
		Lanceur.assertEquals(false, p.estVidePile(), "la pile ne devrait pas etre vide (2,1)");
		Lanceur.assertEquals(2, p.sommet(), "le premier element devrait etre 2");
		//on rempile 4
		p.empiler(4);
		Lanceur.assertEquals(false, p.estVidePile(), "la pile ne devrait pas etre vide aprés avoir empilé (4,2,1)");
		Lanceur.assertEquals(4, p.sommet(), "le premier element devrait etre 4");
		//on depile et on doit bien retomber sur 2
		p.depiler();
		Lanceur.assertEquals(false, p.estVidePile(), "la pile ne devrait pas etre vide aprés avoir redepilé (2,1)");
		Lanceur.assertEquals(2, p.sommet(), "le premier element devrait etre 2");		
	}

	
	/**
	 * verifie empiler apres avoir vidé la pile
	 */
	public void test_5_empilerApresPilevide()
	{
		Pile p=new PileReference();
		p.empiler(1);
		p.empiler(2);
		p.empiler(3);
		p.depiler();
		p.depiler();
		p.depiler();
		Lanceur.assertEquals(true, p.estVidePile(), "la pile devrait etre vide");
		
		//on réempile
		p.empiler(5);
		
		//test reempilage
		Lanceur.assertEquals(false, p.estVidePile(), "la pile ne devrait plus etre vide (5)");
		Lanceur.assertEquals(5, p.sommet(), "le sommet devrait etre 5");
		p.depiler();
		Lanceur.assertEquals(true, p.estVidePile(), "la pile devrait etre vide");	
	}
	

	/**
	 * verifie depiler jusque pilevide
	 */
	public void test_6_DepilerJusquePilevide()
	{
		Pile p=new PileReference();
		for (int i=0;i<100;i++)
		{
			p.empiler(i*3);
		}
		//on depile tant qu'elle n'est pas vide
		int sommet=0;
		for (int i=0;i<100;i++)
		{
			sommet=p.sommet();
			p.depiler();
		}
		Lanceur.assertEquals(true, p.estVidePile(), "la pile devrait etre vide (condition de sortie)");
		Lanceur.assertEquals(0, sommet, "la derniere valeur devrait etre 0");
		
	}
	
	/**
	 * permet de lancer les tests
	 * @param args inutilisé
	 */
	public static void main(String[]args)
	{
		if ((args.length==1)&&(args[0].equals("-text")))
			Lanceur.lanceSansInterface(new TestPileReference());
		else
			Lanceur.lanceAvecInterface(new TestPileReference());
	}
	
}
