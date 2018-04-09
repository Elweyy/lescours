/**
 * classe de test pour classe Listecontigue
 *
 * @author vthomas
 *
 */
public class TestTri {

	/**
	 * tri d'une liste normale
	 */
	public void test_1_TriNormal() {
		SousTitre[] tab = {
				new SousTitre(264, "Batman: Vite, Ã  la batmobile!!"),
				new SousTitre(255,
						"Robin: Nom d'un petitbonhomme, mais c'est bien sur"),
				new SousTitre(258,
						"Batman: Oui Robin, c'est le joker qui est derriere cet attentat"),
				new SousTitre(152, "Batman: Mais de qui peut-il s'agir ?"),
				new SousTitre(98, "Robin: Batman, j'entends un rire demoniaque") };

		Trier tri = new Trier();
		Liste l = tri.trier(tab);

		// verification du premier element
		int place = l.tete();
		SousTitre t = l.val(place);
		Lanceur.assertEquals(98, t.getTemps(),
				"le premier devrait avoir un temps de 98");

		place = l.suc(place);
		t = l.val(place);
		Lanceur.assertEquals(152, t.getTemps(),
				"le second devrait avoir un temps de 152");

		place = l.suc(place);
		t = l.val(place);
		Lanceur.assertEquals(255, t.getTemps(),
				"le troisieme devrait avoir un temps de 255");

		place = l.suc(place);
		t = l.val(place);
		Lanceur.assertEquals(258, t.getTemps(),
				"le 4 devrait avoir un temps de 258");

		place = l.suc(place);
		t = l.val(place);
		Lanceur.assertEquals(264, t.getTemps(),
				"le 5 devrait avoir un temps de 264");

		place = l.suc(place);
		Lanceur.assertEquals(true, l.finliste(place), "il ne reste rien");

	}

	/**
	 * tri d'une liste avec un element
	 */
	public void test_2_TriUnique() {
		SousTitre[] tab = { new SousTitre(264,
				"Batman: Vite, Ã  la batmobile!!") };

		Trier tri = new Trier();
		Liste l = tri.trier(tab);

		// verification du premier element
		int place = l.tete();
		SousTitre t = l.val(place);
		Lanceur.assertEquals(264, t.getTemps(),
				"le premier devrait avoir un temps de 98");

		place = l.suc(place);
		Lanceur.assertEquals(true, l.finliste(place), "il ne reste rien");

	}

	/**
	 * tri d'une liste vide
	 */
	public void test_3_TriVide() {
		SousTitre[] tab = {};

		Trier tri = new Trier();
		Liste l = tri.trier(tab);

		// verification du premier element
		int place = l.tete();
		Lanceur.assertEquals(true, l.finliste(place), "il ne reste rien");

	}

	/**
	 * tri d'une liste triÃ©
	 */
	public void test_4_TriTrie() {
		SousTitre[] tab = {
				new SousTitre(98, "Batman: Vite, Ã  la batmobile!!"),
				new SousTitre(152,
						"Robin: Nom d'un petitbonhomme, mais c'est bien sur"),
				new SousTitre(255,
						"Batman: Oui Robin, c'est le joker qui est derriere cet attentat"),
				new SousTitre(258, "Batman: Mais de qui peut-il s'agir ?"),
				new SousTitre(264,
						"Robin: Batman, j'entends un rire demoniaque") };

		Trier tri = new Trier();
		Liste l = tri.trier(tab);

		// verification du premier element
		int place = l.tete();
		SousTitre t = l.val(place);
		Lanceur.assertEquals(98, t.getTemps(),
				"le premier devrait avoir un temps de 98");

		place = l.suc(place);
		t = l.val(place);
		Lanceur.assertEquals(152, t.getTemps(),
				"le second devrait avoir un temps de 152");

		place = l.suc(place);
		t = l.val(place);
		Lanceur.assertEquals(255, t.getTemps(),
				"le troisieme devrait avoir un temps de 255");

		place = l.suc(place);
		t = l.val(place);
		Lanceur.assertEquals(258, t.getTemps(),
				"le 4 devrait avoir un temps de 258");

		place = l.suc(place);
		t = l.val(place);
		Lanceur.assertEquals(264, t.getTemps(),
				"le 5 devrait avoir un temps de 264");

		place = l.suc(place);
		Lanceur.assertEquals(true, l.finliste(place), "il ne reste rien");
	}

	/**
	 * lancement des tests
	 */
	public static void main(String args[]) {
		if ((args.length == 1) && (args[0].equals("-text")))
			Lanceur.lanceSansInterface(new TestTri());
		else
			Lanceur.lanceAvecInterface(new TestTri());
	}

}
