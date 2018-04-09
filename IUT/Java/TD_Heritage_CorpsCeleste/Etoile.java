public class Etoile extends CorpsCeleste {

  private double temperature;
  private static final double K=1.414213;



  /**Retourne la classe du corps
  @return Classe du Corps
  */
  public String donnerNomClasseCorps() {
    return "Etoile"; // On ne met pas static puisqu'on veut modifier le résultat final
  }


/**
 * Constructeur de la classe Etoile
 * @param  String n             Nom de l'étoile
 * @param  double r             Rayon de l'étoile
 * @param  double m             Masse de l'étoile
 * @param  double t             Température de l'étoile
 */
  public Etoile(String n, double r, double m, double t){
    super(n,r,m);
    if(t<0){
      this.temperature=0.0;

    }else{
    this.temperature=t;
    }
    //le constructeur CorpsCeleste sert de base au constructeur Etoile, auquel on ajoute la variable température
  }



/**
 * Calcul l'énergie reçue par l'étoile
 * @param  double energie       Energie envoyée par l'étoile
 * @param  double distance      Distance de l'étoile
 * @return        energie
 */
  public double calculerEnergieRecue(double distance) {
    double energie;
    if (distance >0){
      energie=(this.K*this.temperature)/Math.pow(distance,2);
    }else{
     energie=0;
    }
    return energie;

  }


  /**
   * Retourne le contenu des attributs
   * @return le contenu des attributs
   */
public String toString(){
  String s;
  s=super.toString()+ "temperature en surface: "+this.temperature+" degres K";
  return s;
}






}
