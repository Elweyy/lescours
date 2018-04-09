public class Planete extends CorpsRevolution {


/**
 * Constructeur de la planète
 * @param  String       n             Nom de la planète
 * @param  double       r             Rayon de la planète
 * @param  double       m             Masse de la planète
 * @param  double       rO            Rayon orbital de la planète
 * @param  CorpsCeleste cR            Centre de révolution de la planète
 */
  public Planete(String n, double r, double m,double rO, CorpsCeleste cR){
    super(n,r,m,rO,cR);
  }



/**
 * Vérifie si deux corps ont le même Soleil
 * @param  CorpsRevolution JCVD          Corps à comparer
 * @return                 Booléen : vrai si même soleil, faux si soleil différent
 */
  public boolean avoirMemeSoleil(CorpsRevolution JCVD){
    if(JCVD.tournerAutourDe()==this.tournerAutourDe()){
      return true;
    }else{
      return false;
    }

  }


  /**Retourne la classe du corps
  @return Classe du Corps
  */
  public String donnerNomClasseCorps(){
    return "Planete";
  }


  /**
   * Retourne le contenu des attributs
   * @return le contenu des attributs
   */
  public String toString(){
    String s;
    s=super.toString();
    return s;
  }


}
