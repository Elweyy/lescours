public abstract class Personnage {
  private String nom;
  private int pv;


public Personnage(String n, int vie) {
  this.nom=n;
  this.pv=vie;
  }

}

public String toString() {
  if (this.pv>0) {
    String s="Je m'appelle"+this.nom+"et j'ai"+this.pv+"points de vie.";
    return s;
   }else{
    String s= this.nom+" est complétement mort.";
    return s;
   }
 }


 public String getNom() {
   return this.nom;
 }


 public boolean etreMort() {
   if ( pv >0) {
     return false;
   }else{
   return true;
    }
  }

  public int getVie(){
    return this.pv;
  }

  public void ajouterVie(int num){
    this.pv+=num;
  }

  public abstract void attaquer(Personnage p);

  public abstract int subirFrappe(int coup);

  public abstract int subirCharme(int coup);

}
