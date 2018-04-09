class UnRectangle 
{
	UnPoint coin;
	int largeur, hauteur;

	UnRectangle()
	{
		this.coin = new UnPoint();
		this.largeur = 1;
		this.hauteur = 1;
	}
	UnRectangle(int l, int h)
	{
		this.coin = new UnPoint();
		if (l<=0)
		{
			this.largeur = 1;
		} else {
			this.largeur = l;
		}
		if (h<=0)
		{
			this.hauteur = 1;
		} else {
			this.hauteur =  h;
		}
	}
	UnRectangle(int x, int y, int l, int h)
	{
		this.coin = new UnPoint(x,y);
		if (l<=0)
		{
			this.largeur = 1;
		} else {
			this.largeur = l;
		}
		if (h<=0)
		{
			this.hauteur = 1;
		} else {
			this.hauteur =  h;
		}
	}
	UnRectangle(UnPoint p)
	{
		this.coin = new UnPoint(p);
		this.largeur = 1;
		this.hauteur = 1;
	}
	UnRectangle(UnPoint p, int l, int h)
	{
		this.coin = new UnPoint(p);
		if (l<=0)
		{
			this.largeur = 1;
		} else {
			this.largeur = l;
		}
		if (h<=0)
		{
			this.hauteur = 1;
		} else {
			this.hauteur =  h;
		}
	}
	UnRectangle(UnRectangle r)
	{
		if (r==null)
		{
			this.coin = new UnPoint();
			this.largeur = 1;
			this.hauteur = 1;
		} else {
			this.coin = new UnPoint(r.coin.abscisse,r.coin.ordonnee);
			this.largeur = r.largeur;
			this.hauteur = r.hauteur;
		}
	}
}