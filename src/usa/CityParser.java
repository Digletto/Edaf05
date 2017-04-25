package usa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CityParser {

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

	private void restart() {
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public CityList readCities() {
		restart();
		ArrayList<City> cities = new ArrayList<City>();
		HashMap<String, City> cityMap = new HashMap<String, City>();

		String nxtLine = s.nextLine();
		while (!nxtLine.contains("--")) {
			City city = new City(nxtLine.trim());
			city.setShortestDist(Integer.MAX_VALUE);
			cities.add(city);
			cityMap.put(city.getName(), city);
			nxtLine = s.nextLine();
		}
		readAllRoads(cityMap, cities);
		return new CityList(cities);
	}

	public void readAllRoads(HashMap<String, City> cityMap, ArrayList<City> cities) {
		for (City c : cities) {
			restart();
			String nxtLine = s.nextLine().trim();
			while (s.hasNextLine()) {
				if(nxtLine.contains("--") && nxtLine.contains(c.getName())) {
					String[] split = nxtLine.split("--");
					City city1 = cityMap.get(split[0].trim());
					City city2 = cityMap.get(split[1].split("\\[")[0].trim());
					Road road = new Road(city1, city2);
					road.setLength(Integer.parseInt(split[1].split("\\[")[1].split("\\]")[0]));
					c.addRoad(road);
					c.addConnection(road.other(c));
				}
				nxtLine = s.nextLine();
			}
		}
	}
}
