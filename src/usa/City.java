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
		// TODO Auto-generated method stub
		return null;
	}
	
	public void setRoadList(ArrayList<City> cities){
		
		for(City c : cities){
			
			roads.add(new Road(this, c));
			
		}
		
	}

	public ArrayList<Road> roads() {
		// TODO Auto-generated method stub
		return null;
	}

	public int shortestDistance() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void changeCheapestRoad(Road r) { // remove cheaper roads??
		// TODO Auto-generated method stub
		
	}
	
	@Override 
	public boolean equals(Object otherCity){
		
		City tempCity = (City)otherCity;
		return tempCity.getName().equals(name);
		
	}
}
