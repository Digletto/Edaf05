package usa;

import java.util.ArrayList;

public class City {//node (or vertex)

	private String name;
	
	public City(String name){
		
		this.name = name;
		
	}
	
	public String getName(){
		
		return name;
		
	}
	
	public Road cheapestRoad() {
		// TODO Auto-generated method stub
		return null;
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
