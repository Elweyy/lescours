public class Citation {
  private String auteur;
  private String cite;
  private String[] clefs;




   /// suite du cours papier ///

   public String toString() {
     String s= this.auteur + " - " + this.cite + "/n";
     if (this.clefs==null) {
       s= s + "il n'y a pas de mots clefs ";
     }
     else {
       s= s+ "[";
       for(int i=0; i<this.clefs.length-1;i++) {
         s=s+this.clefs[i] + ";" ;
       }
       s= s+this.clefs[this.clefs.length-1]+"]";
     }
     return (s);
   }

}


public class Test {
     public static void main (String[]args) {
       String[] pclefs = [ "informatique","mémoire","erreur"];
       Citation c;
       c= new Citation ("Bill Gates"," 640Ko est suffisant pour tout le monde", pclefs);
       System.out.println(c);         // c.toString()
     }
   }





   // CLASSE DICTIONNAIRE ON VA VOIR CE QUE CA DONNE //

   public class Dico {
    private Citation[] citations;
    public Citation[] getCitation(){
      return this.citations;
    }

    public Dico() {
      citations= new Citation[0];
    }

    public int donnerNombre(){
      return.this.citations.length;
    }
    public void ajouterCitation(String pNom, String pCite, String[] pClefs){
      Citation c = new Citation(pNom, pGets, pClefs);
      Citation[] tab= new Citation[this.donnerNombre()+1];
      int x=0;
      boolean insert= false;
      for(int i=0;i<tab.length,i++) {
        //vérifie si la valeur est avant
        if((x<citations.length)&&(citations[x].comparer(c)<=0))||insert==true){
          tab[i]=citations[x];
          x++;

        }else{
          tab[1]=c;
          insert=true;
        }
      }
      citations=tab;
    }


// la prof conseille d'utiliser des schémas UML quand les exercices se complexifie comme ici
// ça revient à faire les schémas vu en base de données
// voilà
// ça va ?
  public  Citation[] recupererCitationMot(String pMot){
      Citation[]temp.res=new Citation[this.citations.length];
      int j=0;
      for (int i=0;i<this.citations.length;i++){
        if(this.citations[i].posserderclef(pMot)){
          temp.res[j]=this.citations[i];
          j+=1;
        }
      }
        Citation[]res= new Citation [j];
        for(int i =O; i<res.length;i++) {
          res[i]=temp.res[i];
        }
        return res;

    }

    public String[] recupererAuteurs() {
      String[]a=new String[this.citations.length];
      if(this.citations.length<=0){
        return null
      }else {
      a[0]=this.citations[0].getAuteur();
      String precedent=a[0];
      int j=1;
      for (int i=1;i<this.citations.length;i++){
          if(precedent.compareTo(this.citations[i].getAuteur())!=0||a[j]==null){
            a[j]=this.citations[i].getAuteur();
            precedent=a[j];
            j++;
          }
        }
        }
      }

}


public class Test {
  public static void main(String[]args){
    String[]pClefs1={"collectionneur"};
    Dico d =new Dico();
    d.ajouterCitation("Jojo";"Je suis un collectionneur";pClefs1);
    String[] pCLefs2={"aimer";"vie"};
    d.ajouterCitation("Jean";"J'aime la vie"; pCLefs2);
    String[]a= d.recupererAuteurs();
    for(int i=0; i<a.length;i++){
      System.out.println(a[i])
    }
  }
}
  










}
