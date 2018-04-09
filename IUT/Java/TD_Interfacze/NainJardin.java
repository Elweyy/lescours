public class NainJardin implements Victime {

private int solidite;

public NainJardin (int s){
  if(s<=0)
  s=1;
  this.solidite=s;
  }
  public int subirFrappe(int coup){
    int blessure;
    if(coup>this.solidite) {
      blessure=this.solidite;
      this.solidite=0
    }
    else blessure=coup;
    return blessure;
  }

public int subirCharme(int coup) {
  return(1);
  }


public String toString() {
  return("Je suis un nain de jardin de solidité" +this.solidite);
}
}
