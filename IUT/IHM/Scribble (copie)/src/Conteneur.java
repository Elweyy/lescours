import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Conteneur extends Scribble {
	private Color couleur;

	public Conteneur() {
		final Scribble dessin = new Scribble();

		// bouton Effacer askip
		JButton b = new JButton("Effacer");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dessin.getGraphics().clearRect(0, 0, getWidth(), getHeight());
			}
		});

		final JComboBox c = new JComboBox(new String[] { 
				"rouge", "vert","jaune", "blue", "black" }
		);
		c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (c.getSelectedIndex()) {
				case 0:
					dessin.setColor(Color.RED);
					break;
				case 1:
					dessin.setColor(Color.GREEN);
					break;
				case 2:
					dessin.setColor(Color.YELLOW);
					break;
				case 3:
					dessin.setColor(Color.BLUE);
					break;
				case 4:
					dessin.setColor(Color.BLACK);
					break;
				}

			}
		});

		JPanel haut = new JPanel();
		haut.add(b);
		haut.add(c);
		this.setLayout(new BorderLayout());
		this.add(haut, BorderLayout.NORTH);
		this.add(dessin, BorderLayout.CENTER);
	}
}
