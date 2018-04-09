public class TexteDocument extends GenererDocument {

  public void genererEntete(ContenuTexte texte){

    int n = texte.getTitre().length();
    for (int i = 0; i < n; i++){
      System.out.print('-');
    }
    System.out.println("-"+texte.getTitre()+"-");
    for (int i = 0; i < n; i++){
      System.out.print('-');
    }

  }



  public void genererFooter(ContenuTexte texte){

    System.out.println("---"+texte.getAuteur()+"---");

  }

}
