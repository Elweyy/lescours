/**
 * classe de test pour classe Listecontigue
 * @author vthomas
 *
 */
public class TestListeProf {
	
	
	/**
	 * constructeur liste contigue
	 */
	public void test_1_Contructeur()
	{
		//creation de la liste
		Liste lc=new ListeProf();
		
		//verification vide
		int tete=lc.tete();
		Lanceur.assertEquals(true, lc.finliste(tete), "liste non vide");
	}
	
	/**
	 * creation liste, ajout en tete listevide et vérification des valeurs 
	 */
	public void test_2_adjtlis_listeVide()
	{
		//creation de la liste
		Liste lc=new ListeProf();
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		
		//verification non vide
		int tete=lc.tete();
		Lanceur.assertEquals(false, lc.finliste(tete), "liste non vide");
		
		//test de ce qu'il y a au debut
		SousTitre t=lc.val(tete);
		Lanceur.assertEquals("Bonjour", t.getPhrase(), "pas le bon element en tete");
		Lanceur.assertEquals(10, t.getTemps(), "pas le bon element en tete");
		
		//verifier qu'il n'y a rien d'autre
		tete=lc.suc(tete);
		Lanceur.assertEquals(true, lc.finliste(tete), "liste a plus d'un element");
	}
	
	/**
	 * creation liste, ajout en tete liste existante et vérification des valeurs 
	 */
	public void test_3_adjtlis_listeNonVide()
	{
		//creation de la liste
		Liste lc=new ListeProf();
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		lc.adjtlis(new SousTitre(20, "Bonjour2"));
		
		//verification non vide
		int tete=lc.tete();
		Lanceur.assertEquals(false, lc.finliste(tete), "liste non vide");
		
		//test de ce qu'il y a au debut
		SousTitre t=lc.val(tete);
		Lanceur.assertEquals("Bonjour2", t.getPhrase(), "pas le bon element en tete");
		Lanceur.assertEquals(20, t.getTemps(), "pas le bon element en tete");
		
		//verifier qu'il n'y a rien d'autre
		tete=lc.suc(tete);
		Lanceur.assertEquals(false, lc.finliste(tete), "liste n'a qu'un element");
		
		//test de ce qu'il y a au debut
		t=lc.val(tete);
		Lanceur.assertEquals("Bonjour", t.getPhrase(), "pas le bon element en second");
	}
	
	/**
	 * test méthode suppression 
	 * suppression en tete liste existante
	 */
	public void test_4_suplis_suppressionTete()
	{
		//creation de la liste
		Liste lc=new ListeProf();
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		lc.adjtlis(new SousTitre(20, "Bonjour2"));
		lc.adjtlis(new SousTitre(30, "Bonjour3"));
		
		//suppression en tete
		lc.suplis(lc.tete());
		
		//verification non vide
		int tete=lc.tete();
		Lanceur.assertEquals(false, lc.finliste(tete), "liste ne devrait pas etre vide");
		
		//test de ce qu'il y a au debut
		SousTitre t=lc.val(tete);
		Lanceur.assertEquals("Bonjour2", t.getPhrase(), "pas le bon element en tete");
		Lanceur.assertEquals(20, t.getTemps(), "pas le bon element en tete");
		
		//verifier qu'il n'y a rien d'autre
		tete=lc.suc(tete);
		Lanceur.assertEquals(false, lc.finliste(tete), "liste ne devrait pas avoir qu'un element");
		
		//test de ce qu'il y a au debut
		t=lc.val(tete);
		Lanceur.assertEquals("Bonjour", t.getPhrase(), "pas le bon element en second");
	}
	
	
	
	/**
	 * test méthode suppression 
	 * suppression en tete liste avec un element
	 */
	public void test_5_suplis_SuppressionTeteListe1Element()
	{
		//creation de la liste
		Liste lc=new ListeProf();
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		
		//suppression en tete
		lc.suplis(lc.tete());
		
		//verification vide
		int tete=lc.tete();
		Lanceur.assertEquals(true, lc.finliste(tete), "liste devrait etre vide");
	}
	
	/**
	 * test méthode suppression 
	 * suppressions en tete successives
	 */
	public void test_6_suplis_SuppressionTetePlusieursFois()
	{
		//creation de la liste
		Liste lc=new ListeProf();
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		lc.adjtlis(new SousTitre(20, "Bonjour2"));
		lc.adjtlis(new SousTitre(30, "Bonjour3"));
		
		
		//suppression en tete
		lc.suplis(lc.tete());
		lc.suplis(lc.tete());
		
		//il ne reste que Bonjour en tete
		
		
		//verification non vide
		int tete=lc.tete();
		Lanceur.assertEquals(false, lc.finliste(tete), "liste ne devrait pas etre vide");
		//test bonjour en tete
		SousTitre t=lc.val(tete);
		Lanceur.assertEquals("Bonjour", t.getPhrase(), "pas le bon element en tete");
		Lanceur.assertEquals(10, t.getTemps(), "pas le bon element en tete");
		
	}
	
	/**
	 * test méthode suppression 
	 * suppressions en queue
	 */
	public void test_7_suplis_SuppressionQueue()
	{
		//creation de la liste
		Liste lc=new ListeProf();
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		lc.adjtlis(new SousTitre(20, "Bonjour2"));
		lc.adjtlis(new SousTitre(30, "Bonjour3"));
		
		
		//suppression en tete
		int place=lc.tete();
		place=lc.suc(place);
		place=lc.suc(place);
		//supprime la queue
		lc.suplis(place);
		
		
		//la liste devrait etre [Bonjour3, bonjour2]
		//verification non vide
		int place2=lc.tete();
		Lanceur.assertEquals(false, lc.finliste(place2), "liste ne devrait pas etre vide");
		//test bonjour3 en tete
		SousTitre t=lc.val(place2);
		Lanceur.assertEquals("Bonjour3", t.getPhrase(), "pas le bon element en tete");
		Lanceur.assertEquals(30, t.getTemps(), "pas le bon element en tete");
		//test bonjour2 en second
		place2=lc.suc(place2);
		t=lc.val(place2);
		Lanceur.assertEquals("Bonjour2", t.getPhrase(), "pas le bon element en second");
		Lanceur.assertEquals(20, t.getTemps(), "pas le bon element en second");
		//test il ne reste rien
		place2=lc.suc(place2);
		Lanceur.assertEquals(true,lc.finliste(place2),"il ne devrait plus rester d'elements");		
	}
	
	

	/**
	 * test méthode suppression 
	 * suppressions au milieu
	 */
	public void test_8_suplis_SuppressionMilieu()
	{
		//creation de la liste
		Liste lc=new ListeProf();
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		lc.adjtlis(new SousTitre(20, "Bonjour2"));
		lc.adjtlis(new SousTitre(30, "Bonjour3"));
		
		
		//suppression en tete
		int place=lc.tete();
		place=lc.suc(place);
		//supprime le milieu
		lc.suplis(place);
		
		
		//la liste devrait etre [Bonjour3, bonjour]
		//verification non vide
		int place2=lc.tete();
		Lanceur.assertEquals(false, lc.finliste(place2), "liste ne devrait pas etre vide");
		//test bonjour3 en tete
		SousTitre t=lc.val(place2);
		Lanceur.assertEquals("Bonjour3", t.getPhrase(), "pas le bon element en tete");
		Lanceur.assertEquals(30, t.getTemps(), "pas le bon element en tete");
		//test bonjour2 en second
		place2=lc.suc(place2);
		t=lc.val(place2);
		Lanceur.assertEquals("Bonjour", t.getPhrase(), "pas le bon element en second");
		Lanceur.assertEquals(10, t.getTemps(), "pas le bon element en second");
		//test il ne reste rien
		place2=lc.suc(place2);
		Lanceur.assertEquals(true,lc.finliste(place2),"il ne devrait plus rester d'elements");		
	}
	
	/**
	 * test méthode adjlis 
	 * ajout derrière la tete
	 */
	public void test_9_adjlis_AjoutTete()
	{
		//creation de la liste
		Liste lc=new ListeProf();
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		lc.adjtlis(new SousTitre(20, "Bonjour2"));
		
		//ajout derriere la tete
		lc.adjlis(lc.tete(),new SousTitre(30, "Bonjour3"));
				
		
		//la liste devrait etre [Bonjour2, bonjour3, bonjour]
		//verification non vide
		int place2=lc.tete();
		Lanceur.assertEquals(false, lc.finliste(place2), "liste ne devrait pas etre vide");
		//test bonjour2 en tete
		SousTitre t=lc.val(place2);
		Lanceur.assertEquals("Bonjour2", t.getPhrase(), "pas le bon element en tete");
		Lanceur.assertEquals(20, t.getTemps(), "pas le bon element en tete");
		//test bonjour3 en second
		place2=lc.suc(place2);
		t=lc.val(place2);
		Lanceur.assertEquals("Bonjour3", t.getPhrase(), "pas le bon element en second");
		Lanceur.assertEquals(30, t.getTemps(), "pas le bon element en second");
		//test bonjour en dernier
		place2=lc.suc(place2);
		t=lc.val(place2);
		Lanceur.assertEquals("Bonjour", t.getPhrase(), "pas le bon element en dernier");
		Lanceur.assertEquals(10, t.getTemps(), "pas le bon element en dernier");		
		//test il ne reste rien
		place2=lc.suc(place2);
		Lanceur.assertEquals(true,lc.finliste(place2),"il ne devrait plus rester d'elements");		
	}
	
	/**
	 * test méthode adjlis 
	 * ajout en Queue
	 */
	public void test_10_adjlis_AjoutQueue()
	{
		//creation de la liste
		Liste lc=new ListeProf();
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		lc.adjtlis(new SousTitre(20, "Bonjour2"));
		lc.adjtlis(new SousTitre(30, "Bonjour3"));
		
		//ajout derriere le dernier
		int place=lc.tete();
		place=lc.suc(place);
		place=lc.suc(place);
		lc.adjlis(place,new SousTitre(40, "Bonjour4"));
				
		
		//la liste devrait etre [Bonjour3, bonjour2, bonjour,bonjour4]
		//verification non vide
		int place2=lc.tete();
		Lanceur.assertEquals(false, lc.finliste(place2), "liste ne devrait pas etre vide");
		//test bonjour3 en tete
		SousTitre t=lc.val(place2);
		Lanceur.assertEquals("Bonjour3", t.getPhrase(), "pas le bon element en tete");
		Lanceur.assertEquals(30, t.getTemps(), "pas le bon element en tete");
		//test bonjour2 en second
		place2=lc.suc(place2);
		t=lc.val(place2);
		Lanceur.assertEquals("Bonjour2", t.getPhrase(), "pas le bon element en second");
		Lanceur.assertEquals(20, t.getTemps(), "pas le bon element en second");
		//test bonjour en trois
		place2=lc.suc(place2);
		t=lc.val(place2);
		Lanceur.assertEquals("Bonjour", t.getPhrase(), "pas le bon element en trois");
		Lanceur.assertEquals(10, t.getTemps(), "pas le bon element en trois");
		//test bonjour en dernier
		place2=lc.suc(place2);
		t=lc.val(place2);
		Lanceur.assertEquals("Bonjour4", t.getPhrase(), "pas le bon element en dernier");
		Lanceur.assertEquals(40, t.getTemps(), "pas le bon element en dernier");		
		//test il ne reste rien
		place2=lc.suc(place2);
		Lanceur.assertEquals(true,lc.finliste(place2),"il ne devrait plus rester d'elements");		
	}
	
	/**
	 * test méthode adjlis 
	 * ajout au milieu
	 */
	public void test_11_adjlis_AjoutMilieu()
	{
		//creation de la liste
		Liste lc=new ListeProf();
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		lc.adjtlis(new SousTitre(20, "Bonjour2"));
		lc.adjtlis(new SousTitre(30, "Bonjour3"));
		
		//ajout derriere le dernier
		int place=lc.tete();
		place=lc.suc(place);
		lc.adjlis(place,new SousTitre(40, "Bonjour4"));
				
		
		//la liste devrait etre [Bonjour3, bonjour2, bonjour4, bonjour]
		//verification non vide
		int place2=lc.tete();
		Lanceur.assertEquals(false, lc.finliste(place2), "liste ne devrait pas etre vide");
		//test bonjour3 en tete
		SousTitre t=lc.val(place2);
		Lanceur.assertEquals("Bonjour3", t.getPhrase(), "pas le bon element en tete");
		Lanceur.assertEquals(30, t.getTemps(), "pas le bon element en tete");
		//test bonjour2 en second
		place2=lc.suc(place2);
		t=lc.val(place2);
		Lanceur.assertEquals("Bonjour2", t.getPhrase(), "pas le bon element en second");
		Lanceur.assertEquals(20, t.getTemps(), "pas le bon element en second");
		//test bonjour4 en trois
		place2=lc.suc(place2);
		t=lc.val(place2);
		Lanceur.assertEquals("Bonjour4", t.getPhrase(), "pas le bon element en trois");
		Lanceur.assertEquals(40, t.getTemps(), "pas le bon element en trois");
		//test bonjour en dernier
		place2=lc.suc(place2);
		t=lc.val(place2);
		Lanceur.assertEquals("Bonjour", t.getPhrase(), "pas le bon element en dernier");
		Lanceur.assertEquals(10, t.getTemps(), "pas le bon element en dernier");		
		//test il ne reste rien
		place2=lc.suc(place2);
		Lanceur.assertEquals(true,lc.finliste(place2),"il ne devrait plus rester d'elements");		
	}
	
	
	/**
	 * lancement des tests
	 */
	public static void main(String args[])
	{
		if ((args.length==1)&&(args[0].equals("-text")))
			Lanceur.lanceSansInterface(new TestListeProf());
		else
			Lanceur.lanceAvecInterface(new TestListeProf());
	}

}
