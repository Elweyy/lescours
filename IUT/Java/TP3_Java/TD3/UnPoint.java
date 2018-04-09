
class UnPoint
{

	int abscisse, ordonnee;

	UnPoint()
	{
		this.abscisse = 0;
		this.ordonnee = 0;
	}

	UnPoint(int a, int o)
	{
		this.abscisse = a;
		this.ordonnee = o;
	}

	UnPoint(UnPoint p)
	{
		if (p==null)
		{
			this.abscisse = 0;
			this.ordonnee = 0;
		} else {
			this.abscisse = p.abscisse;
			this.ordonnee = p.ordonnee;
		}
	}
}
