package libtest;

public class LogTimeOut extends Log {

	public LogTimeOut(Throwable exceptionInterne, String nomMethode) {
		// mise a jour du log
		type = "TimeOut";
		nomMethode = nomMethode;

		// indice dans le stacktrace
		int indiceLigne = 1;

		// faut voir si la methode appelee est verifier ou pas.
		StackTraceElement[] stackTrace = exceptionInterne
				.getStackTrace();
		if (stackTrace[1].getMethodName().equals("verifier")) {
			// c'est qu'il faut descendre d'un cran dans la stacktrace
			indiceLigne = 2;
		}
		classOuErreur = stackTrace[indiceLigne].getFileName();
		LigneErreur = "" + stackTrace[indiceLigne].getLineNumber();
		exception = exceptionInterne;
	}

}
