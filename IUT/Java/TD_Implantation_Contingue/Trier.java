/**
 * classe en charge de trier une liste
 *
 * @author vthomas
 *
 */
public class Trier {

	/**
	 * méthode de tri par insertion
	 *
	 * @param tab
	 *            le tableau des sous titres à trier
	 * @return la liste triée
	 */
	public Liste trier(SousTitre[] tab) {

		Liste l = new ListeContigue(200);

		for(int i=0; i < tab.length; i++){

			if (l.finliste(l.tete())) {		// On rentre une première valeur
				l.adjtlis(tab[i]);
			}else{

					int position= l.tete();
					int derniere_position =-1;
					boolean continuer =true;

					while (continuer==true) {
																													// On compare la valeur à rentrer avec celles déjà rentrées
						if (tab[i].compareTo(l.val(position))>0){  		// Si elle est supérieure on l'ajoute à la suite
							derniere_position = position;
							position = l.suc(position);

							if(l.finliste(position)) {									// Si elle est la dernière valeur de la liste, on arrête la boucle while
								l.adjlis(derniere_position, tab[i]);
								continuer= false;
							}
						}else {

							if (derniere_position==-1) {
								l.adjtlis(tab[i]);										// Si elle est inférieure, on l'ajoute en tête de liste
							}else{
								l.adjlis(derniere_position, tab[i]);	// Sinon on l'insère à la position correspondante
							}
							continuer=false;												// On arrête la boucle while
						}
					}
				}
			}
		return l;
	}
}



// pour chaque chaine; l'ajouter
	// si la liste est vide
		// ajoute en tete

	// sinon on cherche ou ajouter
		// on recupere la tete
		// boucle de recherche dans la liste
		// tant que j'ai pas fini et que j'ai pas tout parcouru
			// si ce qu'on cherche est avant
				// on s'arrete
				// on decale

		// soit ajoute devant
			// on a pas decale, ajout en tete
		// sinon on ajoute à la place précedente
