public class HtmlDocument extends GenererDocument {


  public void genererEntete(ContenuTexte texte){

    System.out.println("<html><body>");
    System.out.println("<h1>"+texte.getTitre()+"</h1>");

  }

  public void genererCorps(ContenuTexte texte){

      //System.out.println("<p>"+"\n"+texte.getCorps()+"\n"+"</p>");        ça marche aussi mais c'est la méthode d'Elise
      System.out.println("<p>");
      super.genererCorps(texte);
      System.out.println("</p>");


  }

  public void genererFooter(ContenuTexte texte){

    System.out.println("<h4>"+texte.getAuteur()+"</h4>");
    System.out.println("</body>"+"\n"+"</html>");
  }

}
