import java.awt.*;

import javax.swing.*;

/**
 * Classe Principale.
 * 
 * @author Samuel Cruz-Lara
 *
 */
public class Principale {
	
	public static void main(String[] args) {
		JFrame fenetre = new JFrame("Skribble :D");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Conteneur tf = new Conteneur();

		tf.setPreferredSize(new Dimension(460, 460));
		fenetre.setContentPane(tf);
		fenetre.pack();
		fenetre.setVisible(true);
		tf.requestFocus();
	}
	
}
