public class ContenuTexte {

  private String titre;
  private String corps;
  private String auteur;

  public ContenuTexte(String t, String c, String a){
    this.titre=t;
    this.corps=c;
    this.auteur=a;
  }

  public String getTitre(){
    return this.titre;
  }

  public String getCorps(){
    return this.corps;
  }

  public String getAuteur(){
    return this.auteur;
  }

  public void setTitre( String t){
    this.titre=t;
  }

  public void setCorps(String c){
    this.corps=c;
  }

  public void setAuteur(String a){
    this.auteur=a;
  }



}
