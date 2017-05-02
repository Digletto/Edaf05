package closestPair;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class QP {

	public static void main(String[] args) {
		PointParser pp = new PointParser("test.txt");
		XyList xy = pp.parse();

		run(xy);
	}

	private static Pair run(XyList xy) {
		if (xy.size() <= 3)
			return xy.closestPair();

		XyList left = xy.left();
		XyList right = xy.right();

		Pair min = minOf(run(left), run(right));

		Line line = new Line(left.rightMostX());
		ArrayList<Point2D> center = xyCenter(xy, line, min.dist());
		Pair centerMin = next15(center);

		return minOf(centerMin, min);
	}

	private static ArrayList<Point2D> xyCenter(XyList xy, Line line, double dist) { //TODO
		ArrayList<Point2D> center = new ArrayList<Point2D>();
		ArrayList<Point2D> yList = xy.y();
		for (int i = 0; i < yList.size(); i++) {
			center.add(yList.get(i));
		}
		return null;
	}
	
	private static Pair next15(ArrayList<Point2D> center) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Pair minOf(Pair a, Pair b) {
		if (a.dist() < b.dist())
			return a;
		else
			return b;
	}
}
