package usa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import usa.FibonacciHeap.Node;

public class CityList {

	private FibonacciHeap cityQueue;
	private Comparator<City> comp = new Comparator<City>() {
		public int compare(City c1, City c2) {
			return Integer.compare(c1.shortestDistance(), c2.shortestDistance());
		}
	};
	
	private HashMap<City, Node> nodeMap = new HashMap<City, Node>();

	public CityList(ArrayList<City> cities) {
		cityQueue = new FibonacciHeap();
		
		for (City c : cities) {
			add(c);
		}
	}

	public CityList() {
		cityQueue = new FibonacciHeap();
	}

	public boolean isEmpty() {
		return cityQueue.isEmpty();
	}

	public City popCheapest() {
		return (City)cityQueue.removeMin();
	}

	public void add(City city) {
		nodeMap.put(city, cityQueue.insert(city, city.shortestDistance()));
	}

	public void remove(City c) {
		cityQueue.delete(nodeMap.get(c));
	}

	public void decreaseKey(City c) {
		cityQueue.decreaseKey(nodeMap.get(c), c, c.shortestDistance());
	}

}
