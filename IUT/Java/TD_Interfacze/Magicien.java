public classe Magicien extends Sorcier implements SuperPouvoir {

  public Magicien(String n, int pwr) {
    super (n,pwr);
  }
  public int getPouvoir() {
    return super.getPouvoir()*SuperPouvoir.EXTRA;
  }


}
