import java.awt.*;
import javax.swing.*;

/**
 * Classe Fenetre.
 * 
 * @author Loïc SPACHER
 *
 */
public class Fenetre {

	public static void main(String[] args) {
		JFrame fenetre=new JFrame("Skribble");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Skribble dessin=new Skribble();
		dessin.setPreferredSize(new Dimension(460,460));
		fenetre.setContentPane(dessin);
		fenetre.pack();
		fenetre.setVisible (true);
	}
}
