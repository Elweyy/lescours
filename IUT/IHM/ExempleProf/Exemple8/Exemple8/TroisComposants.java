import javax.swing.*;
import java.awt.*;

public class TroisComposants {
    public static void main(String[] args) {
        JFrame fenetre=new JFrame("Affichage d'un mot");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AfficheurMot dessin=new AfficheurMot();
        dessin.setPreferredSize(new Dimension(400,200));
        fenetre.setContentPane(dessin);
        fenetre.pack();
        fenetre.setVisible(true);
    }
}
