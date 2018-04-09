public class TypeCompte{

  //attributs

  private final static int CODE_CC=1; // code comptes chèques
  private final static int CODE_LEP=2; // code livret épargne populaire
  private final static int CODE_LDD=3; // code livret développement durable
  private int code; //code interne du type de compte
  private boolean estPlafonne; //si le compte est plafonné
  private int plafondDepot; // quel est le plafond de dépôt
  private boolean estCondRev; // s'il y a des conditions de revenu
  private int plafondRevenu; // quel est le montant du plafond des revenus
  public final static TyoeCompte CC= new TypeCompte(CODE_CC); //comptes chèques
  public final static TypeCompte LEP= new TypeCompte(CODE_LEP); // livret épargne populaire
  public final static TypeCompte LDD= new TypeCompte(CODE_LDD); // livret développement durable

//Constructeurs

public TypeCompte(int c) {
  this.code=c;
  switch(c){
    case CODE_CC:
      this.plafondDepot=15300;
      this.estPlafonne=true;
    break;
    case CODE_LEP:
      this.plafondDepot=7700;
      this.estPlafonne=true;
      this.plafondRevenu=757;
      this.estCondRev=true;
    break;
    case CODE_LDD:
      this.plafondDepot=6000;
      this.estPlafonne=true;
    break;
    }
  }

//Méthodes
public double donnerPlafondDepot() {
    if (this.estPlafonne){
      return this.plafondDepot;
    }else{
      return Double.MAX_VALUE;
    }
  }

public double donnerPlafondRevenus() {
  if(this.plafondRevenu){
    return this.plafondRevenu;
  }else{
    return Double.MAX_VALUE;
    }
  }

public static TypeCompte[] donnerTypesComptesPos(double aDeposer){
  TypeCompte[] t={CC,LEP,LDD};
  boolean[] ok= new boolean[t.length];
  int nbc=0;
  for(int i=0;i<t.length;i++){
    if(aDeposer < t[i].donnerPlafondDepot());
    ok[i]=true;
    nbc++;
    }
    TypeCompte[]t.res=new TypeCompte[nbc]{
    int j=0
    for(int i=0;i<t.length;i++)
      if(ok[i]);
        t.res[j]=t[i];
        j++;
      }
    return t.res;

}






}
