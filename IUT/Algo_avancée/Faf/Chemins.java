public class Chemins {

static  int[][] graphe =
  {{0,1,1,0,0,0,0,0,0}, //a
   {0,0,1,0,0,0,0,0,0}, //b
   {0,0,0,1,0,0,0,0,0}, //c
   {0,0,0,0,1,0,0,0,0}, //d
   {0,0,0,0,0,1,1,0,0}, //e
   {0,0,0,0,0,0,0,0,0}, //f
   {0,0,0,0,0,0,0,1,0}, //g
   {0,1,0,0,0,0,0,0,0}, //h
   {0,0,0,0,0,0,0,0,0}, //i
  };

  static int[] solution = new int[9];
  static int n;


  public static void main ( String ars[]) {

    solution[0]=0;

    n=1;
    rechercher(0);  //0=a


  }

  static boolean cycle(int i) {
    for (int j=0; j<n;j++) {
      if (solution[j]==i) return true;
    }
    return false;
  }


  static void rechercher(int pos) { //pos=depart

    if (pos==5) {
      //afficher solution
      System.out.println("Chemin : ");
      for (int i =0;i<n;i++){
        System.out.print((char)(solution[i]+'a'));
      }
      System.out.println();
    }else{
      for (int i=0;i<9;i++){
        if(graphe[pos][i]==1){ //i est successeur de pos
          solution[n]=i;
          n++;
          rechercher(i);
          n--;
        }
      }

    }

  }






}
