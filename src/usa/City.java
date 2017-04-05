package usa;

import java.util.ArrayList;
import java.util.List;

public class City {//node (or vertex)

	private String name;
	private ArrayList<Road> roads;
	
	public City(String name){
		
		this.name = name;
		roads = new ArrayList<Road>();
		
	}
	
	public String getName(){
		
		return name;
		
	}
	
	public Road cheapestRoad() {
		return roads.get(0);
	}
	
	public void setRoadList(ArrayList<City> cities){
		
		for(City c : cities){
			
			roads.add(new Road(this, c));
			
		}
		
	}

	public ArrayList<Road> roads() {
		return roads;
	}

	public int shortestDistance() {
		return roads.get(0).length();
	}

	public void changeCheapestRoad(Road r) { // remove cheaper roads??
		
		//removing cheaper roads TODO
		
	}
	
	@Override 
	public boolean equals(Object otherCity){
		
		City tempCity = (City)otherCity;
		return tempCity.getName().equals(name);
		
	}
}
