import static libtest.Lanceur.lancer;
import static libtest.OutilTest.assertEquals;

public class Principale {

  public void testGlobal(){
  CorpsCeleste[] sysSol=new CorpsCeleste[4];
  sysSol[0] = new Etoile("Soleil",695000,1.989e27,6273);
  sysSol[1] = new Planete("Terre",6318.14,5.976e+21,149.6,sysSol[0]);
  sysSol[2] = new Planete("Mars",3397.2,6.421e20,227.94,sysSol[0]);
  sysSol[3] = new Satellite("Lune",1737.4,7.349e19,0.3844,sysSol[1]);



  for(int i=0; i< sysSol.length;i++){
  System.out.println(sysSol[i]);

  if(((Planete)(sysSol[1])).avoirMemeSoleil((Planete)sysSol[2])) {
    switch(i){
      case 1:
      System.out.println((" - Planete voisine dans le systeme: ")+ sysSol[2].rendreNom());
      break;

      case 2:
      System.out.println((" - Planete voisine dans le systeme: ")+ sysSol[1].rendreNom());
      break;
    }
  }

  if (sysSol[i] instanceof Planete){
    CorpsRevolution BOB =(CorpsRevolution)sysSol[i];
    Etoile star =(Etoile)BOB.tournerAutourDe();
    System.out.println(" - Energie percue de l'etoile :"+ star.calculerEnergieRecue(BOB.rendreRayonOrbital()));
  }
}


}

  public static void main(String[] args){
    lancer(new Principale(), args);
  }
}
