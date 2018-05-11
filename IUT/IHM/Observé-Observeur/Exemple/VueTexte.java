import java.util.Observable;
import java.util.Observer;
public class VueTexte implements Observer {
   public void update(Observable o, Object arg) {
      	System.out.println("vue texte:" +       	((Disque)o).getTaille());
   }
}
