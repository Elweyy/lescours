import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

/**
 * Lanceur de Tests
 * version 1.2 - gestion des null
 * version 1.3 - lancement graphique ou textuel
 * version 1.4 - correction bug de mise a jour avec bouton
 * version 1.5 - onglet guide exceptions 
 *            
 */

/**
 * cree une classe d'Exception qui remonte sans verifier le try catch
 * 
 * @author vthomas
 */
class LanceurTestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * constructeur avec un message
	 * 
	 * @param s
	 *            message d'erreur
	 */
	public LanceurTestException(String s) {
		super(s);
	}

}

/**
 * classe qui permet d'afficher la barre horizontale
 * 
 * @author vthomas
 * 
 */
class LanceurBarre extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * attributs pour affichage des statistiques
	 */
	int nbOk;
	int nbErreur;
	int nbEchec;
	int nbTests;

	/**
	 * attributs pour gerer taille de la barre
	 */
	int tailleX = 400;
	int TailleY = 80;
	// decalage de la barre par rapport à jframe
	public static final int decalX = 20;
	public static final int decalY = 10;
	// taille de la barre en Y
	public static final int BarreY = 40;

	/**
	 * met a jour la barre de status
	 * 
	 * @param PnbOk
	 *            nombre de ok
	 * @param PnbErreur
	 *            nombre erreurs
	 * @param PnbEchec
	 *            nombre echec
	 */
	public void miseAJour(int PnbOk, int PnbErreur, int PnbEchec) {
		this.nbOk = PnbOk;
		this.nbEchec = PnbEchec;
		this.nbErreur = PnbErreur;
		this.nbTests = this.nbOk + this.nbEchec + this.nbErreur;
		this.repaint();
	}

	/**
	 * permet de generer la barre à la bonne taille
	 */
	public LanceurBarre() {
		super();
		setPreferredSize(new Dimension(tailleX, TailleY));
	}

	/**
	 * surcharge de la méthode paint pour dessiner la barre
	 */
	public void paint(Graphics g) {
		super.paint(g);

		// s'il n'y a pas de tests, on ne fait rien
		if (this.nbTests == 0)
			return;

		// met a jour l'affichage de la barre
		int tailleXBarre = this.tailleX - 2 * this.decalX;
		int decalage = this.decalX;

		// le OK
		int finOK = (tailleXBarre * this.nbOk) / this.nbTests;
		g.setColor(Color.green);
		g.fillRect(decalage, this.decalY, finOK, this.BarreY);
		decalage += finOK;

		// le echec
		g.setColor(Color.orange);
		int finEchec = (tailleXBarre * this.nbEchec) / this.nbTests;
		g.fillRect(decalage, this.decalY, finEchec, this.BarreY);
		decalage += finEchec;
		// le erreur
		g.setColor(Color.red);
		int finErreur = (tailleXBarre * nbErreur) / nbTests;
		g.fillRect(decalage, decalY, finErreur, BarreY);
		decalage += finErreur;
		// dessin rectangle
		g.setColor(Color.black);
		g.drawRect((tailleX - tailleXBarre) / 2, decalY, tailleXBarre, BarreY);

		g.drawString("Tests: " + nbTests, 0, TailleY - 10);
		g.drawString("Ok: " + nbOk, 100, TailleY - 10);
		g.drawString("Echec: " + nbEchec, 200, TailleY - 10);
		g.drawString("Erreur: " + nbErreur, 300, TailleY - 10);
		g.dispose();

	}

}

/**
 * classe qui permet de stocker les logs des resultats de test
 * 
 * @author vthomas
 * 
 */
class LanceurLog {
	// le nom de la methode de test
	public String nomMethode;
	// le type soit une erreur, soit un echec
	public String type;

	// class ou se trouve l'erreur
	public String classOuErreur;
	// ligne ou se trouve l'erreur
	public String LigneErreur;

	// exception declencheuse
	public Throwable exception;

	/**
	 * interface graphique
	 */
	// JPanel de labarre
	static LanceurBarre barre;

	// JTree des tests
	static JTree tree;

	/**
	 * constructeur vide par defaut tout se passe bien
	 */
	public LanceurLog() {
		this.type = "Ok";
	}

	/**
	 * affiche un log d'erreur
	 */
	public String toString() {
		String resultat = ("***** Test " + nomMethode + "  **********************************\n");

		// si il y eu une erreur
		if (exception != null) {
			resultat += ("  - Type: " + type + "\n");
			resultat += ("  - Classe: " + classOuErreur);
			resultat += (", Ligne: " + LigneErreur + "\n");
			resultat += ("  - Message: " + exception.getMessage() + "\n");

			// affiche exception
			StackTraceElement[] traces = exception.getStackTrace();
			for (StackTraceElement trace : traces) {
				// on arrete de faire la pile des qu'on arrive a
				// l'invocation de lanceur
				if (trace.getClassName().equals(
						"sun.reflect.NativeMethodAccessorImpl"))
					break;

				// sinon on remonte la pile d'appel
				resultat += "       -> " + trace.getClassName() + " at "
						+ trace.getFileName() + "(" + trace.getLineNumber()
						+ ")\n";
			}

		} else {
			resultat += "  - OK\n";
		}

		resultat += ("***** fin " + nomMethode + "  **********************************\n\n");

		// exception.printStackTrace();
		return (resultat);
	}

	/**
	 * permet de mettre a jour l'affichage a partir le la liste des logs
	 * 
	 * @param logs
	 *            liste des logs a afficher
	 */
	public static void afficheGraphiqueListeLogs(ArrayList<LanceurLog> logs) {

		// met l'arbre a jour
		miseAJourTree(logs);

		// met la barre ajour
		miseAJourBarre(logs);
	}

	/**
	 * fait les calculs pour la mise a jour de la barre
	 * 
	 * @param logs
	 *            une liste de log
	 */
	public static void miseAJourBarre(ArrayList<LanceurLog> logs) {
		// calculs log
		int nbTests = logs.size();
		int nbErreur = 0;
		int nbEchec = 0;
		int nbOk = 0;

		for (LanceurLog l : logs) {
			if (l.type.equals("Ok"))
				nbOk++;
			if (l.type.equals("Erreur"))
				nbErreur++;
			if (l.type.equals("Echec"))
				nbEchec++;
		}
		barre.miseAJour(nbOk, nbErreur, nbEchec);
	}

	/**
	 * met a jour l'arbre
	 * 
	 * @param logs
	 *            la liste des Logs
	 */
	public static void miseAJourTree(ArrayList<LanceurLog> logs) {

		// mettre a jour tree
		tree.removeAll();
		DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(
				"<html><font color=black>Resultats de <b>"
						+ Lanceur.classDeTest.getClass().getName()
						+ "</b></text></font></html>");
		model.setRoot(root);

		// numero test
		int numTest = -1;
		// ajouter resultats des tests
		for (LanceurLog l : logs) {
			// augmente le numero de test
			numTest++;

			String r;
			String color = "black";

			// determine la couleur des branches
			color = choixCouleurTree(l, color);

			r = "<html><font color=" + color + ">" + l.nomMethode + " - "
					+ l.type + "</font></html>";
			DefaultMutableTreeNode log = new DefaultMutableTreeNode(r);

			// contenu du log en cas d'erreur
			if (l.type.equals("Erreur") || l.type.equals("Echec")) {
				r = "Classe: " + l.classOuErreur + ", Ligne: " + l.LigneErreur;
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
					for (StackTraceElement stack : l.exception.getStackTrace()) {
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

	/**
	 * associe les couleurs au log
	 * 
	 * @param l
	 *            le log concerne
	 * @param color
	 *            la couleur associee
	 * @return la chaine represetant la couleur
	 */
	public static String choixCouleurTree(LanceurLog l, String color) {
		if (l.type.equals("Ok"))
			color = "green";

		if (l.type.equals("Erreur"))
			color = "red";

		if (l.type.equals("Echec"))
			color = "orange";
		return color;
	}

	/**
	 * affiche la JFrame et creer les attrbuts de l'interface
	 */
	public static void creeInterface() {

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
	private static Component creerInterfaceGuide() {
		// creation du panel
		JEditorPane jedit = new JEditorPane();
		jedit.setContentType("text/html");
		jedit.setEditable(false);

		String guide = "<h2>Guide des exceptions</h2>"
				+ "Ce guide présente quelques exceptions classiques que votre programme peut faire apparaitre (sous la forme d'une erreur)."
				+ "<ul>"
				+ "<li> <b>NullPointerException</b><br>"
				+ "Un NullPointerException apparait lorsqu'une méthode ou un attribut est appelé sur un objet qui vaut null. Comme l'objet n'existe pas, l'instruction ne peut pas s'executer<br><br>"
				+ "<li> <b>ArrayIndexOutOfBoundsException</b><br>"
				+ "Cette Exception apparait lorsqu'on accède à un indice d'une case qui n'existe pas dans un tableau. Cela peut se produire lorsque l'indice passé au tableau est négatif ou lorsqu'il est supérieur ou égal à la taille du tableau<br><br>"
				+ "</ul>"
		;

		// remplissage
		jedit.setText(guide);
		jedit.setPreferredSize(new Dimension(400, 400));

		return jedit;
	}

	/**
	 * permet de creer les morceaux d'interface pour gérer les erreurs et leurs
	 * logs
	 * 
	 * @return JPanel qui est une interface de log
	 */
	private static JPanel creerInterfaceErreur() {

		// met un bouton pour relancer les tests
		JButton lanceTests = new JButton("relancer tests");
		// le listenre pour lancer les tests
		lanceTests.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Lanceur.mettreAJourInterface(Lanceur.classDeTest);
			}
		});

		// Le JPanel qui affiche la barre verte ou rouge
		barre = new LanceurBarre();

		// Le JTree
		DefaultMutableTreeNode top = new DefaultMutableTreeNode(
				"Resultats de la classe " + Lanceur.classDeTest.getClass());

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
	 * affiche tous les logs
	 * 
	 * @param logs
	 */
	public static void afficheTexteListeLogs(ArrayList<LanceurLog> logs) {

		// affichage de la classe de test
		System.out.println(Lanceur.classDeTest.getClass());
		System.out.println("Test nÂ°" + Lanceur.numLancer);

		// calculs log
		int nbTests = logs.size();
		int nbErreur = 0;
		int nbEchec = 0;
		int nbOk = 0;

		for (LanceurLog l : logs) {
			if (l.type.equals("Ok"))
				nbOk++;
			if (l.type.equals("Erreur"))
				nbErreur++;
			if (l.type.equals("Echec"))
				nbEchec++;
		}

		// affiche le resulta global
		System.out.println("nb test:" + nbTests);
		System.out.println("nb Ok:" + nbOk);
		System.out.println("nb echec:" + nbEchec);
		System.out.println("nb erreur:" + nbErreur);
		System.out.println("\n");

		System.out.println("#########################################");
		System.out.println("# Echecs et erreurs ####################");
		System.out.println("######################################### \n");

		// affiche les ligs qui Ã©chouent
		for (LanceurLog l : logs) {
			if ((l.type.equals("Erreur")) || (l.type.equals("Echec")))
				System.out.println(l);
		}

		System.out.println("#########################################");
		System.out.println("# Ensemble des resultats ####################");
		System.out.println("######################################### \n");

		// afiche logs
		for (LanceurLog l : logs) {
			System.out.println(l);
		}

		System.out.println("\n");
		System.out
				.println("************************************************************\n");
	}

}

/**
 * lanceur de test unitaire
 * 
 * @author vthomas
 * 
 */
public class Lanceur {

	/**
	 * le nombre de lancement
	 * 
	 */
	static int numLancer = 0;

	/**
	 * la classe qu icontient les tests
	 */
	static Object classDeTest;

	/**
	 * methode statique de test qui echoue
	 */
	public static void fail(String erreur) {
		throw new LanceurTestException(erreur);
	}

	/**
	 * methode statique de comparaison
	 */
	public static void assertEquals(Object attendu, Object obtenu, String erreur) {
		// si on test des references null
		if (attendu == null) {
			if (obtenu != null)
				throw new LanceurTestException(erreur + " [attendu=>" + attendu
						+ ", obtenu=>" + obtenu + "]");
		}
		// sinon on peut tester egalite
		else if (!attendu.equals(obtenu))
			throw new LanceurTestException(erreur + " [attendu=>" + attendu
					+ ", obtenu=>" + obtenu + "]");
	}

	/**
	 * lance les test mais avec la crÃ©ation de la partie graphique
	 * 
	 * @param classDeTest
	 *            la classe de Test
	 */
	public static void lanceAvecInterface(Object classTest) {
		// sauve la classe de test
		classDeTest = classTest;

		// lance interface grpahique
		LanceurLog.creeInterface();

		// mise a jour interface
		mettreAJourInterface(classTest);
	}

	/**
	 * lance les test et met a jour l'interface graphique
	 * 
	 * @param classDeTest
	 *            la classe de Test
	 */
	public static void mettreAJourInterface(Object classTest) {
		// lance le premier test
		ArrayList<LanceurLog> listeLogs = genereLog(classTest);

		// cree arbre
		LanceurLog.afficheGraphiqueListeLogs(listeLogs);
	}

	/**
	 * lance les tests
	 * 
	 * @param test
	 *            l'objet correspondant a la classe de test
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * 
	 */
	public static void lanceSansInterface(Object test) {

		ArrayList<LanceurLog> listeLogs = genereLog(test);

		// affiche l'ensemble des log
		// Log.afficheTexteListeLogs(listeLogs);
		LanceurLog.afficheTexteListeLogs(listeLogs);

	}

	/**
	 * genere les logs en lancant les tests
	 * 
	 * @param test
	 *            classe de test Ã  lancer
	 * 
	 * @return liste de logs obtenus
	 */
	private static ArrayList<LanceurLog> genereLog(Object test) {
		classDeTest = test;

		// recharge a chaud les classes avec un nouveau classLoader
		rechargeAChaud();

		// inxcrementer le nombre de lancer
		numLancer++;

		// recupere les methodes de test
		Method[] methodes = test.getClass().getMethods();

		// les garde si elles contiennent test
		ArrayList<Method> listeMethodes;
		listeMethodes = filtreMethodes(methodes);

		// on trie les methodes
		trieLesMethodesParNom(listeMethodes);
		// System.out.println(listeMethodes);

		// liste de l'ensemble des logs
		ArrayList<LanceurLog> listeLogs = new ArrayList<LanceurLog>();

		// lance tous les tests
		for (Method methodeATester : listeMethodes) {
			LanceurLog log = testeUneMethode(test, methodeATester);
			listeLogs.add(log);
		}
		return listeLogs;
	}

	/**
	 * permet de recharger les classes a chaud
	 */
	public static void rechargeAChaud() {
		URL u, u2 = null;
		try {
			u = new File("").toURI().toURL();
			u2 = new File("bin").toURI().toURL();
			URL[] url = { u, u2 };
			URLClassLoader ucl = new URLClassLoader(url, null);
			Class classAn = ucl.loadClass(classDeTest.getClass().getName());
			Lanceur.classDeTest = classAn.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * permet de tester une methode
	 * 
	 * deux cas se produisent - soit elle renvoie une InvocationException et il
	 * y a une erreur dans l'appel - si c'est un cause par un TestException ==
	 * failure - sinon c'est une exception interne - soit elle ne renvoie rien
	 * et c'est ok
	 * 
	 * 
	 * @param test
	 * @param methodeATester
	 */
	public static LanceurLog testeUneMethode(Object test, Method methodeATester) {
		// construction du log
		LanceurLog l = new LanceurLog();
		l.nomMethode = methodeATester.getName();

		try {
			methodeATester.invoke(test, new Object[0]);
		} catch (InvocationTargetException e) {
			// vient a cause d'un test echoue

			// voir l'exception interne
			Throwable exceptionInterne = e.getCause();
			// afin d'eviter les problemes dans le nouveau
			// rechargement de classes
			// (les classes ne sont pas les memes et instance of ne
			// fonctionne donc pas)
			if (exceptionInterne.getClass().getSimpleName()
					.equals("LanceurTestException")) {
				// c'est une exception due a un test echoue
				creeLogTestEchec(exceptionInterne, l);
			} else {
				creeLogTestErreur(exceptionInterne, l);
			}

		} catch (IllegalAccessException e) {
			System.out.println("erreur importante de l'appli de test!!!");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("erreur importante de l'appli de test!!!");
			e.printStackTrace();
		}

		return (l);

	}

	/**
	 * Log en cas d'erreur
	 * 
	 * @param exceptionInterne
	 *            exception qui genere l'erreur
	 * @param log
	 *            le log ou sauver
	 */
	public static void creeLogTestErreur(Throwable exceptionInterne,
			LanceurLog log) {
		// mise a jour du log
		log.type = "Erreur";

		// indice dans le stacktrace
		int indiceLigne = 1;

		// faut voir si la methode appelee est verifier ou pas.
		if (exceptionInterne.getStackTrace()[1].getMethodName().equals(
				"verifier")) {
			// c'est qu'il faut descendre d'un cran dans la stacktrace
			indiceLigne = 2;
		}
		log.classOuErreur = exceptionInterne.getStackTrace()[indiceLigne]
				.getFileName();
		log.LigneErreur = ""
				+ exceptionInterne.getStackTrace()[indiceLigne].getLineNumber();
		log.exception = exceptionInterne;
	}

	/**
	 * methode qui affiche que le test echoue
	 * 
	 * @param exceptionInterne
	 *            l'erreur qui explique ou le test echoue
	 */
	public static void creeLogTestEchec(Throwable exceptionInterne,
			LanceurLog log) {
		// mise a jour du log
		log.type = "Echec";

		// indice dans le stacktrace
		int indiceLigne = 1;

		// faut voir si la methode appelee est verifier ou pas.
		if (exceptionInterne.getStackTrace()[1].getMethodName().equals(
				"verifier")) {
			// c'est qu'il faut descendre d'un cran dans la stacktrace
			indiceLigne = 2;
		}
		log.classOuErreur = exceptionInterne.getStackTrace()[indiceLigne]
				.getFileName();
		log.LigneErreur = ""
				+ exceptionInterne.getStackTrace()[indiceLigne].getLineNumber();
		log.exception = exceptionInterne;

	}

	/**
	 * filtre les methodes et ne garde que les methodes commencant par test
	 * 
	 * @param methodes
	 *            liste des methodes
	 * @return liste des methodes avec test dans leur nom
	 */
	public static ArrayList<Method> filtreMethodes(Method[] methodes) {
		ArrayList<Method> listeMethodes;
		listeMethodes = new ArrayList<Method>();
		for (Method m : methodes) {
			// si son nom commence par test, on l'ajoute
			if (m.getName().substring(0, 4).equals("test"))
				listeMethodes.add(m);
		}
		return listeMethodes;
	}

	/**
	 * trie les methodes selon leur numero
	 * 
	 * @param listeMethodes
	 */
	public static void trieLesMethodesParNom(ArrayList<Method> listeMethodes) {
		// on trie les methodes par numero
		Comparator<Method> compMethode = new Comparator<Method>() {

			@Override
			public int compare(Method methode0, Method methode1) {
				int n0 = getNumeroMethode(methode0);
				int n1 = getNumeroMethode(methode1);
				if (n0 < n1) {
					return (-1);
				}
				if (n0 > n1) {
					return (1);
				}
				return 0;
			}

			/**
			 * claulce le numero de la methode
			 * 
			 * @param methode0
			 *            methode dont on cherche le numero
			 * @return numero de methode
			 */
			public int getNumeroMethode(Method methode0) {
				try {
					String[] tab = methode0.getName().split("_");
					if (tab.length > 1)
						return Integer.parseInt(tab[1]);
				} catch (NumberFormatException e) {
				}
				return (-1);
			}
		};
		Collections.sort(listeMethodes, compMethode);
	}

}
