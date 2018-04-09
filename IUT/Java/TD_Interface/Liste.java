public interface Liste {

  public abstract int tete();

  public abstract SousTitre val(int place);

  public abstract int suc(int place);

  public abstract boolean finliste(int place);


  public abstract void lisvide();

  public abstract void adjtlis(SousTitre s);

  public abstract void adjlis(int place,SousTitre s);

  public abstract void suplis(int place);

  public abstract void suptlis();

  public abstract void adjqlis(SousTitre s);

  public abstract void supqlis();

  public abstract void chlis();





}
