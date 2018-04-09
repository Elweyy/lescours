public class Monstre extends Personnage{


  public Monstre( String n, int vie) {
    super(n,vie);
  }

  public void attaquer(Personnage p){
    int blessure= p.subirFrappe(this.getVie()/2);
    this.ajouterVie(-blessure);
  }

  public int subirFrappe(int coup){
    int blessure= this.getVie()/2;
    this.ajouterVie(-coup);
    return blessure;
  }

  public int subirCharme(int coup){
    int gain = this.getVie()/2
    this.ajouterVie(-coup);
    return blessure;
  }














}
