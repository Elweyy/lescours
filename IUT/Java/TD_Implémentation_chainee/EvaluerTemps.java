/**
 * programme pour évaluer le temps necessaire à chaque liste 
 * pour faire des opérations complexes 
 */
public class EvaluerTemps {
	
	
	public static void main(String [] args)
	{
		//les types des listes testées
		String[] types={"prof","contigue","chainee"};
		
		//créateur de liste
		DistributeurListe distributeur=new DistributeurListe();
		SousTitre t=new SousTitre(10, "Test");
		
		//lancement des tests
		for (int numTest=0;numTest<types.length;numTest++)
		{
			//on demande la création de la liste à tester
			String nom=types[numTest];
			Liste liste=distributeur.fournirListe(nom);
						
			//sauvegarde le temps avant les tests
			long debut=System.nanoTime();
			System.out.println("******************\nLance les tests de "+nom);
		
			//les tests
			//on fait num fois
			int num=10000;
			for (int j=1;j<num;j++)
			{
				int k=99;
				//k ajouts puis k suppressions
				for (int i=0;i<k;i++)
					liste.adjtlis(t);
				for (int i=0;i<k;i++)
					liste.suplis(liste.tete());
			}
			
			//sauvegarde le temps apres les test
			long fin=System.nanoTime();
			System.out.println("fin des tests de "+nom);
			
			//performance différence de temps
			System.out.print("temps passe: ");
			System.out.println(((fin-debut)/num)+" nanosecondes par boucle");
			System.out.println("******************\n");			
		}
		
		
	}

}
