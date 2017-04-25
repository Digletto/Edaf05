package usa;

//edge (or connection)
public class Road {

	private City city1, city2;
	private int length = 0;

	public Road(City city1, City city2) {
		this.city1 = city1;
		this.city2 = city2;
	}

	public City other(City tempCity) {

		if (tempCity.getName().equals(city1.getName())) {
			return city2;
		} else {
			return city1;
		}
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int length() {
		return length;
	}

	@Override
	public boolean equals(Object o) {

		Road otherRoad = (Road) o;
		return (city1.equals(otherRoad.city1) && city2.equals(otherRoad.city2))
				|| (city2.equals(otherRoad.city1) && city1.equals(otherRoad.city2));
	}
	
	@Override
	public String toString() {
		String string;
		string = city1.getName() + " -- " + city2.getName() + " [" + length + "]";
		return string;
	}

}
