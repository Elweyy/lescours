public class NReines2 {






	public static void main(String... arguments) {
		new NReines2(14);
	}

	private final int n;
	private final int limiteMasque;
	private int nombreSolutions;
	private int[][] echiquiers;





      //      largeur et hauteur, au moins 1



	public NReines2(int n) {

		this.n = n;




// chaque colonne est representee par un entier



 //i une case est libre, le bit correspondant est a 1, sinon il est a 0



 //par exemple pour n = 8, la colonne 10011101 (1 + 4 + 8 + 16 + 128 =

 //157) signifie que seules les cases 0, 2, 3, 4 et 7 sont libres)




	//	*


// un echiquier est represente par un tableau de colonnes









		echiquiers = new int[n][n];






		limiteMasque = 1 << n;

		System.out.println(n + " reines");
		nombreSolutions = 0;




		int colonneLibre = limiteMasque - 1;

		for (int x = 0; x < n; x++) {
			echiquiers[0][x] = colonneLibre;
		}

		long t0 = System.currentTimeMillis();
		placerReines(0);
		long t1 = System.currentTimeMillis();

		System.out.println("solution(s) : " + nombreSolutions);
		System.out.println("duree de la recherche : " + (t1 - t0) + "ms");

	}




	private final void placerReines(int x) {

		*







		int[] echiquier = echiquiers[x];

		*






		int colonne = echiquier[x];

		*


 index de la colonne suivante




		int xSuivant = x + 1;

		if (xSuivant == n) {

			*


 DERNIER COLONNE




			*





			if (colonne != 0) {
				nombreSolutions++;
			}

		} else {

			*


 PAS ENCORE LA DERNIERE COLONNE




			int[] echiquierSuivant = echiquiers[xSuivant];

			int masqueColonne, masqueCase;
			int i;

			*






			while (colonne != 0) {

				*






				masqueCase = colonne ^ (colonne & (colonne - 1));

				*






				colonne &= ~masqueCase;

				*







				i = x;

				while (++i != n) {
					echiquierSuivant[i] = echiquier[i] & ~masqueCase;
				}

				*






				masqueColonne = masqueCase;
				i = x;

				while (++i != n && (masqueColonne >>= 1) != 0) {
					echiquierSuivant[i] &= ~masqueColonne;
				}

				*






				masqueColonne = masqueCase;
				i = x;

				while (++i != n && (masqueColonne <<= 1) != limiteMasque) {
					echiquierSuivant[i] &= ~masqueColonne;
				}

				*





				placerReines(xSuivant);

			}

		}

	}

}
