import java.awt.*;
import java.awt.event.*;


import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Classe Skribble.
 * 
 * @author Loïc SPACHER
 *
 */
public class Skribble extends JPanel{
	int lastX,lastY ;
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);	
		g.setColor(Color.RED);
		g.drawLine(lastX, lastY, getX(), getY());
		}
	
	
}