import java.util.*;


public class Faf {

  public void ChercherSolution(){

    if (nbSommet = 2 && tab[O][1]== 1) {
      System.out.println("1-2");
    }
    else{
      for (int a=0; a<nbSommet;a++) {
        System.out.println("");
        for (int b=0;b<nbSommet;b++)
      }
    }
  }




  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.println("Nombre de sommets ? ");
    int nbSommet = sc.nextInt();

    int[][] tab = new int [nbSommet][nbSommet];

    for (int k=0;k<nbSommet;k++){
      for (int l=0; l<nbSommet; l++) {
        tab[k][l]=0;
      }
    }


    System.out.println("successeurs de chaque sommets");


    for (int i=0;i<nbSommet;i++){
      boolean fin = false;
      while( fin == false) {
        System.out.println("Pour le sommet " +(i+1)+ ", rentrer un sommet compris entre 1 et "+ nbSommet + "," + (i+1) + " n'etant pas compris");
        System.out.println("Pour passer au sommet suivant, rentrer 0");
        int suc = sc.nextInt();
        if (suc==0){
          fin= true;
        }
          else if (suc!=(i+1)) {
            tab[i][suc-1]=1;
          }
          else  {
            System.out.println(" Pas possible, deso BB");
          }

          }
      }

      for (int m = 0; m<nbSommet;m++){
        System.out.println(" ");
        for (int n =0;n<nbSommet;n++) {
          System.out.print(tab[m][n]);

      }
      }
    }


















}
