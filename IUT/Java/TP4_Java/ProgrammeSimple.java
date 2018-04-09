/***********************************
*       Programme simple - TP4         
*               version v1             
***********************************/


import java.util.*;

class ProgrammeSimple {
  public static void main(String args[]) {
    Plan2D p=new Plan2D();
    Scanner scan = new Scanner(System.in);

    //LE RECTANGLE
    System.out.println("CONSTRUCTION RECTANGLE");
    System.out.println("Entrez son abscisse :");
    int x = scan.nextInt();
    System.out.println("Entrez son ordonnee :");
    int y = scan.nextInt();
    System.out.println("Entrez sa largeur :");
    int l = scan.nextInt();
    System.out.println("Entrez sa hauteur :");
    int h = scan.nextInt();
    UnRectangle r = new UnRectangle(x,y,l,h);
    p.ajouteForme(r);
	
	/*
    System.out.println("TRANSLATION");
    System.out.println("Entrez le nombre de pixels de translation en largeur :");
    int dx=scan.nextInt();
    System.out.println("Entrez le nombre de pixels de translation en hauteur :");
    int dy=scan.nextInt();
    p.dupliqueForme(r);
    r.seTranslater(dx,dy);
    p.repaint();

    System.out.println("MODIFICATION");
    System.out.println("Entrez le nombre de pixels d'elargissement :");
    int dl=scan.nextInt();
    p.dupliqueForme(r);
    r.modifierLargeur(dl);
    p.repaint();
	
    System.out.println("Entrez le nombre de pixels de variation de la hauteur :");
    int dh=scan.nextInt();
    p.dupliqueForme(r);
    r.modifierHauteur(dh);
    p.repaint(); 
	
	
    System.out.println("ROTATION (r)");
    scan.next();
    p.dupliqueForme(r);
    r.faireRotation();
    p.repaint();
	*/
	
    System.out.println("SYMETRIE (s)");
    scan.next();
    p.dupliqueForme(r);
    r.faireSymetrie();
    p.repaint();
	
    //END
    System.out.println("EXIT? (e)");
    scan.next();
    System.exit(0);
	
  }
}
