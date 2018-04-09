public class Satellite extends CorpsRevolution {


/**
 * Constructeur du satellite
 * @param  String       n             Nom du satellite
 * @param  double       r             Rayon du satellite
 * @param  double       m             Masse du satellite
 * @param  double       rO            Rayon orbital du satellite
 * @param  CorpsCeleste cR            Corps de révolution du satellite  
 */
  public Satellite(String n, double r, double m,double rO, CorpsCeleste cR){
    super(n,r,m,rO,cR);
  }


  /**Retourne la classe du corps
  @return Classe du Corps
  */
  public String donnerNomClasseCorps(){
    return "Satellite";
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
