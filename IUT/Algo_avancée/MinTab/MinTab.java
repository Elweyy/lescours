public class MinTab {

  int tab[];

  public int Mintab(int n){
    if (n==1) {
    int min1 =this.tab[1];
    System.out.println(min);
    return this.min;
    }else{
      int m = n-1;
      int min2=Mintab(m);
        if (this.tab[n] <= min2){
          min = tab[n];
        }else{
          min = min2;
        }
        System.out.println(min);
        return min;
    }

  }





}


/*

            fonction mintab(tab: tableau entier [1..m], n entier ) : entier

              si n=1

                min <- tab[1]


              sinon

                min2 < -mintab(t, n-1)
                  si  t[n] <= min2 alors
                  min <- t[n]
                  sinon
                  min <- min2
                  fsi
                fsi
              retourner min

            fin
 */
