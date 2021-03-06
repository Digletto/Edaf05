package closestPair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class XyList {

	// Points sorted by x
	private ArrayList<Node> xList = new ArrayList<Node>();
	// Points sorted by y
	private ArrayList<Node> yList = new ArrayList<Node>();

	// Only in first recursive step
	public XyList(ArrayList<Node> list) {

		Collections.sort(list, new xComparator());
		xList.addAll(list);
		Collections.sort(list, new yComparator());
		yList.addAll(list);
	}

	// Used in remaining recursive steps
	public XyList(ArrayList<Node> xList, ArrayList<Node> yList) {

		this.xList = xList;
		this.yList = yList;
	}

	public XyList left() {

		ArrayList<Node> newXLx = new ArrayList<Node>();
		ArrayList<Node> newXLy = new ArrayList<Node>();

		// Make a new XyList consisting of first half of xList and yList
		newXLx.addAll(xList.subList(0, (xList.size()) / 2));
		newXLy.addAll(newXLx);
		Collections.sort(newXLy, new yComparator());
		return new XyList(newXLx, newXLy);
	}

	public XyList right() {

		ArrayList<Node> newXLx = new ArrayList<Node>();
		ArrayList<Node> newXLy = new ArrayList<Node>();

		// Make a new XyList consisting of second half of xList and yList
		newXLx.addAll(xList.subList((xList.size()) / 2, xList.size()));
		newXLy.addAll(newXLx);
		Collections.sort(newXLy, new yComparator());
		return new XyList(newXLx, newXLy);
	}

	public double rightMostX() {
		return xList.get(xList.size() - 1).getX();
	}

	public ArrayList<Node> y() { // y ordered list
		return yList;
	}

	public Pair next15() {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		return xList.size();
	}

	public Pair closestPair() {

		if (xList.size() == 2) {
			return new Pair(xList.get(0), xList.get(1));
		} else {
			Pair min = new Pair(xList.get(0), xList.get(1));
			if (xList.get(0).distanceTo(xList.get(2)) < min.dist())
				min = new Pair(xList.get(0), xList.get(2));
			if (xList.get(1).distanceTo(xList.get(2)) < min.dist())
				min = new Pair(xList.get(1), xList.get(2));
			return min;
		}
	}

	class xComparator implements Comparator<Node> {
		@Override
		public int compare(Node p1, Node p2) {
			if (p1.getX() < p2.getX())
				return -1;
			if (p1.getX() > p2.getX())
				return 1;
			return 0;
		}
	}

	class yComparator implements Comparator<Node> {
		@Override
		public int compare(Node p1, Node p2) {
			if (p1.getY() < p2.getY())
				return -1;
			if (p1.getY() > p2.getY())
				return 1;
			return 0;
		}
	}
}
