package usa;

public class Road {

	private City city1, city2;
	
	public Road(City city1, City city2){
		
		this.city1 = city1;
		this.city2 = city2;
		
	}
	
	public City other(City tempCity) {
		
		if(tempCity.equals(city1)){
			
			return city2;
			
		}
		else{
			
			return city1;
			
		}
	} //edge (or connection)

	public int length() {
		// TODO Auto-generated method stub
		return 0;
	}

}
