public class Temps {
  int heures, minutes, secondes;




  public boolean valideTemps(int h, int m, int s) throws TempsException{



    if( h<0){
      throw new TempsException(" Mauvaise heure");
    }

    if (s<0 || s>60 ){
      throw new TempsException(" Mauvaises secondes");
    }

    if (m<0 || m>60 ){
      throw new TempsException(" Mauvaises minutes");
    }
    return true;

  }


    public Temps(int h, int m, int s) throws TempsException{
      if(this.valideTemps( h, m, s)){
      this.heures =h;
      this.minutes = m;
      this.secondes = s;
    }else{
      throw new TempsException();
    }
  }


  public int traduireEnSecondes(){
    int hs,ms,ti;
    hs=this.heures*60*60;
    ms=this.minutes*60;
    ti= hs + ms +this.secondes;
    return ti;
  }

  public void incrementer(int nbs) {
    int hs,ms,si,ti;
    si = nbs%60;
    ms =  (nbs-si)/60%60;
    hs = (((nbs-si)/60)-ms) /60;

    this.secondes+=si;
    this.minutes+=ms;
    this.heures+=hs;

    if(this.secondes >60){
      int stp =this.secondes;
      this.secondes = this.secondes%60;
      this.minutes += (stp-this.secondes)/60;
    }
    if(this.minutes >60){
      int mtp =this.minutes;
      this.minutes = this.minutes%60;
      this.heures += (mtp-this.minutes)/60;
    }
  }

    public boolean avant(Temps h){
      if ( h.traduireEnSecondes()>this.traduireEnSecondes()) {
        return true;
      }else{
        return false;
      }
    }

    public Temps dureeJusquA(Temps h) throws TempsException{
      if ( this.avant(h)) {
        Temps j = new Temps(0,0,0);
        j.incrementer(this.traduireEnSecondes()-h.traduireEnSecondes())

        return j;
      }else {
        throw new TempsException(" L'evenement h est avant l'evenement courant");
      }
    }
  }
