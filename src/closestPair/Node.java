package closestPair;

public class Node {

	private double x, y;

	public Node(double x, double y) {

		this.x = x;
		this.y = y;

	}

	public double getX() {

		return x;

	}

	public double getY() {

		return y;

	}
	
	public double distanceTo(Node other){
		
		return Math.abs(Math.hypot(x - other.getX(), y - other.getY()));
		
	}

}
