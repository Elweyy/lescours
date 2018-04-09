import java.util.ArrayList;
public class TestInterclassement extends Interclassement {
  public static void main(String[] args){
    ArrayList<Integer> liste1 = new ArrayList<Integer>();
    ArrayList<Integer> liste2 = new ArrayList<Integer>();
    ArrayList<Integer> liste_resultat = new ArrayList<Integer>();
    Interclassement interclasse = new Interclassement();

    liste1.add(1);
    liste1.add(3);
    liste1.add(5);
    liste1.add(7);
    liste1.add(9);
    liste1.add(11);
    liste1.add(13);
    liste1.add(15);
    liste1.add(17);
    liste1.add(19);
    liste1.add(21);

    liste2.add(0);
    liste2.add(2);
    liste2.add(4);
    liste2.add(6);
    liste2.add(8);
    liste2.add(10);
    liste2.add(12);
    liste2.add(14);
    liste2.add(16);
    liste2.add(18);
    liste2.add(20);

    liste_resultat = interclasse.interclasser(liste1,liste2);
    System.out.println(liste1);
    System.out.println(liste2);
    System.out.println(liste_resultat);

  }
}
