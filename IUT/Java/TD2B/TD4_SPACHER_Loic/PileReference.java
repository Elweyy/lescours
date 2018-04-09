public class PileReference implements Pile{

  private Maillon tete;






  public PileReference(){
    this.tete = null;
  }






  public void empiler(int p){
    if (this.estVidePile()) {
      this.tete = new Maillon(p, null);
    }
    else {
      Maillon previous = tete;
      this.tete=new Maillon(p, previous);
    }
  }






  public void depiler(){
    if (!this.estVidePile()) {
      tete = tete.getSuivant();
    }





  }

  public boolean estVidePile(){
    boolean res = false;
    if (tete==null) {
      res = true;
    }
    return res;
  }






  public int sommet(){
    return (tete.getValeur());
  }
}
