/**
 * classe UnRectangle
 * modelise des rectangles
 */
class UnRectangle {

	/**
	 * attribut coin bas-gauche du rectangle
	 */
	UnPoint coin;

	/**
	 * attributs dimension du rectangle
	 */
	int largeur, hauteur;

	/**
	 * constructeur vide - rectangle unitaire (TD3)
	 */
	UnRectangle() {
		this.coin = new UnPoint();
		this.largeur = 1;
		this.hauteur = 1;
	}

	/**
	 * constructeur de rectangle a partir d'un point et des dimensions
	 * (TD3)
	 *
	 * @param cig
	 *            coin inferieur gauche
	 * @param l
	 *            largeur
	 * @param h
	 *            hauteur
	 */
	UnRectangle(UnPoint cig, int l, int h) {
		if (cig == null)
			this.coin = new UnPoint();
		else
			this.coin = new UnPoint(cig.abscisse, cig.ordonnee);
		if (l < 1)
			this.largeur = 1;
		else
			this.largeur = l;
		if (h < 1)
			this.hauteur = 1;
		else
			this.hauteur = h;
	}



	/**
	 * constructeur de rectangle a partir de 4 entiers
	 *
	 * @param x
	 *            abscisse coin bas gauche
	 * @param y
	 *            abscisse coin bas droite
	 * @param l
	 *            largeur du rectangle
	 * @param h
	 *            hauteur du rectangle
	 */
	UnRectangle(int x, int y, int l, int h) {
		this.coin = new UnPoint(x, y);
		if (l < 1)
			this.largeur = 1;
		else
			this.largeur = l;
		if (h < 1)
			this.hauteur = 1;
		else
			this.hauteur = h;
	}

	/**
	 * constructeur par copie de rectangle
	 * (mis a l'origine si reference nulle)
	 *
	 * @param r
	 *            rectangle a copier
	 */
	UnRectangle(UnRectangle r) {
		if (r != null) {
			this.coin = new UnPoint(r.coin);
			this.largeur = r.largeur;
			this.hauteur = r.hauteur;
		} else {
			this.coin = new UnPoint();
			this.largeur = 1;
			this.hauteur = 1;
		}
	}



	/**
	 * methode qui demande translation du rectangle
	 * cela revient a translater son coin
	 *
	 * @param dx
	 *            variation selon axe abscisse
	 * @param dy
	 *            variation selon ax des ordonnees
	 */
	void seTranslater(int dx, int dy) {
		this.coin.seTranslater(dx, dy);
	}

	/**
	* methode qui modifier la largeur du rectangle
	*
	* @param dl
	*			valeur ajoutée à l'attribut largeur
	*/
	void modifierLargeur(int dl) {
		if (this.largeur + dl <= 0) {
			this.largeur = 1;
		} else {

			this.largeur += dl;
		}
	}

	/**
	* methode qui modifie la hauteur du rectangle
	*
	* @param dh
	*			valeur ajoutée à l'attribut hauteur
	*/
	void modifierHauteur(int dh) {
		if (this.hauteur + dh <= 0) {
			this.hauteur = 1;
		} else {
		this.hauteur += dh;
		}
	}

	/**
	* methode qui effectue une rotation sur le rectangle
	*
	*/
	void faireRotation () {
		int prevHauteur = this.hauteur;
		int prevLargeur = this.largeur;
		this.largeur = prevHauteur;
		this.hauteur = prevLargeur;
		this.coin.abscisse -= this.largeur;
	}

	/**
	* methode qui créer le symétrique du rectangle par rapport à la droite y = x
	*
	*/
	void faireSymetrie() {
		this.coin.faireSymetrie();
		int tmp = this.hauteur;
		this.hauteur = this.largeur;
		this.largeur = tmp;
		this.coin.abscisse -= this.largeur;
		this.coin.ordonnee += this.hauteur;
	}
}
