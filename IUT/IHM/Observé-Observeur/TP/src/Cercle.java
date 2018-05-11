import java.util.Observable;


public class Cercle extends Observable {

	int x,y;
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int newX){
		x = newX;
		setChanged();
		notifyObservers();
	}
	
	public void setY(int newY){
		y = newY;
		setChanged();
		notifyObservers();

	}
}
