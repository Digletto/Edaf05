package usa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CityParser {

	// Cities with associated list of cities sorted by distance
	private HashMap<City, ArrayList<City>> citiesMap;
	private ArrayList<Road> roads;
	private ArrayList<City> cities;
	private Scanner scan;
	
	//change when needed
	private int nbrOfCities = 128;

	public CityParser(File file) {

		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		citiesMap = new HashMap<City, ArrayList<City>>();

		scan();
	}

	public void scan() {
		
		readNames();

		readPaths();

	}

	private void readNames() {
		// TODO Auto-generated method stub

		String cityName;

		while (cities.size() <= nbrOfCities) {

			cityName = scan.nextLine();
			cities.add(new City(cityName));

		}

	}

	private void readPaths() {
		
		while (scan.hasNextLine()) {

			//add to map
			addCityDistances();
			

		}

	}

	//add city to map, sorted by distance
	private void addCityDistances() {
		
		HashMap<City, Integer> distances = new HashMap<City, Integer>();
		ArrayList<City> list;
		
		while(scan.hasNextLine()){
			
			String line = scan.nextLine();
			City currentCity = findCity(line.split("--")[0]);
			
			
			//check if the next city in line is being parsed
			if(distances.keySet().contains(currentCity)){
				
				distances = new HashMap<City, Integer>();
				
				//COPY PASTE, NOT OPTIMAL BUT NO OTHER SOLUTION
				//get list for city
				list = citiesMap.get(currentCity.getName());
				
				//read distance from city
				int distance = Integer.parseInt(line.split("[")[1]);
				
				//put city at proper index
				int a = 0;
				
				while(distances.get(list.get(a)) > distance){
					
					a++;
					
				}
				
				int j = 0;
				
				//find the city in question and put in at index a
				list.add(a, currentCity);
				
				//add road
				roads.add(new Road(currentCity, findCity(line.split("--")[1].split("[")[0])));
				currentCity.setRoadList(citiesMap.get(currentCity));
				break;
				
				
			}
			
			//get list for city
			list = citiesMap.get(currentCity.getName());
			
			//read distance from city
			int distance = Integer.parseInt(line.split("[")[1]);
			
			//put city at proper index
			int a = 0;
			
			while(distances.get(list.get(a)) > distance){
				
				a++;
				
			}
			
			int j = 0;
			
			//find the city in question and put in at index a
			list.add(a, currentCity);
			
			//add road
			roads.add(new Road(currentCity, findCity(line.split("--")[1].split("[")[0])));
			
		}
		
		
		
	}

	private City findCity(String cityName) {
		
		int i = 0;
		
		while(!cities.get(i).equals(cityName)){
			
			i++;
			
		}
		
		return cities.get(i);
	}

	public ArrayList<City> cities() {
		
		return cities;
	}

	public ArrayList<Road> roads() {
		
		
		return roads;
	}

}
