import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControlGraphique extends JSlider {
	   //lien vers le modèle
	   Disque modele;
	   public ControlGraphique(Disque d) {
	      super();
	      //lien avec le modèle
	      modele=d;
	      //initialisation du Slider
	      setMaximum(100);
	      setMinimum(1);
	      //ajout d'un listener pour suivre l‘évolution du curseur
	      this.addChangeListener(new ChangeListener(){
	         public void stateChanged(ChangeEvent e) {
	            modele.setTaille(getValue());
	         }
	      });
	   }
	}

