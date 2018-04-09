import java.util.ArrayList;

public class Interclassement{

  public ArrayList<Integer> interclasser(ArrayList<Integer> liste1, ArrayList<Integer> liste2){
    ArrayList<Integer> liste_interclassee = new ArrayList<Integer>();

    int place1 = 0;
    int place2 = 0;
    Integer entierListe1;
    Integer entierListe2;
    while (place1 < liste1.size() && place2 < liste2.size()){
      entierListe1 = liste1.get(place1);
      entierListe2 = liste2.get(place2);
      if (entierListe1 < entierListe2) {
        liste_interclassee.add(entierListe1);
        place1 += 1;
        }
      else {
        liste_interclassee.add(entierListe2);
        place2 += 1;
      }
    }
    if (place1 == liste1.size()){
      liste_interclassee = copierFinListe(liste2,place2,liste_interclassee);
    }
    else{
      liste_interclassee= copierFinListe(liste1,place1,liste_interclassee);
    }
    return liste_interclassee;
  }

  public ArrayList<Integer> copierFinListe(ArrayList<Integer> liste1, int place_liste1, ArrayList<Integer> liste2){
    while (place_liste1 < liste1.size()){
      liste2.add(liste1.get(place_liste1));
      place_liste1 += 1;
    }
    return liste2;
  }
}
