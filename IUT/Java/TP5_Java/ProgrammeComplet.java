import java.util.Scanner;

/****************************************
 * classe Programmecomplet Version 2 - TP5
 *****************************************/

class ProgrammeComplet {
	public static void main(String args[]) {
		Plan2D p = new Plan2D();

		Scanner sc = new Scanner(System.in);

		// LE RECTANGLE
		System.out.println("CONSTRUCTION RECTANGLE");
		System.out.println("Entrez son abscisse :");
		int x = sc.nextInt();
		System.out.println("Entrez son ordonnée :");
		int y = sc.nextInt();
		System.out.println("Entrez sa largeur :");
		int l = sc.nextInt();
		System.out.println("Entrez sa hauteur :");
		int h = sc.nextInt();
		UnRectangle r = new UnRectangle(x, y, l, h);
		p.ajouteForme(r);

		System.out.println("TRANSLATION");
		System.out
				.println("Entrez le nombre de pixels de translation en largeur :");
		int dx = sc.nextInt();
		System.out
				.println("Entrez le nombre de pixels de translation en hauteur :");
		int dy = sc.nextInt();
		p.dupliqueForme(r);
		r.seTranslater(dx, dy);
		p.repaint();

		System.out.println("MODIFICATION");
		System.out.println("Entrez le nombre de pixels d'élargissement :");
		int dl = sc.nextInt();
		p.dupliqueForme(r);
		r.modifierLargeur(dl);
		p.repaint();

		System.out
				.println("Entrez le nombre de pixels de variation de la hauteur :");
		int dh = sc.nextInt();
		p.dupliqueForme(r);
		r.modifierHauteur(dh);
		p.repaint();

		System.out.println("ROTATION");
		new Scanner(System.in).nextLine();
		p.dupliqueForme(r);
		r.faireRotation();
		p.repaint();

		System.out.println("SYMETRIE");
		new Scanner(System.in).nextLine();
		p.dupliqueForme(r);
		r.faireSymetrie();
		p.repaint();

		// LE TRIANGLE
		System.out.println("CONSTRUCTION TRIANGLE");
		System.out.println("Entrez l'abscisse du premier sommet :");
		x = sc.nextInt();
		System.out.println("Entrez l'ordonnée du premier sommet :");
		y = sc.nextInt();
		UnPoint a = new UnPoint(x, y);
		System.out.println("Entrez l'abscisse du second sommet :");
		x = sc.nextInt();
		System.out.println("Entrez l'ordonnée du second sommet :");
		y = sc.nextInt();
		UnPoint b = new UnPoint(x, y);
		System.out.println("Entrez l'abscisse du troisième sommet :");
		x = sc.nextInt();
		System.out.println("Entrez l'ordonnée du troisième sommet :");
		y = sc.nextInt();
		UnPoint c = new UnPoint(x, y);
		UnTriangle t = new UnTriangle(a, b, c);
		p.ajouteForme(t);

		System.out.println("TRANSLATION");
		System.out
				.println("Entrez le nombre de pixels de translation en largeur :");
		dx = sc.nextInt();
		System.out
				.println("Entrez le nombre de pixels de translation en hauteur :");
		dy = sc.nextInt();
		p.dupliqueForme(t);
		t.seTranslater(dx, dy);

		System.out.println("CERCLE CIRCONSCRIT");
		new Scanner(System.in).nextLine();
		p.ajouteForme(new UnCercle(t));

		if (t.etreRectangle()) {
			System.out.println("Le triangle est rectangle");
		} else {
			System.out.println("Le triangle n'est pas rectangle");
		}

		// LE CERCLE
		System.out.println("CONSTRUCTION CERCLE");
		System.out.println("Entrez l'abscisse du centre :");
		x = sc.nextInt();
		System.out.println("Entrez l'ordonnée du centre :");
		y = sc.nextInt();
		System.out.println("Entrez son rayon :");
		int rayon = sc.nextInt();
		UnCercle cercle = new UnCercle(x, y, rayon);
		p.ajouteForme(cercle);

		System.out.println("TRANSLATION");
		System.out
				.println("Entrez le nombre de pixels de translation en largeur :");
		dx = sc.nextInt();
		System.out
				.println("Entrez le nombre de pixels de translation en hauteur :");
		dy = sc.nextInt();
		p.dupliqueForme(cercle);
		cercle.seTranslater(dx, dy);

		// END
		System.out.println("EXIT?");
		new Scanner(System.in).nextLine();
		sc.close();
		System.exit(0);
	}
}
