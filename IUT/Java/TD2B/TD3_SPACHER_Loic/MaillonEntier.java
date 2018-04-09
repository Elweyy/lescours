/**
 * permet de stocker un maillon de la liste chainee
 * un maillon possède sa valeur et la position du successeur
 *
 */
public class MaillonEntier {
	
	/**
	 * valeur du maillon
	 */
	private SousTitre val;
	
	/**
	 * indice où trouver le successeur du maillon courant
	 */
	private int suc;
	
	/**
	 * permet de construire un Maillon en précisant sa valeur
	 * et l'indice du successeur
	 *  
	 * @param v valeur contenue à cet endroit
	 * @param s indice ou trouver le suivant
	 */
	public MaillonEntier(SousTitre v, int s)
	{
		this.val=v;
		this.suc=s;
	}
	
	/**
	 * permet d'acceder à la valeur du maillon
	 * 
	 * @return valeur associee au maillon 
	 */
	public SousTitre getVal()
	{
		return(this.val);
	}
	
	/**
	 * modifie la valeur associée à ce maillon
	 * 
	 * @param st soustitre
	 */
	public void setVal(SousTitre st)
	{
		this.val=st;
	}
	
	/**
	 * permet d'acceder à l'indice du suivant de ce maillon
	 * 
	 * @return indice du suivant 
	 */
	public int getSuc()
	{
		return(this.suc);
	}
	
	/**
	 * permet de modifier le chainage dans la liste
	 * 
	 * @param i indice du Maillon suivant suivant 
	 */
	public void setSuc(int i)
	{
		this.suc=i;
	}

}
