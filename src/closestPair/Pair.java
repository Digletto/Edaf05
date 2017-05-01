package closestPair;
import java.awt.geom.Point2D;

public class Pair {

	private Point2D a;
	private Point2D b;
	
	public Pair(Point2D a, Point2D b){
		this.a = a;
		this.b = b;
	}
	
	public double dist() {
		return a.distance(b);	}

}
