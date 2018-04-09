/*..............................................................................
................................................................................
................................................................................
................................................................................
................................................................................
........................:DMNMMMMMMMMMMMMNNMMMMMMMMMMNNNMMMMMMM..................
..................=MMMMMMMO: .....  ?NMM$:   .7MZ ...........DMN................
...............NMM~....................  ,:,  .....,M .........MM+..............
............NMM:...~  =8MMOI?7OMMNMD .......... +MZ...OI........MMZ.............
..........MMN...........................,  .,?DMN,...N ..M.......MM?............
.........,M,.......M........ 8.........  ...........?8.~O..$......NM............
.........DM.................M..........$...............M. .........MM...........
.........MM......,...........O.........~......?OOI......O..:.......?M:..........
........MM...........   .....Z.......... MMMM7MMMMMMMMI.............ZMN.........
......7MM.........MMMMNMMMMN:..........MM+....MMMMMM7 MM.. ......... .MM .......
.....MM7.NM+ ... .OMMMMMMMMMMM,MM.....MM . MMMMMMDDMNMMMM.:M.....   .D==MN......
....MM D .: ............... MMM7.......MMMM ....DM..........ONMMMMN8....? MM....
...8MZ7.D .,MMM=............ M ..................NMM.....:NMMN ....MMD...  MM...
...MM :.M.NMD, +MMM.ZM ..... M ....................?MMNNMM? ...M.....NM..M.:M ..
...OM  .M.....N..NNNM......NMN...............................8MMN.... M .N..MM..
....M~=.N.... M,.........NM8.......... MNMMMM............,MMMN  MMM,..M,.M..MM..
....DMM...7..NMI.......MMMM......... , ...MM..........OMMMM ...NMI8MONM..=. MZ..
.....NM.DM..MMMM....D~..8.MM......+NMMMM DMD..... MMMMMM,.....8MN....M . ..MM...
......MM....MMMMMM......... MM?M~........  . MNMMNO .. MI...MMMM+......I..MM....
...... M8.. MMM,MMMMMM ......,M ..... +MNMMMM.........MMMMMMNMM...... ..MMM.....
.......NN.. MMM.MM. DMMMMMMNNNNNMMMMMMMN, ..MN..... MMMMM8..MM........7MM ......
.......DM...MMN.MM..MM..... MD ...+M........MM.MMMMMMMNM ..MN........IMM........
.......,M . MMMMMMM.NM .....M.....+M..... 8MMMMMMMM,..OM.,MN........ MM.........
........M ..MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM .......NMMM.........MM..........
.......,M...NMMMMMMMMMMMMMMMMMMMMMMMMMMMMM=..MM.......OMM,.........:M ..........
.......7M...OM MMMMMMMMMMMMMMMMMMMNMM8.......+MO....MMMO..........=MD...........
.......MM....MM~M.$M .,M .. MM......NN........NM ,MMM,...........MM,............
.......NM.....MM7..MM .NM... M......MM....... MMMMN.... O.. 8..MMM..............
.......MI......OMMMMMN8,MM...NM.....MMD$MMMMMMM,... M~..+M+..MMN................
...... M ......... IMMMMMMMMMMMMMMMMMMMMMM$ .....M7...MD..,NMM..................
......:M ..?...~.............................:M.. MM ..,NMN.....................
......ZM...=.... N:..................... 7M,..MN ...8MMM........................
......DM....+....... ,?7Z7?=~~:       . ?M? .... MMMN...........................
......8M......=NZ .............  +M8. ........MMMM..............................
...... MD..................................MMMI.................................
....... MM......................... MMNMNMN~....................................
.........MMN ................. DNMMMMMM:........................................
...........DMMMNMMO$7ZDMMNMMMMM8 ...............................................
............... =ONMMD$: .......................................................
................................................................................
................................................................................
..............................................................................*/
public class TestTri {

	/**
	 * tri d'une liste normale
	 */
	public void test_1_TriNormal() {
		SousTitre[] tab = {
				new SousTitre(264, "Batman: Vite, √  la batmobile!!"),
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
				"Batman: Vite, √  la batmobile!!") };

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
	 * tri d'une liste tri√©
	 */
	public void test_4_TriTrie() {
		SousTitre[] tab = {
				new SousTitre(98, "Batman: Vite, √  la batmobile!!"),
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
