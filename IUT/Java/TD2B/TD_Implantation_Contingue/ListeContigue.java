public class ListeContigue implements Liste {

  private SousTitre[] tab;
  private int nbElements;


  public ListeContigue(int tailleMax) {

	  this.tab= new SousTitre[tailleMax];
	  this.nbElements=0;
  }

  /**
   * permet de supprimer un element d'une liste
   * @param p place de l'element  supprimer
   */
  public  void suplis(int p){
	  this.nbElements--;
      for(int i = p; i < this.nbElements ; i++){

          this.tab[i] = this.tab[i+1];
      }
      this.tab[this.nbElements] = null;
  }

  /**
   * ajoute un element en tete de Liste
   * @param s Element a ajouter en tete
   */
  public  void adjtlis(SousTitre s){
	  if(this.nbElements + 1 <= this.tab.length){

          this.nbElements++;
          if(this.nbElements > 0){

              for(int i = this.nbElements - 2; i >= 0 ; i--){

                  this.tab[i+1] = this.tab[i];
              }
          }

          this.tab[0] = s;
      }
  }



  /**
   * ajoute un element a un endroit quelconque dans la liste
   * @param p place apres laquelle inserer
   * @param s element a inserer
   */
  public  void adjlis(int p, SousTitre s){
	  if(this.nbElements + 1 <= this.tab.length)
      {
          this.nbElements++;
          for(int i = this.nbElements -2 ; i > p ; i--)
          {
              this.tab[i+1] = this.tab[i];
          }

          this.tab[p+1] = s;
      }
  }



  /**
   * permet de savoir si on se trouve en fin de liste
   * @param p place où on se trouve
   * @return true si et seuelement si p est fin de liste
   */
  public  boolean finliste(int p){
	  return (p >= this.nbElements);
  	}



  /**
   * retourne la premiere place de la liste
   * @return tete de liste
   */
  public  int tete(){
	  return 0;
  	}


  /**
   * permet de connaitre la place suivante dans la liste
   * @param p place en cours
   * @return place derrière p dans la liste
   */
  public  int suc(int p){
    if ((p<0)||(p> tab.length-1)) {
      return -1;
    }else {
      return p+1;
    }
  }


  /**
   * retourne la valeur associee a la place p
   * @param p place de la liste
   * @return la valeur associee a p
   */
  public  SousTitre val(int p){
	  return this.tab[p];
  }

  public String toString(){
    String s =" La liste contient"+"\n";
    for(int i=0;i<this.nbElements;i++) {
      s=s+tab[i].toString()+"\n";
    }
    return s;
  }



}
