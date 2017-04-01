package usa;

import java.io.File;
import java.util.ArrayList;

public class Prim {

	public static void main(String[] args) {
		File file = new File(args[0]); // filepath
		CityParser cp = new CityParser(file);

		ArrayList<City> cities = cp.cities();
		ArrayList<Road> roads = cp.roads();

		Path minimalPath = run(cities, roads);
		minimalPath.print();
	}

	private static Path run(ArrayList<City> cities, ArrayList<Road> roads) {
		// associates each city(node) with the number C of the length(cost) of
		// the shortest (cheapest) road (edge) to the city and the actual road that gives the cheapest road. 
		CityList cityList = new CityList(cities, roads);
		
		//Initialize empty tree/forest/list
		Path minPath = new Path();
		
		City tempCity = new City();
		while(!cityList.isEmpty()){
			tempCity = cityList.popCheapest();
			
		}
		
		
		return null;
	}

}
