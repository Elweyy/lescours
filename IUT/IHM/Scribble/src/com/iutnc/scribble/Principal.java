package com.iutnc.scribble;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Principal {
	public static void main(String[] args) {
		JFrame f = new JFrame("Scribble :D");
		ControleCouleur c = new ControleCouleur();
		Scribble sc = new Scribble(c);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setPreferredSize(new Dimension(600, 480));
		f.setContentPane(sc);
		f.pack();
		f.setVisible(true);
		sc.addMouseMotionListener(sc);
		sc.addMouseListener(sc);
		sc.addKeyListener(c);
		sc.requestFocus();
	}
}
