package usa;

import java.io.File;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prim {

	public static void main(String[] args) {
		CityParser cp = new CityParser("USA-highway-miles.in.txt");

		CityList cities = cp.readCities();
		cp.readAllRoads(cities);

		Path minimalPath = run(cities);
		minimalPath.print();
	}

	private static Path run(CityList cityList) {

		Path minPath = new Path();
		//cityList.maxOutShortest();
		City temp = cityList.peekCheapest();
		temp.setShortestDist(0);
		temp.setParent(null);

		City currentCity;
		Road currentRoad;

		while (!cityList.isEmpty()) {
			currentCity = cityList.popCheapest();

			for (City c : currentCity.connections()) {
				currentRoad = currentCity.getRoad(c);
				if (cityList.contains(c) &&  (currentRoad.length() < c.shortestDistance())) {
					c.setParent(currentCity);
					c.setShortestDist(currentRoad.length());
					minPath.add(currentRoad);
				}
			}
		}
		return minPath;
	}
}
