

/**
 * permet de lancer le tri
 * @author vthomas
 *
 */
public class AlgoLogique {


	public static void main(String args[]) {

		// les valeurs à trier
		SousTitre[] tab = {
				new SousTitre(264, "Batman: Vite, à la batmobile!!"),
				new SousTitre(255,
						"Robin: Nom d'un petitbonhomme, mais c'est bien sur"),
				new SousTitre(258,
						"Batman: Oui Robin, c'est le joker qui est derriere cet attentat"),
				new SousTitre(152, "Batman: Mais de qui peut-il s'agir ?"),
				new SousTitre(98, "Robin: Batman, j'entends un rire démoniaque") };

		
		//TODO **** A COMPLETER PAR LES ETUDIANTS ****  
		Trier tri=new Trier();
		System.out.println(tri.trier(tab));
	}
}
