/**
 * permet de g�rer un maillon de la pile
 * une maillon possede une valeur et un lien vers le maillon suivant
 */
public class Maillon {

	/**
	 * la valeur stockee dans le maillon
	 */
	public int valeur;

	/**
	 * le lien vers le Maillon suivant
	 */
	public Maillon suivant;

	/**
	 * constructeur de Maillon
	 * @param element l'element stocke (de type entier)
	 * @param suiv le lien vers le maillon suivant
	 */
	public Maillon(int element,Maillon suiv)
	{
		this.valeur=element;
		this.suivant=suiv;
	}

	public int getValeur(){
		return this.valeur;
	}

	public Maillon getSuivant(){
		return this.suivant;
	}
}
