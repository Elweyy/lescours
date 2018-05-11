import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class VueTexte extends JPanel implements Observer  {

	private JLabel labelX, labelY;
	
	public void update(Observable o) {
		
		labelX = (((Cercle)o).getX().toString());
		
	}

	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	
	

}
