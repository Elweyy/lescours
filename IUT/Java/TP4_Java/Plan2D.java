/***********************************
*              Plan2D - TP4                                *
*            version v1                                       *
***********************************/


import javax.swing.*;
import java.util.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;


class Dessin extends JPanel  {
  Object figs[];
  int fig_type[];
  int how_many;
  
  Dessin() {
    figs = new Object[100];
    fig_type = new int[100];
    how_many = 0;
  }
  public void paint(Graphics g) {
    super.paint(g);
    
    g.setColor(Color.black);
    g.drawLine(0,0,getWidth(),getHeight());
    
    for(int i=0; i<how_many;i++){
	    switch(fig_type[i]){
	    case 1:
        UnRectangle rectangle = (UnRectangle) figs[i];
        if( (rectangle.largeur>0) && (rectangle.hauteur>0)) {
          g.setColor(Color.red);
          if(i==how_many-1){
            g.fillRect(rectangle.coin.abscisse,rectangle.coin.ordonnee-rectangle.hauteur,
                       rectangle.largeur,rectangle.hauteur);
          } else {
            g.drawRect(rectangle.coin.abscisse,rectangle.coin.ordonnee-rectangle.hauteur,
                       rectangle.largeur,rectangle.hauteur);
          }
        } else {
          System.out.println("Un rectangle ne peut pas etre affiche");
        }
        break;
	    default:
	    }
    }
  }
  public void dupliquer(UnRectangle r){
    UnRectangle new_r = new UnRectangle(r);
    figs[how_many] = figs[how_many-1];
    fig_type[how_many] = fig_type[how_many-1];
    figs[how_many-1] = new_r;
    fig_type[how_many-1] = 1;
    how_many++;
  }
  public void ajoute(UnRectangle r){
    figs[how_many] = r;
    fig_type[how_many++] = 1;
  }
}

class Plan2D extends JFrame  {
  Dessin dessin;
  Plan2D() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    dessin=new Dessin();
    dessin.setPreferredSize(new Dimension(600,600));
    dessin.setBackground(Color.white);
    this.setContentPane(dessin);
    this.pack();
    this.setVisible(true);
  }
  void ajouteForme(UnRectangle r) {
    dessin.ajoute(r);
    repaint();
  }
  void dupliqueForme(UnRectangle r) {
    dessin.dupliquer(r);
    repaint();
  }
  
}

