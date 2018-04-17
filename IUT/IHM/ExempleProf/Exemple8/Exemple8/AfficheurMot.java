import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AfficheurMot extends JPanel {
	private int pos_x,pos_y;
	private String mot;

	public AfficheurMot() {
		mot="";
		pos_x=0;
		pos_y=0;
		
		// case � cocher indiquant si on affiche le mot en majuscules ou pas
		final JCheckBox maj=new JCheckBox("Majuscules");
		this.add(maj);
		
		// bouton radio pour afficher le mot � l'endroit
		JRadioButton b1=new JRadioButton("sens direct");
		// bouton radio pour afficher le mot � l'envers
		final JRadioButton b2=new JRadioButton("sens inverse");
		// groupement des boutons radio
		ButtonGroup bg=new ButtonGroup();
		bg.add(b1);
		bg.add(b2);
		b1.setSelected(true);
		this.add(b1);
		this.add(b2);
		
		// champ de texte : mot � afficher
		this.add(new JLabel("mot à afficher :"));
		
		final JTextField tf=new JTextField("");
		tf.setColumns(10);
		this.add(tf);
		
		// gestion des clics souris
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				pos_x=e.getX();
				pos_y=e.getY();
				mot=tf.getText();
				if (maj.isSelected()) mot=mot.toUpperCase();
				if (b2.isSelected()) mot=new StringBuffer(mot).reverse().toString();
				repaint();
			}
		});
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawString(mot,pos_x,pos_y);
	}
}
