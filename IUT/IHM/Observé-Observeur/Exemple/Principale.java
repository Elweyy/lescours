import java.awt.*;
import javax.swing.*;

public class Principale {

	 public static void main(String[] args) {
	      Disque d = new Disque();
	      VueTexte vt = new VueTexte();
	      VueGraph vg = new VueGraph();
	      // attacher les vues au modèle
	      d.addObserver(vt);
	      d.addObserver(vg);
	      ControlGraphique c = new ControlGraphique(d);
	      JFrame f = new JFrame();
	      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      f.setLayout(new BorderLayout());
	      c.setPreferredSize(new Dimension(100, 50));
	      vg.setPreferredSize(new Dimension(200, 200));
	      f.getContentPane().add(vg, BorderLayout.NORTH);
	      f.getContentPane().add(c, BorderLayout.SOUTH);
	      f.pack();
	      f.setVisible(true);
	      d.setTaille(10);
	      c.setValue(10);
	}  
	 
}