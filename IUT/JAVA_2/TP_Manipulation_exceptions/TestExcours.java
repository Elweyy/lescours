public class testouille {
  public static void main (String args[]) {
    int tableauEntier []= {16,1,2,3,4,5,0,7,0,9};

    try{
      produitTabInt(tableauEntier);

  } catch(Exception e){

  }
}

  public static int produitTabInt(int[] tab){
    int res =1;
      for (int i=0; i<tab.length; i++) {
        if (tab[i] ==O) {
          throw new Exception("zéro détecté en [" + i + " ]");

        }else{
          res = tab[i];

        }

    }
      return res;
    }
  }
