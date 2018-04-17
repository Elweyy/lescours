import java.awt.Dimension;

import javax.swing.JFrame;
public class Principale {
public static void main(String[] args) {
		JFrame fenetre = new JFrame("Calculatrice magique");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Calculatrice c = new Calculatrice();
		c.setPreferredSize(new Dimension(460, 460));
		fenetre.setContentPane(c);
		fenetre.pack();
		fenetre.setVisible(true);
		c.requestFocus();
	}



}
