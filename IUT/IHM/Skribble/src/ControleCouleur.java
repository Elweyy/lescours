import java.awt.Color;
import java.awt.event.KeyEvent;


public class ControleCouleur {

	public void keyPressed(KeyEvent e) {
		
		int c = e.getKeyCode();
		
		switch(c){
		case KeyEvent.VK_R: 
			g.setColor(Color.red);
			break;
		case KeyEvent.VK_V: 
			g.setColor(Color.green);
			break;
		case KeyEvent.VK_B: 
			g.setColor(Color.blue);
			break;
		case KeyEvent.VK_J: 
			g.setColor(Color.yellow);
			break;
		case KeyEvent.VK_G: 
			g.setColor(Color.gray);
			break;
		case KeyEvent.VK_M: 
			g.setColor(Color.);
			break;
		case KeyEvent.VK_Z: 
	
			break;
		case KeyEvent.VK_N: 
	
			break;
		}
	}	

}
