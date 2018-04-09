import java.util.*;

/**
 * classe qui permet de modeliser un nombre de connexions
 *
 */
public class Logs {
	/**
	 * attributs tableau de nombre de connexions
	 */
	private int[] connexions;

	/**
	 * attributs, nombre min, max et moyenne du tableau nbrConnexions
	 */
	private int min, max;
	private double moyenne;

	/**
	 * constructeur ou tous les nombres de connexions mensuelles sont
	 * supposes nuls
	 *
	 * @param n
	 *            nombre de mois d'etude (au moins 1)
	 */
	public Logs(int n) {
		if ( n<1)
		{
			n=1;
		}
		this.connexions = new int[n];
		this.min=0;
		this.max=0;
		this.moyenne=0;

	}

	/**
	 * methoed qui met a jour les attributs min max et moyenne
	 */
	private void calculMinMaxMoy() {
		int nmin = this.connexions[0];
		int nmax = this.connexions[0];
		int nmoyenne = this.connexions[0];
		for (int i =1 ; i<this.connexions.length ; i++) {
			if(this.connexions[i] > nmax){
				nmax = this.connexions[i];
			}
			if(this.connexions[i] < nmin){
				nmin = this.connexions[i];
			}
			nmoyenne= this.connexions[i];
		}
		this.min=nmin;
		this.max=nmax;
		this.moyenne=nmoyenne/this.connexions.length;
	}

	/**
	 * methode de saisie des releves de connexions
	 */
	public void saisirConnexions() {
	Scanner sc = new Scanner (System.in);
	for(int i=0; i<this.connexions.length;i++) {
		this.connexions[i]=sc.nextInt();
		}
			this.calculMinMaxMoy();
	}


	/**
	 * pour l'affichage
	 *
	 * @return chaine de caracteres representant le releve de
	 *         connexions
	 */
	public String toString() {
		String res="";
		for (int i=0; i<this.connexions.length; i++) {
			res= res + this.connexions[i];
		}
		res = "moyenne = " + this.moyenne + " max = " + this.max + " min = " + this.min + "\n";
		return (res);
	}

	/**
	 * test de nbconnexions
	 *
	 * @param args
	 *            inutile
	 */
	public static void main(String[] args) {
		Logs nc = new Logs(8);
		nc.saisirConnexions();
		System.out.println(nc);
		nc.corrigerConnexions(2, new int[] { 54, 68, 687 });
		nc.inverserConnexions();
		System.out.println(nc);
		nc.entrerNouveauReleve(7653);
		nc.trierDecroissantConnexions();
		System.out.println(nc);
	}

	/**
	 * permet de corriger des elements successifs du tableau de
	 * nombres de connexions mensuelles
	 *
	 * @param mois_debut
	 *            indice de la premiere valeur a modifier
	 * @param tab
	 *            nouvelles valeurs
	 */
	public void corrigerConnexions(int mois_debut, int[] tab) {
		int j=0;
		for (int i=mois_debut; i<(mois_debut+tab.length);i++){
			if((mois_debut<=(this.connexions.length-tab.length+1))&&(i<=this.connexions.length-1)){
				this.connexions[i]=tab[j];
					j+=1;
			}
		}
		this.calculMinMaxMoy();
	}



	/**
	 * permet d'inverser l'ordre des valeurs stockees dans le tableau
	 * de nombres de connexions mensuelles
	 */
	public void inverserConnexions() {
		int[] tab = new int[this.connexions.length];
		for (int j=0;j<this.connexions.length;j++){
			tab[j] = this.connexions[j];
		}

		for (int i = 0 ; i < this.connexions.length; i++){
			this.connexions[this.connexions.length-1-i]=tab[i];

        }

	}



	/**
	 * permet de rentrer une nouvelle valeur (le nombre de connexions
	 * du dernier mois ecoule) dans le tableau, et met a jour le
	 * nombre minimum, maximum et moyen de connexions
	 * <p>
	 * la case i contient toujours le nombre de connexions mensuelles
	 * enregistre i mois auparavant
	 *
	 * @param nv
	 *            nouvelle valeur
	 */
	public void entrerNouveauReleve(int nv) {
		int[] tab = new int[this.connexions.length-1];
		for (int i=0;i<this.connexions.length-1;i++) {
			tab[i]=this.connexions[i];
		}
		this.corrigerConnexions(1, tab);
		this.connexions[0] = nv;
		this.calculMinMaxMoy();
	}

	/**
	 * constructeur a partir d'un tableau a 2 dimensions de taille n x
	 * 12 dont
	 * la case {[i,j]} correspond au j-ieme mois de l'annee 2013-i
	 *
	 * @param tab2D
	 *            tableau a 2 dimensions
	 */
	public Logs(int[][] tab2D) {
		// TODO a completer
	}

	/**
	 * tri decroissant par selection
	 */
	public void trierDecroissantConnexions() {
		// TODO a completer
	}

	/**
	 * getter
	 *
	 * @return le tableau de nombre de connexions
	 */
	public int[] getNbrConnexions() {
		return this.connexions;
	}

	/**
	 * getter
	 *
	 * @return le min
	 */
	public int getMin() {
		return this.min;
	}

	/**
	 * getter
	 *
	 * @return le max
	 */
	public int getMax() {
		return this.max;
	}

	/**
	 * getter
	 *
	 * @return la moyenne
	 */
	public double getMoyenne() {
		return this.moyenne;
	}

	/**
	 * faire un tri decroissant par une methode a bulle
	 */
	public void trierDecroissantBulle() {
		// TODO a completer
	}
}
