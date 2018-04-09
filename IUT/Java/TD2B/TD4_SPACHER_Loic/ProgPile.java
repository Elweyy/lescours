/**
 * un programme simple avec une Pile
 */
public class ProgPile {

	/**
	 * programme principal
	 * @param args param inutilise
	 */
	public static void main(String[] args) {
		//instruction 1
		Pile p=new PileReference();
		//instruction 2
		p.empiler(1);
		//instruction 3
		p.empiler(2);
		//instruction 4
		p.depiler();
		int a=p.sommet();
		//a vaut 1
		System.out.println(a);
	}
}
