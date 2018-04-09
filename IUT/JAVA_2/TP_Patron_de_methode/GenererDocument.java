public abstract class GenererDocument{

   public abstract void genererEntete( ContenuTexte texte);

   public void genererCorps( ContenuTexte texte){

     System.out.println(texte.getCorps());

   }

   public abstract void genererFooter( ContenuTexte texte);

   public  void genererDocument( ContenuTexte texte){

     this.genererEntete(texte);
     this.genererCorps(texte);
     this.genererFooter(texte);
   }




}
