package closestPair;

import java.util.ArrayList;

public class QP {

	public static void main(String[] args) {
		//PointParser pp = new PointParser("tests/closest/close-pairs-5-in.txt");
		//XyList xy = pp.parse();
		
		ArrayList<Node> temp = new ArrayList<Node>();
		temp.add(new Node(25,20));
		temp.add(new Node(25,25));
		temp.add(new Node(4,10));
		temp.add(new Node(2,-10));
		temp.add(new Node(-10,-10));
		temp.add(new Node(-42,3));
		
		XyList xy = new XyList(temp);
		Pair result = run(xy);
		System.out.println(result.toString());
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
		//Double dist = Double.MAX_VALUE;
		Pair min = new Pair(new Node(Double.MAX_VALUE, Double.MAX_VALUE), new Node(Double.MIN_VALUE, Double.MIN_VALUE));

		for (int i = 0; i < center.size(); i++) {
			Node temp = center.get(i);
			for (int j = 1; j < 16; j++) {
				if ((i+j+1) >= center.size()) break;
				if (temp.distanceTo(center.get(i+j)) < min.dist()) {
					min = new Pair(temp, center.get(i+j));
					//dist = min.dist();
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
