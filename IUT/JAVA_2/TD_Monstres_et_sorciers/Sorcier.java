public class Sorcier extends Personnage {

  private double pouvoir;

  public Sorcier( String n, int vie) {
    super(n,vie);
    this.pouvoir=Math.random();
  }

  public void attaquer(Personnage p){
    this.pouvoir=Math.random();
    this.getVie(p.subirCharme((int)((this.getVie()/2)*this.getPouvoir());
  }


  public int subirFrappe(int coup){
    return this.ajouterVie(-coup);
  }

  public int subirCharme(int coup){
    return 0;
  }

  public double getPouvoir(){
    return this.pouvoir;
  }

}
