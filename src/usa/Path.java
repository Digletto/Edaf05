package usa;

import java.util.ArrayList;

public class Path {
	
	ArrayList<City> cities;
	ArrayList<Road> roads;

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

	public void add(City city) {
		cities.add(city);
	}

	public void add(Road road) {
		roads.add(road);
	}

}
