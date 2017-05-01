package closestPair;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class XyList {
	
	//Points sorted by x
	private List<Point2D> xList;
	//Points sorted by y
	private List<Point2D> yList;
	
	
	//Only in first recursive step
	public XyList(ArrayList<Point2D> list){
		
		Collections.sort(list, new xComparator());
		xList = list;
		Collections.sort(list, new yComparator());
		yList = list;
		
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
		//TODO:
		return null;
	}

	public Pair next15() {
		// TODO Auto-generated method stub
		return null;
	}

	public int size() {
		return xList.size();
	}

	public Pair closestPair() {
		
		if(xList.size() == 2){
			
			return new Pair(xList.get(0), xList.get(1));
			
		}
		else{
			
			Pair min = new Pair(xList.get(0), xList.get(1));
			
			for(Point2D p1 : xList){
				
				for(Point2D p2 : xList){
				
					if((new Pair(p1,p2)).dist() <min.dist())
						min = new Pair(p1,p2);
					
				}
				
			}
			
			return min;
			
		}
		
	}
	
	class xComparator implements Comparator<Point2D> {
	    @Override
	    public int compare(Point2D p1, Point2D p2) {
	        if (p1.getX() < p2.getX()) return -1;
	        if (p1.getX() > p2.getX()) return 1;
	        return 0;
	    }    
	}
	
	class yComparator implements Comparator<Point2D> {
	    @Override
	    public int compare(Point2D p1, Point2D p2) {
	        if (p1.getY() < p2.getY()) return -1;
	        if (p1.getY() > p2.getY()) return 1;
	        return 0;
	    }    
	}

}
