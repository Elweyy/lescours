public class Binaire {

  public void Binaire(int n){

    if (n >1){
        Binaire(n/2);

    }else{
      System.out.println(n%2);
    }
  }

}




/*
fonction binaire (n: entier)                exe : binaire(13) va afficher 1 1 0 1
  début
    si n > 1 alors
      écrire (n mod 2)
    sinon
      binaire(n/2)
    fsi
  fin

 */
