/*public class reine {
  public static void placerReines(int i) {
  int j;
  for (j=1;j<=8;j++){
    System.out.println("i="+i+"j="+j);
    if (ligne[j]==false) {
    ligne[j]=true;
    if ( i+1<9)
      placerReines(i+1);
    if ( i==8) afficherReines();
    ligne[j]=false;
      }
    }
  }

  public static void main(String args[]){
    int j;
    for (j=1; j<9;j++) ligne [j]= false;
    placerReines(1);
  }
}
*/


public class reine {



/*

	public static void main(String... arguments) {
		new reine(8);
	}

	private final int n;
	private int nombreSolutions;
*/


private  int n;
private int nombreSolutions;




	public   reine(int num) {

		this.n = num;

		System.out.println(n + " reines");
		nombreSolutions = 0;

		long t0 = System.currentTimeMillis();
		placerReines(0, 0, 0, 0);
		long t1 = System.currentTimeMillis();

		System.out.println("solution(s) : " + nombreSolutions);
		System.out.println("duree de la recherche : " + (t1 - t0) + "ms");

	}









	private final void placerReines(int x, int bH, long bD, long bA) {

		int xSuivant = x + 1;

		int mH = 1;
		long mD = 1 << x;
		long mA = 1 << n - xSuivant;

		for (int y = 0; y < n; y++, mH <<= 1, mD <<= 1, mA <<= 1) {

			/*


 on verifie que les lignes horizontales et diagonales passant par

 la case sont vides

*/


			if ((bH & mH) == 0 && (bD & mD) == 0 && (bA & mA) == 0) {

				if (xSuivant == n) {
					nombreSolutions++;
				} else {
					placerReines(xSuivant, bH + mH, bD + mD, bA + mA);
				}

			}

		}

	}




  public static void main(String... arguments) {
    new reine(8);
  }



}



/*
 algorithme relativement efficace (reste a le paralleliser et a tirer profit

 des symetries)
*/
