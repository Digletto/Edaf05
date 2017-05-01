package closestPair;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class XyList {
	
	//Points sorted by x
	private List<Point2D> xList;
	//Points sorted by y
	private List<Point2D> yList;
	
	
	//Only in first recursive step
	public XyList(ArrayList<Point2D> list){
		
		//TODO: SORT list into xList and yList
		
	}
	
	//Used in remaining recursive steps
	public XyList(List<Point2D> xList, List<Point2D> yList){
		
		this.xList = xList;
		this.yList = yList;
		
	}
	
	public XyList left() {
		
		List<Point2D> newXLx = new ArrayList<Point2D>();
		List<Point2D> newXLy = new ArrayList<Point2D>();
		
		
		//Make a new XyList consisting of first half of xList and yList
		newXLx.addAll(xList.subList(0, (xList.size()-1)/2));
		newXLy.addAll(xList.subList(0, (yList.size()-1)/2));
		return new XyList(newXLx, newXLy);
	}

	public XyList right() {
		
		List<Point2D> newXLx = new ArrayList<Point2D>();
		List<Point2D> newXLy = new ArrayList<Point2D>();
		
		
		//Make a new XyList consisting of second half of xList and yList
		newXLx.addAll(xList.subList((xList.size()-1)/2, xList.size()-1));
		newXLy.addAll(xList.subList((yList.size()-1)/2, yList.size()-1));
		return new XyList(newXLx, newXLy);
		
	}

	public double rightMostX() {
		return xList.get(xList.size()-1).getX();
	}

	public List<Pair> y() { // y ordered list
		// TODO Auto-generated method stub
		return null;
	}

	public Pair next15() {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return xList.size();
	}

	public Pair closestPair() {
		//TODO
		return null;
	}

}
