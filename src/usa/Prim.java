package usa;

import java.io.File;
import java.util.ArrayList;

public class Prim {

	public static void main(String[] args) {
		File file = new File(args[0]); 			//filepath
		CityParser cp = new CityParser(file);
		
		ArrayList<City> cities = cp.cities();
		ArrayList<Road> roads = cp.roads();
		
		CityList cityList = new CityList(cities, roads);
		run(cityList);
	}

	private static Path run(CityList cityList) {
		
		return null;
	}

}
