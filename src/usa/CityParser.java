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

	public CityParser(File file) {

		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		scan();
	}

	public void scan() {
		
		readNames();

		readPaths();

	}

	private void readNames() {
		// TODO Auto-generated method stub

		String cityName;

		while (cities.size() <= 128) {

			cityName = scan.nextLine();
			cities.add(new City(cityName));

		}

	}

	private void readPaths() {
		
		String line;
		String cityName;
		int distance;
		
		while (cities.size() <= 128) {

			line = scan.nextLine();
			
			//read first part
			cityName = line.split("--")[0];
			
			//read second part
			distance = Integer.parseInt(line.split("[")[1]);
			
			//FIX REST

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
