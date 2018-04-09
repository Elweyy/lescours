/**
 * classe de test pour classe ListeChainee
 * @author vthomas
 *
 */
public class TestListeChainee {

	/**
	 * constructeur liste contigue
	 */
	public void test_1_Contructeur()
	{
		//creation de la liste
		Liste lc = new ListeChainee(100);
		
		//verification vide
		int tete=lc.tete();
		Lanceur.assertEquals(true, lc.finliste(tete), "la liste devrait etre vide");
	}
	
	/**
	 * creation liste, ajout en tete listevide et vérification des valeurs 
	 */
	public void test_2_adjtlis_listeVide()
	{
		//creation de la liste
		Liste lc=new ListeChainee(100);
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		
		//verification non vide
		int tete=lc.tete();
		Lanceur.assertEquals(false, lc.finliste(tete), "liste devrait etre non vide");
		
		//test de ce qu'il y a au debut
		SousTitre t=lc.val(tete);
		Lanceur.assertEquals("Bonjour", t.getPhrase(), "l'element en tete devrait etre bonjour");
		Lanceur.assertEquals(10, t.getTemps(), "le temps en tete devrait etre 10");
		
		//verifier qu'il n'y a rien d'autre
		tete=lc.suc(tete);
		Lanceur.assertEquals(true, lc.finliste(tete), "la liste ne devrait avoir qu'un element");
	}
	
	/**
	 * creation liste, ajout en tete liste existante et vérification des valeurs 
	 */
	public void test_3_adjtlis_listeNonVide()
	{
		//creation de la liste
		Liste lc=new ListeChainee(100);
		lc.adjtlis(new SousTitre(10, "Bonjour"));
		lc.adjtlis(new SousTitre(20, "Bonjour2"));
		
		//verification non vide
		int tete=lc.tete();
		Lanceur.assertEquals(false, lc.finliste(tete), "liste ne devrait pas etre vide");
		
		//test de ce qu'il y a au debut
		SousTitre t=lc.val(tete);
		Lanceur.assertEquals("Bonjour2", t.getPhrase(), "la liste devrait avoir Bonjour2 en tete");
		Lanceur.assertEquals(20, t.getTemps(), "la liste devrait avoir 20 en tete");
		
		//verifier qu'il n'y a rien d'autre
		tete=lc.suc(tete);
		Lanceur.assertEquals(false, lc.finliste(tete), "la liste devrait avoir 2 elements");
		
		//test de ce qu'il y a au debut
		t=lc.val(tete);
		Lanceur.assertEquals("Bonjour", t.getPhrase(), "le second element devrait etre Bonjour");
	}
	
	/**
	 * test méthode suppression 
	 * suppression en tete liste existante
	 */
	public void test_4_suplis_suppressionTete()
	{
		//creation de la liste
		Liste lc=new ListeChainee(100);
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
		Lanceur.assertEquals("Bonjour2", t.getPhrase(), "la tete devrait etre Bonjour2");
		Lanceur.assertEquals(20, t.getTemps(), "la tete devrait avoir un temps de 20");
		
		//verifier qu'il n'y a rien d'autre
		tete=lc.suc(tete);
		Lanceur.assertEquals(false, lc.finliste(tete), "la liste devrait avoir plus d'un element");
		
		//test de ce qu'il y a au debut
		t=lc.val(tete);
		Lanceur.assertEquals("Bonjour", t.getPhrase(), "le second element devrait etre Bonjour");
	}
	
	
	
	/**
	 * test méthode suppression 
	 * suppression en tete liste avec un element
	 */
	public void test_5_suplis_SuppressionTeteListe1Element()
	{
		//creation de la liste
		Liste lc=new ListeChainee(100);
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
		Liste lc=new ListeChainee(100);
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
		Lanceur.assertEquals("Bonjour", t.getPhrase(), "l'element en tete devrait etre bonjour");
		Lanceur.assertEquals(10, t.getTemps(), "le temps en tete devrait etre 10");
		
	}
	
	/**
	 * test méthode suppression 
	 * suppressions en queue
	 */
	public void test_7_suplis_SuppressionQueue()
	{
		//creation de la liste
		Liste lc=new ListeChainee(100);
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
		Lanceur.assertEquals("Bonjour3", t.getPhrase(), "l'element en tete devrait etre bonjour3");
		Lanceur.assertEquals(30, t.getTemps(), "le temps en tete devrait etre 30");
		//test bonjour2 en second
		place2=lc.suc(place2);
		t=lc.val(place2);
		Lanceur.assertEquals("Bonjour2", t.getPhrase(), "l'element second devrait etre bonjour2");
		Lanceur.assertEquals(20, t.getTemps(), "le second temps devrait etre 20");
		//test il ne reste rien
		place2=lc.suc(place2);
		Lanceur.assertEquals(true,lc.finliste(place2),"il ne devrait avoir que deux elements");		
	}
	
	

	/**
	 * test méthode suppression 
	 * suppressions au milieu
	 */
	public void test_8_suplis_SuppressionMilieu()
	{
		//creation de la liste
		Liste lc=new ListeChainee(100);
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
		Lanceur.assertEquals("Bonjour3", t.getPhrase(), "element en tete devrait etre bonjour3");
		Lanceur.assertEquals(30, t.getTemps(), "temps en tete devrait etre 30");
		//test bonjour2 en second
		place2=lc.suc(place2);
		t=lc.val(place2);
		Lanceur.assertEquals("Bonjour", t.getPhrase(), "second element devrait etre bonjour");
		Lanceur.assertEquals(10, t.getTemps(), "second temps devrait etre 10");
		//test il ne reste rien
		place2=lc.suc(place2);
		Lanceur.assertEquals(true,lc.finliste(place2),"il ne devrait y avoir que deux elements");		
	}
	
	/**
	 * test méthode adjlis 
	 * ajout derrière la tete
	 */
	public void test_9_adjlis_AjoutTete()
	{
		//creation de la liste
		Liste lc=new ListeChainee(100);
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
		Lanceur.assertEquals("Bonjour2", t.getPhrase(), "element en tete devrait etre bonjour2");
		Lanceur.assertEquals(20, t.getTemps(), "temps en tete devrait etre 20");
		//test bonjour3 en second
		place2=lc.suc(place2);
		t=lc.val(place2);
		Lanceur.assertEquals("Bonjour3", t.getPhrase(), "le second element devrait etre Bonjour3");
		Lanceur.assertEquals(30, t.getTemps(), "le second temps devrait etre 30");
		//test bonjour en dernier
		place2=lc.suc(place2);
		t=lc.val(place2);
		Lanceur.assertEquals("Bonjour", t.getPhrase(), "le troisieme element devrait etre Bonjour");
		Lanceur.assertEquals(10, t.getTemps(), "le 3e temps devrait etre 10");		
		//test il ne reste rien
		place2=lc.suc(place2);
		Lanceur.assertEquals(true,lc.finliste(place2),"il ne devrait y avoir que 3 elements");		
	}
	
	/**
	 * test méthode adjlis 
	 * ajout en Queue
	 */
	public void test_10_adjlis_AjoutQueue()
	{
		//creation de la liste
		Liste lc=new ListeChainee(100);
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
		Lanceur.assertEquals("Bonjour3", t.getPhrase(), "element en tete devrait etre bonjour3");
		Lanceur.assertEquals(30, t.getTemps(), "temps en tete devrait etre 30");
		//test bonjour2 en second
		place2=lc.suc(place2);
		t=lc.val(place2);
		Lanceur.assertEquals("Bonjour2", t.getPhrase(), "element second devrait etre Bonjour2");
		Lanceur.assertEquals(20, t.getTemps(), "temps second devrait etre 20");
		//test bonjour en trois
		place2=lc.suc(place2);
		t=lc.val(place2);
		Lanceur.assertEquals("Bonjour", t.getPhrase(), "3e element devrait etre Bonjour");
		Lanceur.assertEquals(10, t.getTemps(), "3e temps devrait etre 10");
		//test bonjour en dernier
		place2=lc.suc(place2);
		t=lc.val(place2);
		Lanceur.assertEquals("Bonjour4", t.getPhrase(), "4e element devrait etre bonjour4");
		Lanceur.assertEquals(40, t.getTemps(), "4e temps devrait etre 40");		
		//test il ne reste rien
		place2=lc.suc(place2);
		Lanceur.assertEquals(true,lc.finliste(place2),"il ne devrait y avoir que 4 elements");		
	}
	
	/**
	 * test méthode adjlis 
	 * ajout au milieu
	 */
	public void test_11_adjlis_AjoutMilieu()
	{
		//creation de la liste
		Liste lc=new ListeChainee(100);
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
		Lanceur.assertEquals("Bonjour3", t.getPhrase(), "element en tete devrait etre Bonjour3");
		Lanceur.assertEquals(30, t.getTemps(), "temps en tete devrait etre 30");
		//test bonjour2 en second
		place2=lc.suc(place2);
		t=lc.val(place2);
		Lanceur.assertEquals("Bonjour2", t.getPhrase(), "element en second devrait etre Bonjour2");
		Lanceur.assertEquals(20, t.getTemps(), "element en second devrait etre 20");
		//test bonjour4 en trois
		place2=lc.suc(place2);
		t=lc.val(place2);
		Lanceur.assertEquals("Bonjour4", t.getPhrase(), "3e element devrait etre Bonjour4");
		Lanceur.assertEquals(40, t.getTemps(), "3e temps devrait etre 40");
		//test bonjour en dernier
		place2=lc.suc(place2);
		t=lc.val(place2);
		Lanceur.assertEquals("Bonjour", t.getPhrase(), "4e element devrait etre bonjour");
		Lanceur.assertEquals(10, t.getTemps(), "4e temps devrait etre 10");		
		//test il ne reste rien
		place2=lc.suc(place2);
		Lanceur.assertEquals(true,lc.finliste(place2),"il ne devrait y avoir que 4 elements");		
	}

	
	
	
	/**
	 * lancement des tests
	 */
	public static void main(String args[])
	{
		if ((args.length==1)&&(args[0].equals("-text")))
			Lanceur.lanceSansInterface(new TestListeChainee());
		else
			Lanceur.lanceAvecInterface(new TestListeChainee());
	}

}
