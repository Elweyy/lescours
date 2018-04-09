import java.util.Scanner;

/****************************************
 * classe Programme Version 2 - TP5
 *****************************************/

class Programme {
	public static int demandeAction(Plan2D p, UnRectangle r) {
		System.out.println("Voulez-vous :");
		System.out.println("   1 - translater ce rectangle ?");
		System.out.println("   2 - élargir ce rectangle ?");
		System.out.println("   3 - augmenter la hauteur de ce rectangle ?");
		System.out
				.println("   4 - le tourner de 90 degrés à gauche autour de son coin inférieur gauche ?");
		System.out
				.println("   5 - transformer ce rectangle en son symétrique par rapport à y=x ?");
		System.out.println("   6 - dupliquer ?");
		System.out.println("   0 - RIEN ?");

		Scanner sc = new Scanner(System.in);

		int rep = sc.nextInt();
		if (rep == 1) {
			System.out
					.println("Entrez le nombre de pixels de translation en largeur :");
			int dx = sc.nextInt();
			System.out
					.println("Entrez le nombre de pixels de translation en hauteur :");
			int dy = sc.nextInt();
			r.seTranslater(dx, dy);
		}
		if (rep == 2) {
			System.out.println("Entrez le nombre de pixels d'élargissement :");
			int dl = sc.nextInt();
			r.modifierLargeur(dl);
		}
		if (rep == 3) {
			System.out
					.println("Entrez le nombre de pixels de variation de la hauteur :");
			int dh = sc.nextInt();
			r.modifierHauteur(dh);
		}
		if (rep == 4) {
			r.faireRotation();
		}
		if (rep == 5) {
			r.faireSymetrie();
		}
		if (rep == 6) {
			p.dupliqueForme(r);
		}

		sc.close();
		return rep;
	}

	public static int demandeAction(Plan2D p, UnTriangle t) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Voulez-vous :");
		System.out.println("   1 - translater ce triangle ?");
		System.out.println("   2 - visualiser son cercle circonscrit ?");
		System.out.println("   3 - tester si rectangle ?");
		System.out.println("   4 - dupliquer ?");
		System.out.println("   0 - RIEN ?");
		int rep = sc.nextInt();
		if (rep == 1) {
			System.out
					.println("Entrez le nombre de pixels de translation en largeur :");
			int dx = sc.nextInt();
			System.out
					.println("Entrez le nombre de pixels de translation en hauteur :");
			int dy = sc.nextInt();
			t.seTranslater(dx, dy);
		}
		if (rep == 2) {
			p.ajouteForme(new UnCercle(t));
		}
		if (rep == 3) {
			if (t.etreRectangle()) {
				System.out.println("Le triangle est rectangle");
			} else {
				System.out.println("Le triangle n'est pas rectangle");
			}
		}
		if (rep == 4) {
			p.dupliqueForme(t);
		}
		sc.close();
		return rep;
	}

	public static int demandeAction(Plan2D p, UnCercle c) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Voulez-vous :");
		System.out.println("   1 - translater ce cercle ?");
		System.out.println("   2 - dupliquer ?");
		System.out.println("   0 - RIEN ?");
		int rep = sc.nextInt();
		if (rep == 1) {
			System.out
					.println("Entrez le nombre de pixels de translation en largeur :");
			int dx = sc.nextInt();
			System.out
					.println("Entrez le nombre de pixels de translation en hauteur :");
			int dy = sc.nextInt();
			c.seTranslater(dx, dy);
		}
		if (rep == 2) {
			p.dupliqueForme(c);
		}
		sc.close();
		return rep;
	}

	public static int demandeAjout(Plan2D p) {
		int x, y, l, h, r;
		int rep, rep2;

		Scanner sc = new Scanner(System.in);
		System.out.println("Voulez-vous construire :");
		System.out.println("   1 - un rectangle ?");
		System.out.println("   2 - un triangle ?");
		System.out.println("   3 - un cercle ?");
		System.out.println("   0 - EXIT ?");
		rep = sc.nextInt();
		if (rep == 1) {
			System.out.println("Entrez son abscisse :");
			x = sc.nextInt();
			System.out.println("Entrez son ordonnée :");
			y = sc.nextInt();
			System.out.println("Entrez sa largeur :");
			l = sc.nextInt();
			System.out.println("Entrez sa hauteur :");
			h = sc.nextInt();
			UnRectangle rectangle = new UnRectangle(x, y, l, h);
			p.ajouteForme(rectangle);
			rep2 = 1;
			while (rep2 != 0) {
				rep2 = demandeAction(p, rectangle);
				p.repaint();
			}
		}
		if (rep == 2) {
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
			UnTriangle triangle = new UnTriangle(a, b, c);
			p.ajouteForme(triangle);
			rep2 = 1;
			while (rep2 != 0) {
				rep2 = demandeAction(p, triangle);
				p.repaint();
			}
		}
		if (rep == 3) {

			System.out.println("Voulez-vous donner :");
			System.out.println("   1 - le centre et le rayon ?");
			System.out.println("   2 - le triangle ?");
			rep = sc.nextInt();

			if (rep == 1) {
				System.out.println("Entrez l'abscisse du centre :");
				x = sc.nextInt();
				System.out.println("Entrez l'ordonnée du centre :");
				y = sc.nextInt();
				System.out.println("Entrez son rayon :");
				r = sc.nextInt();
				UnCercle cercle = new UnCercle(x, y, r);
				p.ajouteForme(cercle);
				rep2 = 1;
				while (rep2 != 0) {
					rep2 = demandeAction(p, cercle);
					p.repaint();
				}
			} else {
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

				UnCercle cercle = new UnCercle(new UnTriangle(a, b, c));
				p.ajouteForme(cercle);
				rep2 = 1;
				while (rep2 != 0) {
					rep2 = demandeAction(p, cercle);
					p.repaint();
				}
			}
		}
		if (rep != 0) {
			System.out.println("###  ajout effectué  ###");
		}
		System.out.println("\n\n");
		sc.close();
		return rep;

	}

	public static void main(String args[]) {
		Plan2D plan = new Plan2D();
		int rep = 1;
		while (rep != 0) {
			rep = demandeAjout(plan);
		}
		System.exit(0);
	}
}
