package usa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

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
		CityList cities = new CityList();

		String nxtLine = s.nextLine();
		while (!nxtLine.contains("--")) {
			City city = new City(nxtLine.trim());
			city.setShortestDist(Integer.MAX_VALUE);
			cities.add(city);
			nxtLine = s.nextLine();
		}
		return cities;
	}

	public void readAllRoads(CityList cities) {
		for (City c : cities.getQueue()) {
			restart();
			String nxtLine = s.nextLine().trim();
			while (s.hasNextLine()) {
				if(nxtLine.contains("--") && nxtLine.contains(c.getName())) {
					String[] split = nxtLine.split("--");
					City city1 = new City(split[0].trim());
					City city2 = new City(split[1].split("\\[")[0].trim());
					city1.setShortestDist(Integer.MAX_VALUE);
					city2.setShortestDist(Integer.MAX_VALUE);
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
