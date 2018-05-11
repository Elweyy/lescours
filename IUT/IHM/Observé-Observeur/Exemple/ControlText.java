import java.awt.Dimension;
import java.util.Scanner;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

public class ControlText {
   public static void main(String[] args) {
      Disque d=new Disque(); // modèle
      VueTexte vt=new VueTexte();
      VueGraph vg=new VueGraph();
      vg.setPreferredSize(new Dimension(200,200));
      JFrame f=new JFrame();
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      f.setContentPane(vg); 
      f.pack();
      f.setVisible(true);
      //on fait le lien entre le modèle et les vues
      d.addObserver(vt);
      d.addObserver(vg);
      //on fait la boucle de modification du modèle
      Scanner sc=new Scanner(System.in);
      System.out.println("donner la taille du disque: ");
      int choix=sc.nextInt();
      while(choix>0) {
         //modification, conduit à la mise à jour des vues
         d.setTaille(choix);
         System.out.println("donner la nouvelle taille du disque: ");
         choix=sc.nextInt();
      }  
   } 
}
