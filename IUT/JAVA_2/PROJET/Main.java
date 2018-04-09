import java.util.Scanner;
public class Main {

  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    System.out.println("Indiquez le nombre de joueurs :");
    int i =  sc.nextInt();
    if (i < 2)  {
      System.out.println(" Il faut au moins etre deux pour jouer, trouve toi un ami !");
    }
    if ( i == 2 ) {
      System.out.println(" Vous etes 2, c'est bien on va pouvoir jouer." + "\n"+ "Joueur 1, rentre ton nom ou pseudo :");
      sc.nextLine();
      String j =  sc.nextLine();
      System.out.println(" Felictation tu connais ton nom " + j + " et l'autre tu t'appelles ? " );
      sc.nextLine();
      String u = sc.nextLine();
      System.out.println(" Ok tu t'appelles "+ u + " Commençons !");

    }
    if ( i == 3 ) {
      System.out.println(" Vous etes 3, c'est bien on va pouvoir jouer." + "\n"+ "Joueur 1, rentre ton nom ou pseudo :");
      sc.nextLine();
      String j =  sc.nextLine();
      System.out.println(" Felictation tu connais ton nom " + j + " et l'autre tu t'appelles ? " );
      sc.nextLine();
      String u = sc.nextLine();
      System.out.println( "Donc tu t'appelles "+ u + " et le dernier c'est quoi ton petit nom ? ");
      sc.nextLine();
      String y = sc.nextLine();
      System.out.println(" Ok tu t'appelles "+ y + " Commençons !");
    }
    if ( i == 4 ) {
      System.out.println(" Vous etes 4, c'est bien on va pouvoir jouer." + "\n"+ "Joueur 1, rentre ton nom ou pseudo :");
      sc.nextLine();
      String j =  sc.nextLine();
      System.out.println(" Felictation tu connais ton nom " + j + " et l'autre tu t'appelles ? " );
      sc.nextLine();
      String u = sc.nextLine();
      System.out.println( "Donc tu t'appelles "+ u + ". Au suivant maintenant ! ");
      sc.nextLine();
      String y = sc.nextLine();
      System.out.println(" Ok tu t'appelles "+ y + ". Et le dernier ? ");
      sc.nextLine();
      String o = sc.nextLine();
      System.out.println ( " Salut " + o +". Bien maintenant commencons !");
    }
  }

}
