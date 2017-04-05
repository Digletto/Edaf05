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

	// Associate with each vertex v of the graph a number C[v] (the cheapest
	// cost of a connection to v) and an edge E[v] (the edge providing that
	// cheapest connection). To initialize these values, set all values of C[v]
	// to infinity (or to any number larger than the maximum edge weight) and
	// set each
	// E[v] to a special flag value indicating that there is no edge connecting
	// v to earlier vertices.
	public CityList(ArrayList<City> cities) {
		cityQueue = new PriorityQueue<City>(new Comparator<City>()
        {	public int compare(City c1, City c2)
            {	return Integer.compare(c1.shortestDistance(), c2.shortestDistance());}});
		
		for(City c : cities){
			cityQueue.of
		}
	}

	public boolean isEmpty() {
		return cityQueue.size() == 0;
	}

	public City popCheapest() {

		return cityQueue.pop();
	}

	public boolean contains(City adjecentCity) {
		return cityQueue.contains(adjecentCity);
	}

}
