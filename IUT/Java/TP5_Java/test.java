class test {
	public static void main (String [] Args) {
	UnTriangle t = new UnTriangle(new UnPoint(100,0), new UnPoint(0,100), new UnPoint(0,0));
	
	
	System.out.println(t.A.abscisse+" "+t.A.ordonnee+"||"+t.B.abscisse+" "+t.B.ordonnee+"||"+t.C.abscisse+" "+t.C.ordonnee+" ");
	UnPoint c = t.calculerCentreCercleCirconscrit();
	System.out.println("le centre du cercle circonscrit au triangle a pour coordonees : ("+c.abscisse+","+c.ordonnee+")");
	System.out.println("le rayon du cercle circonscrit au triangle est : "+t.calculerRayonCercleCirconscrit());
	}
}