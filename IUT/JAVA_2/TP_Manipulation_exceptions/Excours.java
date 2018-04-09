public class Excours {
  public static void main(String args[]) {
    int numerateur, denominateur;
    numerateur=7;
    denominateur=1;
    denominateur--;
    try{
      System.out.println("Avant erreur");
      System.out.println("Quotient =" + numerateur/denominateur);
      System.out.println(" Suite erreur");  // ne sera pas atteint
    }catch(NullPointerException e1) {
      System.out.println("erreur version 1");
    }catch(ArithmeticException e2) {
      System.out.println("erreur version 2");
    }
    System.out.println("Fin");
  }
}
