class MainConstructeursRectangles {
	public static void main( String [] args) 
	{
		UnRectangle r1 , r2 , r3 , r4 , r5 , r6;
		r1 = new UnRectangle ();
		r2 = new UnRectangle (100 , 45);
		r3 = new UnRectangle (new UnPoint (10 , 20));
		r4 = new UnRectangle (new UnPoint (25 , 300) , 10, 65);
		r5 = new UnRectangle (140 , -170, 20, -70);
		r6 = new UnRectangle (r5 );
	}
 }