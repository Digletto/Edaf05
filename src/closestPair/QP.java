package closestPair;

import java.util.ArrayList;

public class QP {

	public static void main(String[] args) {
		PointParser pp = new PointParser("tests/closest/close-pairs-5-in.txt");
		XyList xy = pp.parse();

		run(xy);
	}

	private static Pair run(XyList xy) {
		if (xy.size() <= 3)
			return xy.closestPair();

		XyList left = xy.left();
		XyList right = xy.right();

		Pair min = minOf(run(left), run(right));

		// Line line = new Line(left.rightMostX());
		ArrayList<Node> center = xyCenter(xy, left.rightMostX(), min.dist());
		Pair centerMin = next15(center);

		return minOf(centerMin, min);
	}

	private static ArrayList<Node> xyCenter(XyList xy, double line, double dist) {
		ArrayList<Node> center = new ArrayList<Node>();
		ArrayList<Node> yList = xy.y();
		Node temp = new Node(0, 0);

		for (int i = 0; i < yList.size(); i++) {
			temp = yList.get(i);
			if (temp.getX() > (line - dist) && temp.getX() < (line + dist))
				center.add(temp);
		}
		return center;
	}

	private static Pair next15(ArrayList<Node> center) {
		Double dist = Double.MAX_VALUE;
		Pair min = null;

		for (int i = 0; i < center.size(); i++) {
			Node temp = center.get(i);
			for (int j = 1; j < 16; j++) {
				if (temp.distanceTo(center.get(i+j)) < dist) {
					min = new Pair(temp, center.get(i+j));
					dist = min.dist();
				}
			}
		}
		return min;
	}

	private static Pair minOf(Pair a, Pair b) {
		if (a.dist() < b.dist())
			return a;
		else
			return b;
	}
}
