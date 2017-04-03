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
		
		String line;
		String cityName;
		int distance;
		
		while (scan.hasNextLine()) {

			//add to map
			addCityDistances();
			

		}

	}

	//add city to map, sorted by distance
	private void addCityDistances() {
		
		HashMap<City, Integer> distances = new HashMap<City, Integer>();
		
		for(int i = 0; i < nbrOfCities; i++){
			
			String line = scan.nextLine();
			ArrayList<City> list = citiesMap.get(line.split("--")[0]);
			int distance = Integer.parseInt(line.split("[")[1]);
			int a = 0;
			
			while(distances.get(list.get(a)) > distance){
				
				a++;
				
			}
			// FINISH LIST PLZ
			
		}
		
	}

	public ArrayList<City> cities() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Road> roads() {
		// TODO Auto-generated method stub
		return null;
	}

}
