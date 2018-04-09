package application;

/**
 * Classe qui modelise un robot
 * 
 */

public class Robot {
	String nom;
	int posX;
	Outil outil;
	int pv;
	
	/**
	 * Constructeur de robot par défaut
	 * @Valeurs par défaut
	 * @param nom
	 *	="HAL"
	 * @param posX
	 *	=0
	 * @param pv
	 *	=5
	 * @param outil
	 *	=null
	*/
	
	public Robot(){
		this.nom="HAL";
		this.posX=0;
		this.pv=5;
		this.outil=null;
	}
	
	/**
	 * Constructeur de robot avec attributs
	 * 
	 * @param pNom
	 * Nom du Robot
	 * @param depart
	 * position de départ du robot         
	 */
	
	public Robot(String pNom,int depart){
		this.nom=pNom;
		if (depart<0 || depart>10) this.posX=0;
		else{
			this.posX=depart;
		}
		this.pv=5;
		this.outil=null;
	}
	
	/**
	* Teste si le robot peut prendre l'outil et lui affecte si oui
	*/
	
	public boolean prendreOutil(Outil pOutil){
		if(this.outil==null && pOutil.porteur==null){
			this.outil=pOutil;
			pOutil.etrePris(this);
			return true;
		}
		return false;
	}
		
	/**
	* Renvoie l'outil que porte le robot
	*/
	
	public Outil getOutilPorte(){
		return this.outil;
	}
	
	/**
	* Renvoie le nom du robot
	*/
	
	public String getNom(){
		return this.nom;
	}
	
	/**
	* Renvoie la position du robot
	*/
	
	public int getPosX(){
		return this.posX;
	}
	
	/**
	 * renvoie le nombre de PV du Robot
	 */
	
	public int getPv(){
		return this.pv;
	}

/**
 * permet au robot d'attaquer en fonction de son outil	
 * @param victime
 * 
 */
	public boolean attaquer(Robot victime) {
		int distance=Math.abs(victime.posX-this.posX);
		if(this.etreDetruit()==false){
			if (this.outil==null && distance<=1){
				victime.subirDegat(1);
				return true;
			}
			if (this.outil!=null && this.outil.getPortee()>=distance){
				victime.subirDegat(this.outil.getDegats());
				return true;
			}
		}
		return false;
	}

	

	/**
	 *permet au robot de déposer un outil 
	 * @return
	 */
	public boolean deposerOutil() {
		if(this.outil!=null){
			this.outil.etreDepose();
			this.outil=null;
			return true;
		}
		return false;
	}
	
	/*
	 * permet de savoir si le robot est détruit
	 */
	public boolean etreDetruit() {
		if (this.pv==0){
			return true;
		}
		return false;
	}
	/**
	 * Permet au robot de se déplacer et vérifie qu'il ne dépasse les limites de la zone
	 * Met également à jour la position de l'outil
	 * @param i
	 */
	public void seDeplacer(int i) {
		if (this.etreDetruit()==false){
		if (this.posX+i<0){
			this.posX=0;		
		}
		else if (this.posX+i>10){
			this.posX=10;
		}
		else{
			this.posX+=i;
		}
		}
	}
	/**
	 * Fait subir des dégats au robot
	 * @param degat
	 */
	public void subirDegat(int degat){
		if (degat>0){
			this.pv-=degat;
			if (this.pv<0) this.pv=0;
		}
	}
	
	/**
	 * affiche les caractéristiques du robot et de son outil
	 */
	public String toString(){
		if (this.outil==null){
			return ("robot("+this.nom+":"+this.pv+")");	
		}
		return ("robot("+this.nom+":"+this.pv+")"+ this.outil.toString());
	}
	
}
