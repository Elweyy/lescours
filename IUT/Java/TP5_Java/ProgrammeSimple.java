import java.util.Scanner;

/****************************************
 * classe Programmesimple Version 2 - TP5
 *****************************************/

class ProgrammeSimple {
	public static void main(String args[]) {
		
		Scanner sc=new Scanner(System.in);
		Plan2D p = new Plan2D();

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

		// END
		System.out.println("EXIT?");
		new Scanner(System.in).nextLine();
		sc.close();
		System.exit(0);
	}
}
