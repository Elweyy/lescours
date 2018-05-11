import java.awt.Color;
import java.util.Observable;

/** classe balle* */

public class Disque extends Observable {
	 private int taille;
	 public Disque() {
	  taille = 10; 
	 }
	 // pour la vue
	 public int getTaille() {
	    return (taille); 
	 }
	 //pour le contrôleur
	 public void setTaille(int t) 
	 { 
	    if (t>0) taille=t; 
	    //méthodes de Observable
	    //prévenir de la modification 
	    setChanged();
	    //notifier Observer
	    notifyObservers();
	 } 
	}
