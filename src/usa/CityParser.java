package usa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CityParser {

	// Cities with associated list of cities sorted by distance
	private Scanner scan;
	private File file;

	public CityParser(String path) {
		file = new File(path);
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public  readCities() {
		// TODO Auto-generated method stub
		String cityName;
		while (cities.size() <= nbrOfCities) {
			cityName = scan.nextLine();
			cities.add(new City(cityName));
		}

	}

	private void readRoads() {

		for(City c : cities){

			addCityDistances();

		}

	}

	// add city to map, sorted by distance
	private void addCityDistances() {
		
		

	}

	private City findCity(String cityName) {

		int i = 0;

		while (!cities.get(i).equals(cityName)) {

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
