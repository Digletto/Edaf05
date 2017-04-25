package usa;

import java.util.ArrayList;
import java.util.HashMap;

public class City {// node (or vertex)

	private String name;
	private Road cheapestRoad;
	private HashMap<City, Road> roads;
	private int shortestDistance;
	private ArrayList<City> connections = new ArrayList<City>();

	public City(String name) {
		this.name = name;
		roads = new HashMap<City, Road>();
	}

	public String getName() {
		return name;
	}

	public Road cheapestRoad() {
		return cheapestRoad;
	}

	public HashMap<City, Road> roads() {
		return roads;
	}

	public int shortestDistance() {
		return shortestDistance;
	}

	@Override
	public boolean equals(Object otherCity) {
		City tempCity = (City) otherCity;
		return tempCity.getName().equals(name);
	}

	public void setShortestDist(int i) {
		shortestDistance = i;
	}

	public ArrayList<City> connections() {
		return connections;
	}

	public Road getRoad(City c) {
		return roads.get(c);
	}

	public void addRoad(Road r) {
		roads.put(r.other(this), r);
	}

	public void addConnection(City city) {
		connections.add(city);
	}

	public void setCheapestRoad(Road r) {
		cheapestRoad = r;
	}
}
