package usa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CityList {

	private PriorityQueue<City> cityQueue;

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

	public City peekCheapest() {
		return cityQueue.peek();
	}

	public void remove(City c) {
		cityQueue.remove(c);
	}

}
