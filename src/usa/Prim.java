package usa;

public class Prim {

	public static void main(String[] args) {
		CityParser cp = new CityParser("USA-highway-miles.in.txt");
		
		//System.out.println("" + Integer.compare(2, 1));

		CityList cities = cp.readCities();

		Path minimalPath = run(cities);
		minimalPath.print();
	}

	private static Path run(CityList cityList) {

		Path minPath = new Path();
		City temp = cityList.popCheapest();
		temp.setShortestDist(0);
		temp.setCheapestRoad(null);
		cityList.add(temp);

		City currentCity;
		Road currentRoad;

		while (!cityList.isEmpty()) {
			currentCity = cityList.popCheapest();
			if(currentCity.cheapestRoad() != null)
				minPath.add(currentCity.cheapestRoad());
			
			for (City c : currentCity.connections()) {
				currentRoad = currentCity.getRoad(c);
				if (cityList.contains(c) && (currentRoad.length() < c.shortestDistance())) {
					cityList.remove(c);
					c.setCheapestRoad(currentRoad);
					c.setShortestDist(currentRoad.length());
					cityList.add(c);
				}
			}
		}
		return minPath;
	}
}
