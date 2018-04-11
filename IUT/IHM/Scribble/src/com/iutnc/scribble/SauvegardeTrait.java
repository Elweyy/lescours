package com.iutnc.scribble;

import java.awt.Color;

public class SauvegardeTrait {
	private final int MAX = 10000;
	private int index = 0;
	private int end = 0;
	private int[][] traits = new int[MAX][4];
	private Color[] couleurs = new Color[MAX];
	
	public void ajouterTrait(int fromX, int fromY, int toX, int toY, Color c) {
		if (index < MAX) {
			traits[index][0] = fromX;
			traits[index][1] = fromY;
			traits[index][2] = toX;
			traits[index][3] = toY;
			couleurs[index] = c;
			index++;
			end++;
		}
	}
	
	public void rewind() {
		index = 0;
	}
	
	public void reset() {
		end = 0;
		rewind();
	}
	
	public int[] nextTrait() {
		if (index < MAX && index <= end)
			return traits[index++];
		else
			return null;
	}
	
	public Color getCouleur() {
		if (index < MAX && index <= end)
			return couleurs[index];
		else
			return null;
	}
}
