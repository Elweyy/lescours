public class Compte {
  private  int numero;
  private static int nbCompte=0;
  private  Client titulaire;
  private TypeCompte type;
  private double solde;
  public Compte(TypeCompte tc, Client cl) {
    if (cl==null){
      this.titulaire=null;
      this.type=null;
      this.numero=-1;
      this.solde=0;
    }else{
      this.numero=Compte.nbCompte;
      Compte.nbCompte++;
      this.solde=0;
      this.titulaire=cl;
      if(cl==null){
        this.type=TypeCompte.CC;

      }else{
        this.type=tc;
      }
    }
  }

public int getNumero(){
  return this.numero;
  }

public double faireDepot(double somme){
  if(somme+this.solde<this.type.donnerPlafondDepot){
    this.solde=somme+this.solde;
    }
  if(somme+this.solde>this.type.donnerPlafondDepot){
    this.solde=this.type.donnerPlafondDepot;
    res=this.type.donnerPlafondDepot-this.solde;
    }
    return res;
  }


public double faireRetrait(double somme){
  if(somme=<this.solde){
  this.solde=this.solde-somme;
      }
  if(somme>this.solde){

    somme=this.solde;
    this.solde=0;
    return somme;
    }

  }

}
