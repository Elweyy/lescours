public class Factoriel {

  public int Factoriel(int n){
    int res =1;
    if(n==0){
      return res;
    }else{
      int m=n-1;
      int p = Factoriel(m);
      res = n*p;
      System.out.println(res);
      return res;
    }
  //  System.out.println(res);
    //return res;
  }









/*  si n=0 alors
    retourner res <-1
  sinon
    m <- n-1
    p <- fact(m)
    res <- n*p
  fsi
retourner res*/
}
