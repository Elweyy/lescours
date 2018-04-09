public class CorpsRevolution extends CorpsCeleste {

  private double rayonOrbital;
  private CorpsCeleste centreRevolution;



/**
 * Retourne le rayon orbital
 * @return rayon orbital
 */
  public double rendreRayonOrbital(){
      return this.rayonOrbital;
  }


  /**Retourne la classe du corps
  @return Classe du Corps
  */
  public String donnerNomClasseCorps(){
    return "Corps Revolution";
  }



/**
 * Constructeur de corps révolution
 * @param  String       n             Nom du corps
 * @param  double       r             Rayon du corps
 * @param  double       m             Masse du corps
 * @param  double       rO            Rayon orbital
 * @param  CorpsCeleste cR            Corps révolution
 */
  public CorpsRevolution(String n, double r, double m,double rO, CorpsCeleste cR){
    super(n,r,m);
    if(rO<1) {
      this.rayonOrbital=1;
    }else{
      this.rayonOrbital=rO;
    }
    if(cR ==null){
      this.centreRevolution= new CorpsCeleste("",1,1);
    }else{
      this.centreRevolution=cR;
    }
  }


/**
 * Retourne le centre révolution du corps céleste
 * @return le centre de révolution
 */
  public CorpsCeleste tournerAutourDe(){
    return this.centreRevolution;
  }


  /**
   * Retourne le contenu des attributs
   * @return le contenu des attributs
   */
  public String toString(){
    String s;
    s= super.toString()+"\n"+"effectue des revolutions a une distance de:"+ this.rayonOrbital +"millions de km"+"\n"
    +"autour du corps celeste: " + this.tournerAutourDe().rendreNom()
    +", qui est un corps de type "+ this.centreRevolution.donnerNomClasseCorps();
    return s;
  }
}
