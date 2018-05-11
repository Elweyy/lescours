import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;



public class VueGraph extends JPanel 
implements Observer{
	Disque modele;
	public void update(Observable o, Object arg1) {
		//mise à jour du lien vers le modèle à afficher
		modele=(Disque)o;
		repaint(); //appel de la fonction d'affichage 
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//affichage du cercle si il est référencé
		if (modele!=null) {
			g.drawOval(0, 0, modele.getTaille(), 			modele.getTaille());
		}
	} 
}
