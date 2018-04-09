/**
 * classe UnRectangle permet de modeliser des rectangles
 *
 * Un rectangle est defini par
 * 		- un coin bas-gauche
 * 		- une largeur
 * 		- et une hauteur
 */

class UnRectangle {
	/**
	 * attribut le coin bas-gauche du rectangle
	 */
	UnPoint coin;

	/**
	 * attributs largeur et hauteur du rectangle
	 */
	int largeur, hauteur;

	UnRectangle(){
		this.largeur=1;
		this.hauteur=1;
		this.coin=new UnPoint();
	}

	UnRectangle(int l,int h){
		this.coin= new UnPoint ();
		if (l<=0){
			this.largeur=1;
	}
		else{
			this.largeur=1;
	}
		if (h<=0){
		this.hauteur=-h;}
		else{
 		this.hauteur=h;
	}}

	UnRectangle( int l, int h, int x, int y ) {
		if (l<=0){
		this.largeur=1;}
		else{
			this.largeur=1;
		}
		if (h<=0){
		this.hauteur=-h;}
		else{
			this.hauteur=h;
		}
		this.coin= new UnPoint(x,y);
	// TODO a completer
	}

	UnRectangle(UnPoint c) {
	 if(c==null)
	 	this.coin= new UnPoint();
 	 else{
	  //this.coin= c;
		//this.coin.abscisse= c.abscisse
		//this.coin.ordonnee= c.ordonnee pas possible tout ça
		this.coin= new UnPoint(c);
 	}
	 this.largeur=1;
	 this.hauteur=1;
}


	UnRectangle(UnPoint c, int l,int h) {
		if(c==null)
		 this.coin= new UnPoint();
		else{
			this.coin= new UnPoint(c);
		}
		this.largeur=l;
		this.hauteur=h;
	}

	UnRectangle( UnRectangle r) {
		if (r==null){
			this.coin= new UnPoint();
			this.largeur= 1;
			this.hauteur=1;
		}
		else{
			this.coin= new UnPoint(r.coin.abscisse,r.coin.ordonnee);
			this.largeur= r.largeur;
			this.hauteur= r.hauteur;

			 }
		}
}
