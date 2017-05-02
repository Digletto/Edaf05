package closestPair;
import java.awt.geom.Point2D;

public class Pair {

	private Node a;
	private Node b;
	
	public Pair(Node a, Node b){
		this.a = a;
		this.b = b;
	}
	
	public double dist() {
		return a.distanceTo(b);	}

	@Override
	public String toString() {
		return "a = " + a + " b = " + b + " Distance: " + dist();
	}

}
