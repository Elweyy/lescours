public class Client {
  private String nom, prenom;
  public final static int NB_MAX_COMPTES=10;
  private Compte[] comptes;
  private int nbComptes;
  private double impots;


//Constructeur
  public Client(String n, String p){
    if(n==null){
      this.nom="anonyme"
    }else{
    this.nom= new String(n)}
    if(p==null){
      this.prenom="anonyme"}
    else{
    this.prenom= new String(p)}
    this.comptes =new Compte[NB_MAX_COMPTES];
    this.nbComptes=0;
    this.impots=-1;
  }
//Méthodes
  public indiquerImpots(double IR ) {
    if (IR>0) {
      this.impots=IR;
    }else{
      this.impots=-1;
    }
  }
}
