package application;

/**
 * modelise un outil transportable par un robot
 *
 */


/**
* Classe Outil   
* @param degats
*dégats de l'outil
* @param portee
*portée de l'outil
* @param posX
*position de l'outil
* @param porteur
*définit le porteur de l'outil
**/        
public class Outil {
	int degats;
	int portee;
	int posX;
	Robot porteur;
	
	/**
	 * Constructeur d'outil vide
	 * @Valeurs par défaut
	 * @param degats
	 *	=2
	 * @param portee
	 *	=2
	 * @param posX
	 *	=2
	 * @param porteur
	 *	=null
	*/
	
	public Outil(){
		this.degats=2;
		this.portee=2;
		this.posX=5;
		this.porteur=null;
	}
	
	/**
	 * Constructeur d'outil avec attributs
	 * 
	 * @param x
	 * position de l'outil
	 * @param degat
	 * degats de l'outil
	 * @param port
	 * portee de l'outil        
	 */
	
	public Outil(int x,int degat,int port){
		this.degats=degat;
		this.portee=port;
		this.posX=x;
		if (x<0 || x>10) this.posX=0;	
		if (degat<0) this.degats=0;	
		if (port<0) this.portee=0;		
		this.porteur=null;
	}
	
	/**
	 * Methode permettant de mettre a jour la position de l'outil
	 * porté par un Robot
	 * 	
	 */
	public void changerPosition(){
		if (this.porteur!=null){
			this.posX=this.porteur.getPosX();
		}
		
	}
	
	/**
	 * permet de vérifier si l'outil peut être pris par le Robot "Porteur"
	 * si oui, affecte l'outil au robot
	 */
	
	public boolean etrePris(Robot robot){
		if(this.porteur==null && this.posX==robot.getPosX()){
			this.porteur=robot;
			return true;	
		}
		else{
			return false;
		}
	}
	
	
	/**
	 * permet de vérifier si l'outil peut être déposé 
	 * si oui, depose l'objet à la position du robot
	 */
	public boolean etreDepose(){
		if(this.porteur!=null){
			this.posX=this.porteur.getPosX();
			this.porteur=null;
			return true;	
		}
		else{
			return false;
		}
	}
	
	/**
	 * Affiche les caractéristiques de l'outil
	 * @param dégats
	 * @param portée
	 */
	public String toString(){
		return ("-outil(d:"+this.degats+",p:"+this.portee+")");
	}
	
	/**
	 * Renvoie les dégâts de l'outil
	 */

	public int getDegats(){
		return this.degats;
	}
	
	/**
	 * Renvoie la portée de l'outil
	 */
	
	public int getPortee(){
		return this.portee;
	}
	
	/**
	 * Renvoie la position de l'outil
	 */
	
	public int getPosX(){
		return this.posX;
	}
	
	/**
	 * Renvoie le robot porteur de l'outil
	 */
	
	public Robot getPorteur(){
		return this.porteur;
	}
	
	
	
}
