package com.iutnc.scribble;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Scribble extends JPanel implements MouseListener, MouseMotionListener {
	private int posX = 0, posY = 0;
	private int lastX = 0, lastY = 0;
	private ControleCouleur ctrlCoul;
	private SauvegardeTrait save = new SauvegardeTrait();
	
	private boolean clearDraw = false;
	private boolean load = false;

	public Scribble(ControleCouleur ctrlCoul) {
		this.ctrlCoul = ctrlCoul;
	}

	
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		if (clearDraw) {
			super.paintComponent(g);
			clearDraw = false;
			if (load) {
				save.rewind();
				int[] trait;
				Color c;
				while ((trait = save.nextTrait()) != null) {
					c = save.getCouleur();
					g.setColor(c);
					g.drawLine(trait[0] , trait[1], trait[2], trait[3]);
				}
				load = false;
			}
		} else {
			g.setColor(ctrlCoul.getCouleur());
			g.drawLine(lastX, lastY, posX, posY);
			save.ajouterTrait(lastX, lastY, posX, posY, ctrlCoul.getCouleur());
		}
	}

	
	public void mouseDragged(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			lastX = posX;
			lastY = posY;
			posX = e.getX();
			posY = e.getY();
			repaint();
		}
	}

	
	public void mouseMoved(MouseEvent e) {
		lastX = posX;
		lastY = posY;
		posX = e.getX();
		posY = e.getY();
	}

	
	public void mouseClicked(MouseEvent e) {
	}

	
	public void mousePressed(MouseEvent e) {
	}

	
	public void mouseReleased(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			repaint();
		}
		// Efface l'écran
		if (SwingUtilities.isMiddleMouseButton(e)) {
			clearDraw = true;
			repaint();
		}
		// Efface l'écran et charge la dernière sauvegarde
		if (SwingUtilities.isRightMouseButton(e)) {
			clearDraw = true;
			load = true;
			repaint();
		}
	}

	
	public void mouseEntered(MouseEvent e) {}

	
	public void mouseExited(MouseEvent e) {}
}
