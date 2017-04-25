package usa;

import java.util.ArrayList;

public class Path {
	
	ArrayList<Road> roads = new ArrayList<Road>();

	public void print() {
		for(Road r:roads){
			System.out.println("" + r);
		}
		System.out.println("length = " + length());
	}

	public int length() {
		int length = 0;
		for(Road r:roads)
			length = length+r.length();
		return length;
	}

	public void add(Road road) {
		roads.add(road);
	}

}
