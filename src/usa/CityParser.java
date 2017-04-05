package usa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class CityParser {

	// Cities with associated list of cities sorted by distance
	private Scanner s;
	private File file;

	public CityParser(String path) {
		file = new File(path);
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public PriorityQueue<City> readCities() {
		restart();
		PriorityQueue<City> cities = new PriorityQueue<City>();
		
		String nxtLine = s.nextLine();
		while (!nxtLine.contains("--")) {
			cities.add(new City(nxtLine));
			nxtLine = s.nextLine();
		}
		
		readRoads(cities);
		return cities;
	}

	private void restart() {
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void readRoads(PriorityQueue<City> cities) {
		String nxtLine;
		
		for(City c:cities){
			restart();
			while(!(nxtLine = s.nextLine()).contains(c.getName()));
			while(nxtLine.contains(c.getName())){
				//TODO
			}
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
