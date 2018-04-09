package libtest;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class SortieGUI implements Sortie {

	Logs logs=new Logs("");
	
	/**
	 * le lanceur de test
	 */
	Lanceur lanceurdeTest;

	/**
	 * interface graphique Barre
	 */
	SortieGUIBarre barre;

	/**
	 * JTree des tests
	 */
	static JTree tree;

	/**
	 * creer l'interface
	 */
	public SortieGUI(Lanceur lanceurdeTest) {
		// met à jour le lanceur de test
		this.lanceurdeTest = lanceurdeTest;

		// creation JFRame
		JFrame frame = new JFrame();

		// creation d'onglet
		JTabbedPane onglets = new JTabbedPane();

		// ajoute les erreurs
		onglets.add(creerInterfaceErreur(), "Résultats des Tests");
		// ajoute les guide
		onglets.add(creerInterfaceGuide(), "Guide des Exceptions");

		// met les onglets dans la frame
		frame.setContentPane(onglets);
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * JEditorPane textuel qui présente un Guide
	 * 
	 * @return guide d'utilisation
	 */
	private Component creerInterfaceGuide() {
		// creation du panel
		JEditorPane jedit = new JEditorPane();
		JScrollPane scrollPane = new JScrollPane(jedit);

		jedit.setContentType("text/html");
		jedit.setEditable(false);

		String guide = "<h2>Guide des exceptions</h2>"
				+ "Ce guide présente quelques exceptions classiques que votre programme peut faire apparaitre (sous la forme d'une erreur)."
				+ "<ul>"
				+ "<li> <b>NullPointerException</b><br>"
				+ "Un NullPointerException apparait lorsqu'une méthode ou un attribut est appelé sur un objet qui vaut null. Comme l'objet n'existe pas, l'instruction ne peut pas s'executer<br><br>"
				+ "<table border=1 width=300><tr><td><i>UnPoint p=null;<br>"
				+ "//Exception quand p est null<br>"
				+ "int a=p.x;<br>"
				+ "//Exception quand p est null<br>"
				+ "p.seTranslater(10,10); <br>"
				+ "<br></td></tr></table><br>"
				+ "<li> <b>ArrayIndexOutOfBoundsException</b><br>"
				+ "Cette Exception apparait lorsqu'on accède à un indice d'une case qui n'existe pas dans un tableau. Cela peut se produire lorsque l'indice passé au tableau est négatif ou lorsqu'il est supérieur ou égal à la taille du tableau<br><br>"
				+ "<table border=1 width=300><tr><td><i>"
				+ "int tab[]=new int[10];<br>"
				+ "//Exception quand indice négatif<br>" + "int a=tab[-1];<br>"
				+ "//Exception quand indice egal à taille<br>"
				+ "int a=tab[10] ;<br>" +

				"</td></tr></table><br>" + "</ul>";

		// remplissage
		jedit.setText(guide);
		jedit.setPreferredSize(new Dimension(400, 400));

		return scrollPane;
	}

	/**
	 * permet de creer les morceaux d'interface pour gérer les erreurs et leurs
	 * logs
	 * 
	 * @return JPanel qui est une interface de log
	 */
	private JPanel creerInterfaceErreur() {

		// met un bouton pour relancer les tests
		JButton lanceTests = new JButton("relancer tests");
		final Lanceur classtest = this.lanceurdeTest;
		// le listenre pour lancer les tests
		lanceTests.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				classtest.executeTests();

			}
		});

		// Le JPanel qui affiche la barre verte ou rouge
		barre = new SortieGUIBarre();

		// Le JTree
		String titre = "Resultats de la classe " + this.logs.nomClasseTestee;
		DefaultMutableTreeNode top = new DefaultMutableTreeNode(titre);

		DefaultMutableTreeNode t1 = new DefaultMutableTreeNode("test1 + ok");
		t1.add(new DefaultMutableTreeNode("descriptif"));
		t1.add(new DefaultMutableTreeNode("Exceptions"));
		top.add(t1);

		DefaultMutableTreeNode t2 = new DefaultMutableTreeNode("test2 + ok");
		t2.add(new DefaultMutableTreeNode("descriptif"));
		t2.add(new DefaultMutableTreeNode("Exceptions"));
		top.add(t2);

		tree = new JTree(top);
		JScrollPane scroll = new JScrollPane(tree);
		scroll.setPreferredSize(new Dimension(400, 400));

		// le JPanel global
		JPanel global = new JPanel();
		global.setLayout(new BorderLayout());
		global.add(barre, BorderLayout.NORTH);
		global.add(scroll, BorderLayout.CENTER);
		global.add(lanceTests, BorderLayout.SOUTH);

		return (global);

	}

	/**
	 * associe les couleurs au log
	 * 
	 * @param l
	 *            le log concerne
	 * @param color
	 *            la couleur associee
	 * @return la chaine represetant la couleur
	 */
	public String choixCouleurTree(Log l, String color) {
		if (l.type.equals("Ok"))
			color = "green";

		if (l.type.equals("Erreur"))
			color = "red";

		if (l.type.equals("Echec"))
			color = "orange";
		return color;
	}

	@Override
	public void miseAjour(Logs l) {
		this.logs=l;
		// met l'arbre a jour
		miseAJourTree();

		// met la barre ajour
		miseAJourBarre();
	}

	/**
	 * fait les calculs pour la mise a jour de la barre
	 * 
	 * @param logs
	 *            une liste de log
	 */
	public void miseAJourBarre() {
		// calculs log
		barre.miseAJour(logs.genererStatistiques());
	}

	/**
	 * met a jour l'arbre
	 * 
	 * @param logs
	 *            la liste des Logs
	 */
	public void miseAJourTree() {

		// mettre a jour tree
		tree.removeAll();
		DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(
				"<html><font color=black>Resultats de <b>"
						+ this.logs.nomClasseTestee
						+ "</b></text></font></html>");
		model.setRoot(root);

		// ajouter resultats des tests
		for (Log l : logs.logs) {

			String r;
			String color = "black";

			// determine la couleur des branches
			color = choixCouleurTree(l, color);

			r = "<html><font color=" + color + ">" + l.nomMethode + " - "
					+ l.type + "</font></html>";
			DefaultMutableTreeNode log = new DefaultMutableTreeNode(r);

			// contenu du log en cas d'erreur
			if (l.type.equals("Erreur") || l.type.equals("Echec")) {
				r = "Classe: " + l.classOuErreur + ", Ligne: "
						+ l.LigneErreur;
				DefaultMutableTreeNode endroit = new DefaultMutableTreeNode(r);
				log.add(endroit);
				r = "Message: " + l.exception.getMessage();
				DefaultMutableTreeNode message = new DefaultMutableTreeNode(r);
				log.add(message);

				// parcours exception en cas d'erreur
				if (l.type.equals("Erreur")) {
					// on affiche le contenu de l'exception qui est
					// remontee
					r = "<html><b>" + l.exception.getClass().getName()
							+ "</b></html>";
					DefaultMutableTreeNode except = new DefaultMutableTreeNode(
							r);
					log.add(except);

					// on parcourt la pile d'appel
					for (StackTraceElement stack : l.exception
							.getStackTrace()) {
						// si on arrive dans les classes d'invocation
						if (stack.getClassName().equals(
								"sun.reflect.NativeMethodAccessorImpl"))
							break;
						r = "" + stack;
						DefaultMutableTreeNode stackelement = new DefaultMutableTreeNode(
								r);
						except.add(stackelement);

					}
				}

			}

			// ajout du log a l'arbre
			root.add(log);
		}
		tree.expandRow(0);

	}

}
