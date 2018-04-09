

public class CorpsCeleste {

  private String nom;
  private double rayon;
  private double masse;

/**Constructeur par défaut d'un corps céleste:
@param String n Nom du Corps
@param double r Rayon du corps
@param double m Masse du Corps
*/
  public CorpsCeleste(String n, double r, double m){
    this.nom=n;
    this.rayon=r;
    this.masse=m;
    if(m<=0) this.masse=1;
    if(r<=0) this.rayon=1;
    if(n==null) this.nom="Inconnu";
  }


/**Retourne la classe du corps
@return Classe du Corps
*/

  public String donnerNomClasseCorps() {
    return "Corps céleste";
  }

/**Retourne la densité du corps
@return Densité du corps
*/

  public double calculerDensite() {
    double v=(4./3.)*Math.PI*(this.rayon*this.rayon*this.rayon);
    double d=this.masse/v;
    return d;
  }


/** Retourne le nom du corps
@return le nom du corps
*/
  public String rendreNom() {
    return this.nom;
  }

/**
 * Retourne le contenu des attributs
 * @return le contenu des attributs
 */
  public String toString() {
    String s;
    s="\n" +this.donnerNomClasseCorps()+ "\n"+ "De nom: "+this.nom+", de rayon: "+ this.rayon + "km, de masse: "+ this.masse+" tonnes,"+"\n"
    +"de densite: "+ this.calculerDensite()+" kg par m3, " ;
    return s;
  }

}
