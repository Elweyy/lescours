public class reines{

  static int n=8;
  static boolean ligne[] = new boolean[n+1];
  static boolean diagbleue[]= new boolean[2*n];
  static boolean diagroupe[]= new boolean[2*n];

  public static void PlacerReines(int i) {
    int j,k;
    for (j=1;j<=n;j++){
    //System.out.println("i="+i+" j="+j);
    pos[i]=j;
    if ((ligne[j]==false) && (diagbleue[i-j+n]==false)  && (diagroupe[i+j-1]== false)) {
        ligne[j]=true;diagbleue[i-j+n]=true; diagroupe[i+j-1]=true;
        if (i<n)
          PlacerReines(i+1);
        if (i==n){
          for (k=1;k<n+1;k++)
            System.out.println(pos[k]+",");
          System.out.println();
        }
        ligne[j]=false;diagbleue[i-j+n]=false;diagroupe[i+j-1]=false;
      }
    }
  }
}
