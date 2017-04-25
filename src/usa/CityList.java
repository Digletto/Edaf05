package usa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Map.Entry;

import matching.Person;

public class CityList {

	private PriorityQueue<City> cityQueue;
	private City connection;

	public CityList(ArrayList<City> cities) {
		cityQueue = new PriorityQueue<City>(new Comparator<City>() {
			public int compare(City c1, City c2) {
				return Integer.compare(c1.shortestDistance(), c2.shortestDistance());
			}
		});
		
		for (City c : cities) {
			cityQueue.add(c);
		}
	}

	public CityList() {
		cityQueue = new PriorityQueue<City>(new Comparator<City>() {
			public int compare(City c1, City c2) {
				return Integer.compare(c1.shortestDistance(), c2.shortestDistance());
			}
		});
	}

	public boolean isEmpty() {
		return cityQueue.size() == 0;
	}

	public City popCheapest() {
		return cityQueue.poll();
	}

	public boolean contains(City adjecentCity) {
		return cityQueue.contains(adjecentCity);
	}

	public void add(City city) {
		cityQueue.add(city);
	}

	public City connection() {
		return connection;
	}

	public void maxOutShortest() {
	}
	
	public PriorityQueue<City> getQueue() {
		return cityQueue;
	}

	public City peekCheapest() {
		return cityQueue.peek();
	}

}
