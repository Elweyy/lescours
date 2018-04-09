/**
 * classe qui construit et distribue des listes
 * en fonction d'une chaine
 *
 * @author vthomas
 *
 */
public class DistributeurListe {

	/**
	 * permet de masquer l'implementation d'une liste
	 * pattern factory
	 * - chaine = chainee, liste chainee
	 * - chaine = contigue, liste contigue
	 * - chaine = prof, listeprof
	 *
	 * @param s la chaine qui d�crit ce le type attendu
	 * @return liste du bon type construite en interne
	 */
	public Liste fournirListe(String s)
	{
		//resultat � construire
		Liste l=null;

		switch(s) {
			case "prof":
			l =new ListeProf ();
			break ;
			case "contigue":
			l =new ListeContigue (100);
			break ;
			case "chainee":
			l =new ListeChainee (100);
			break ;
		}

		return(l);
	}

}
