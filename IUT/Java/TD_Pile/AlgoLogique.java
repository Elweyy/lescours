/**
 * algorithme logique qui utilise des Piles
 */
public class AlgoLogique {
	
	public static void main(String[]args)
	{
		//probleme notation polonaise inversee
		String[] valeurs={"12","38","+","2","-","."};
		
		Postfixe postfixe=new Postfixe();
		int resultat=postfixe.evaluer( valeurs);
		System.out.println("le resultat doit etre 48: "+resultat);
	}
}
