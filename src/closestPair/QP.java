package closestPair;

public class QP {

	public static void main(String[] args) {
		PointParser pp = new PointParser("test.txt");
		XyList xy = pp.parse();

		run(xy);
	}

	private static Pair run(XyList xy) {

		if (xy.size() <= 3)
			return xy.smallestDist();

		XyList left = xy.left();
		XyList right = xy.right();

		Pair min = minOf(run(left), run(right));

		Line line = new Line(left.rightMostX());
		XyList center = xyCenter(xy, line, min.dist());
		Pair centerMin = center.next15();

		if (centerMin.dist() < min.dist())
			return centerMin;
		else
			return min;
	}

	private static XyList xyCenter(XyList xy, Line line, int dist) {
		return null;
	}

	private static Pair minOf(Pair leftMin, Pair rightMin) {
		if (leftMin.dist() < rightMin.dist())
			return leftMin;
		else
			return rightMin;
	}
}
