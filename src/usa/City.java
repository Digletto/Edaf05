package usa;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class City {// node (or vertex)

	private String name;
	private City parent;
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
		return roads.get(0);
	}

	public void setRoadList(ArrayList<City> cities) {
		for (City c : cities) {
			roads.put(this, new Road(this, c));
		}
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

	public void setParent(City parent) {
		this.parent = parent;
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
}
