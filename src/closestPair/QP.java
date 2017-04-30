package closestPair;

public class QP {
	

	public static void main(String[] args) {
		PointParser pp = new PointParser("test.txt");
		XyList xy = pp.parse();
		
		run(xy);
	}

	private static Pair run(XyList xy) {
		
		
		Pair min = new Pair();
		Pair leftMin = run(xy.left());
		Pair rightMin = run(xy.right());
		if(leftMin.dist() < rightMin.dist())
			min = leftMin;
		else min = rightMin;
		
		
		return null;
	}
}
