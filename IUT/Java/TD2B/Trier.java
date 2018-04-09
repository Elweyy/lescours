
public class Trier {

	/**
	 * M�thode de tri par insertion
	 * @param tab le tableau des sous-titres � trier
	 * @return la liste tri�e
	 */
	public Liste trier(SousTitre[] tab) {
		Liste l = new ListeContigue(100);

		for (int i = 0 ; i < tab.length ; i++) {
			if (l.finliste(l.tete())) {
				l.adjtlis(tab[i]);
			} else {
				int pos = l.tete();
				int last_pos = -1;
				boolean continuer = true;
				while (continuer) {
					if (tab[i].compareTo(l.val(pos)) > 0) {
						last_pos = pos;
						pos = l.suc(pos);
						if (l.finliste(pos)) {
							l.adjlis(last_pos, tab[i]);
							continuer = false;
						}
					} else {
						if (last_pos == -1) {
							l.adjtlis(tab[i]);
						} else {
							l.adjlis(last_pos, tab[i]);
						}
						continuer = false;
					}
				}
			}
		}
		return l;
	}
}
