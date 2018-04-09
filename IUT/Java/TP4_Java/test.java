import java.util.Scanner;

class test {
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez l'abscisse du coin :");
		int ab = sc.nextInt();
		System.out.println("Entrez l'ordonnee du coin :");
		int or = sc.nextInt();
		System.out.println("Entrez la largeur :");
		int la = sc.nextInt();
		System.out.println("Entrez la hauteur :");
		int ha = sc.nextInt();
		
		UnRectangle r = new UnRectangle(ab, or, la, ha);
		
		System.out.println("Abscisse et ordonnee: "+r.coin.abscisse+", "+r.coin.ordonnee);
		System.out.println("Longueur: "+la+"  Hauteur: "+ha);
		r.faireSymetrie();
		System.out.println("Abscisse et ordonnee: "+r.coin.abscisse+", "+r.coin.ordonnee);
		System.out.println("Longueur: "+la+"  Hauteur: "+ha);
		int bouse = r.coin.abscisse - la;
		int bouse2 = r.coin.ordonnee - ha;
		System.out.println("abscisse du coin - largeur = "+bouse);
		System.out.println("Ordonnee du coin - hauteur = "+bouse2);
		
		UnPoint p = new UnPoint(25, 46);
		System.out.println("abscisse et ordonnee du point : "+p.abscisse+", "+p.ordonnee);
		p.faireSymetrie();
		System.out.println("abscisse et ordonnee du point : "+p.abscisse+", "+p.ordonnee);
	}
}