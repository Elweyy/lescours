package application;

public class TestOutil {
	public static boolean test1constructeurvide() {
		System.out.println("        Test 1");
		Outil outiltest=new Outil();
		if (outiltest.degats!=2){
			System.out.println("Mauvaise valeur degats");
			return false;
		}
		if (outiltest.portee!=2){
			System.out.println("Mauvaise valeur portee");
			return false;
		}
		if (outiltest.posX!=5){
			System.out.println("Mauvaise valeur position");
			return false;
		}
		if (outiltest.porteur!=null){
			System.out.println("Mauvaise valeur porteur");
			return false;
		}
		return true;
		
	}
	
	public static boolean test2constructeurparam() {
		System.out.println("        Test 2");
		Outil outiltest=new Outil(5, 6, 3);
		if (outiltest.degats!=6){
			System.out.println("Mauvaise valeur degats");
			return false;
		}
		if (outiltest.portee!=3){
			System.out.println("Mauvaise valeur portee");
			return false;
		}
		if (outiltest.posX!=5){
			System.out.println("Mauvaise valeur position");
			return false;
		}
		if (outiltest.porteur!=null){
			System.out.println("Mauvaise valeur porteur");
			return false;
		}
		return true;
	}
	
	public static boolean test3constructeurpos() {
		System.out.println("        Test 3");
		Outil outiltest=new Outil(12, -6, -2);
		if (outiltest.degats!=0){
			System.out.println("Mauvaise valeur degats");
			return false;
		}
		if (outiltest.portee!=0){
			System.out.println("Mauvaise valeur portee");
			return false;
		}
		if (outiltest.posX!=0){
			System.out.println("Mauvaise valeur position");
			return false;
		}
		if (outiltest.porteur!=null){
			System.out.println("Mauvaise valeur porteur");
			return false;
		}
		
		outiltest=new Outil(-2,-6,-2);
		if (outiltest.posX!=0){
			System.out.println("Mauvaise valeur position");
			return false;
		}
		return true;
		
	}

	public static boolean test4changerpos() {
		System.out.println("        Test 4");
		Robot robottest=new Robot();
		Outil outiltest=new Outil();
		robottest.outil=outiltest;
		outiltest.porteur=robottest;
		outiltest.changerPosition();
		if (outiltest.posX!=0){
			System.out.println("Mauvaise Position");
			return false;
		}
		else return true;
		
	}

	public static boolean test5changerposporteurnull() {
		System.out.println("        Test 5");
		Robot robottest=new Robot();
		Outil outiltest=new Outil();
		int testposition=outiltest.getPosX();
		robottest.outil=outiltest;
		outiltest.porteur=null;
		outiltest.changerPosition();
		if (outiltest.posX!=testposition){
			System.out.println("Mauvaise Position: le porteur est null");
			return false;
		}
		else return true;
	
	}

	public static boolean test6etrepris() {
		System.out.println("        Test 6");
		Robot robottest=new Robot("Jean",5);
		Outil outiltest=new Outil(5, 0, 0);
		outiltest.etrePris(robottest);
		if (outiltest.porteur!=robottest){
			System.out.println("L'outil n'est pas considéré comme porté");
			return false;
		}
		
		else return true;
	
	}

	public static boolean test7etreprisporteurnonnull() {
		System.out.println("        Test 7");
		Robot robottest=new Robot("Jean",4);
		Robot robotporteur=new Robot("porteur",5);	
		Outil outiltest=new Outil(5, 0, 0);
		outiltest.porteur=robotporteur;
		outiltest.etrePris(robottest);
	
		if (outiltest.porteur==robottest){
			System.out.println("L'outil ne devrait pas être porté");
			return false;
		}
		
		else return true;
	
	}

	public static boolean test8etredepose() {
		System.out.println("        Test 8");
		Robot robottest=new Robot("Jean",4);
		Outil outiltest=new Outil(5, 0, 0);
		outiltest.porteur=robottest;
		outiltest.etreDepose();
		if (outiltest.posX!=4){
			System.out.println("Mauvaise position de l'outil");
		return false;
		}
		if(outiltest.porteur!=null){
			System.out.println("l'outil n'est pas déposé");
			return false;
		}
		else return true;
	
	}
	
	public static boolean test9etredeposeporteurnull() {
		System.out.println("        Test 9");
		Robot robottest=new Robot("Jean",0);
		Outil outiltest=new Outil(5, 0, 0);
		outiltest.etreDepose();
		if (outiltest.posX==robottest.posX){
			System.out.println("Mauvaise position de l'outil");
		return false;
		}
		if(outiltest.porteur!=null){
			System.out.println("L'outil est porté");
			return false;
		}
		else return true;
		
	}
	
	public static boolean test10toString() {
		System.out.println("        Test 10");
		
		Outil outiltest=new Outil(5, 5, 2);
		String condition=("-outil(d:5,p:2)");
		String test=("-outil(d:"+outiltest.getDegats()+",p:"+outiltest.getPortee()+")");
		if(condition.compareTo(test)!=0){
			System.out.println("L'affichage est incorrect");
			return false;
		}
		return true;
		
	}
	
	public static String affichagetest(boolean test){
		if (test)return("Test concluant"+"\n");		
		else return ("Test non concluant"+"\n");
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println("Test 1: "+affichagetest(test1constructeurvide()));
		System.out.println("Test 2: "+affichagetest(test2constructeurparam()));
		System.out.println("Test 3: "+affichagetest(test3constructeurpos()));
		System.out.println("Test 4: "+affichagetest(test4changerpos()));
		System.out.println("Test 5: "+affichagetest(test5changerposporteurnull()));
		System.out.println("Test 6: "+affichagetest(test6etrepris()));
		System.out.println("Test 7: "+affichagetest(test7etreprisporteurnonnull()));
		System.out.println("Test 8: "+affichagetest(test8etredepose()));
		System.out.println("Test 9: "+affichagetest(test9etredeposeporteurnull()));
		System.out.println("Test 10: "+affichagetest(test10toString()));
		
	
	}
}
