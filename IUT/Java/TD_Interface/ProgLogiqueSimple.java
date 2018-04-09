/**
 * premier programme a ecrire par les étudiants
 * @author vthomas
 *
 */
public class ProgLogiqueSimple extends ListeProf {

	public static void main(String []args)
	{
		Liste l=new ListeProf();
		l.adjtlis(new SousTitre(264, "Batman: Vite à la batmobile"));
		l.adjtlis(new SousTitre(98, "Robin: Batman, j'entends un rire dement"));
		l.adjtlis(new SousTitre(255, "Robin: Nom d'un petit bonhomme"));
		l.adjtlis(new SousTitre(258, "Batman: Oui, encore un coup du Joker"));
		l.adjtlis(new SousTitre(152, "Batman: Mais de qui peut il s'agir"));

		int place=l.tete();



/*
L'algo écrit les sous-titres dans l'ordre où ils ont été implanté. Il les écrit tant que la liste n'est pas finie.

place <- tete
tantque(finliste (l,place) =/= vrai)
ecrire (val(l,place))
place <- suc(l,place)
fftantque
*/



		while(!l.finliste(place)) {
			System.out.println(l.val(place));
			place=l.suc(place);
		}


	}

}
