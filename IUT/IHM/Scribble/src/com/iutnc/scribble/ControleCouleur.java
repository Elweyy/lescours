package com.iutnc.scribble;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControleCouleur implements KeyListener {
	Color couleur = Color.BLACK;
	
	public Color getCouleur() {
		return couleur;
	}

	public void keyTyped(KeyEvent e) {
		this.keyReleased(e);
	}


	public void keyPressed(KeyEvent e) {
		
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'r':
			couleur = Color.RED;
			break;
		case 'v':
			couleur = Color.GREEN;
			break;
		case 'b':
			couleur = Color.BLUE;
			break;
		case 'j':
			couleur = Color.YELLOW;
			break;
		case 'g':
			couleur = Color.GRAY;
			break;
		case 'm':
			couleur = Color.MAGENTA;
			break;
		case 'z':
			couleur = Color.PINK;
			break;
		case 'n':
			couleur = Color.BLACK;
			break;
		}
	}

}
