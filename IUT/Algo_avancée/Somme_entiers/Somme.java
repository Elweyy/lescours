/* fonction oui( n:entier)
    debut
        Si n =1 alors
          res <- 1
        sinon
          res <- n+somme(n-1)
        fsi
      retourner (res)
    fin*/

public class Somme{

  public int Somme(int n){
    int res;
    if(n ==1){
      res=1;
    }else{
      int m = n-1;
      res=n+ Somme(m);
    }
    System.out.println(res);
    return res;

  }





}
