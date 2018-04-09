public class ListeChainee implements Liste {

	/*
	 * On donne l'indice de t�te de liste
	 */

	private int tete;

	/*
	 * Tableau des maillons entiers
	 */

	private MaillonEntier[] tab;


	public ListeChainee(int iMax) {
		if (iMax <=0) {
			iMax=1;
		}else {
			this.tab= new MaillonEntier[iMax];
			this.tete=-1;
			for (int i=0;i<tab.length;i++) {
				tab[i]= new MaillonEntier(null,-2);

			}
		}
	}
	public int suc(int p) {
		return this.tab[p].getSuc();
	}

	public	SousTitre val(int p) {
		return this.tab[p].getVal();
	}

	public boolean finliste(int p){
		return p==-1; // correspond à la fin de la liste
	}

	public int tete(){
		return this.tete;
	}

	private int retournerPlaceLibre(){
		int i=0;

		while(tab[i].getSuc()!=-2){
			i+=1;
		}
		return i;
	}

	private void libererPlace(int p) {
		tab[p-1].setSuc(tab[p].getSuc());
		tab[p] = new MaillonEntier(null,-2);

	}



	/**
	 * permet de suprrimer un element d'une liste
	 * @param p place de l'element  supprimer
	 */
	public void suplis(int p){

		if (p>=0 && p<this.tab.length) {

		if (tete==p) {
			if (this.finliste(this.suc(p))) {
				tete = (-1);
			}
			else {
				tete =(suc(p));
			}
		}
		else if (this.finliste(suc(p))) {
			//boucle while pour trouver le predecesseur de p soit qui p pour successeur
			int i = 0;
			while (tab[i].getSuc()!=p) {
				i++;
			}
			tab[i].setSuc(-1);
		}
		else if (!this.finliste(suc(p))) {
			//boucle while pour trouver le predecesseur de p soit qui p pour successeur
			int i = 0;
			while (tab[i].getSuc()!=p) {
				i++;
			}
			tab[i].setSuc(suc(p));

			}
		}
	}

	/**
	 * ajoute un element en tete de Liste
	 * @param s Element  ajouter en tete
	 */
	public void adjtlis(SousTitre s){
		int p = this.retournerPlaceLibre();
		tab[p].setVal(s);
		tab[p].setSuc(tete);
		this.tete=p;

	}
	/**
	 * ajoute un element a un endroit quelconque dans la liste
	 * @param p place apres laquelle inserer
	 * @param s element inserer
	 */
	public void adjlis(int p, SousTitre s){
		int previous =this.tab[p].getSuc();
		int free = this.retournerPlaceLibre();
		this.tab[free].setVal(s);
		this.tab[p].setSuc(free);
		this.tab[free].setSuc(previous);





	}
}
