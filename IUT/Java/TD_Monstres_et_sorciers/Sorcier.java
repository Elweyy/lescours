public class Sorcier extends Personnage {


  public Sorcier( String n, int vie) {
    super(n,vie);
  }

  public void attaquer(Personnage p, double powr){
    int blessure= p.subirFrappe((this.getVie()/2)*pwr);
    p.ajouterVie(-blessure);
    this.pv+=p.getVie();

}


public int subirFrappe(int coup){
  int blessure= this.getVie()/2;
  this.ajouterVie(-coup);
  return blessure;
  }


}
