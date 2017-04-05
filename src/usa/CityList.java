package usa;

import java.util.ArrayList;
import java.util.Stack;

public class CityList {

	private ArrayList<City> fullCityList;
	private Stack<City> cityStack;
	
	// Associate with each vertex v of the graph a number C[v] (the cheapest
	// cost of a connection to v) and an edge E[v] (the edge providing that
	// cheapest connection). To initialize these values, set all values of C[v]
	// to infinity (or to any number larger than the maximum edge weight) and set each
	// E[v] to a special flag value indicating that there is no edge connecting
	// v to earlier vertices.
	public CityList(ArrayList<City> cities, ArrayList<Road> roads) {
		// TODO take the contents of the arraylist found in CityParser
		cityStack = new Stack<City>();
		
		for(City c : cities){
			cityStack.push(c);
		}
	}

	public boolean isEmpty() {
		return cityStack.size() == 0;
	}

	public City popCheapest() {
		
		return cityStack.pop();
	}

	public boolean contains(City adjecentCity) {
		return cityStack.contains(adjecentCity);
	}

}
