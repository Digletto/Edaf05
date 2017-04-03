package matching;

import java.util.ArrayList;

public class Person {

	String name;
	int nbr;
	int engagementIndex= -1;
	ArrayList<Integer> preferenceList;

	public Person(int i, String string) {
		nbr = i;
		name = string;
		engagementIndex = -1;
		preferenceList = new ArrayList<Integer>();
	}
	
	public void setPreferenceList(ArrayList<Integer> list){
		
		preferenceList.addAll(list);
		
	}

	public int getEngagementIndex(){
		
		return engagementIndex;
		
	}

	//SET INDEX TO INDEX OF RECIEVED PERSON IN PREFERENCE LIST
	public void setEngagementIndex(Person m) {
		
		engagementIndex = getIndex(m);
		
	}

	private int getIndex(Person m) {
		
		return preferenceList.indexOf(m.getNbr());
	}

	public boolean prefers(Person m) {
		if(getIndex(m) < engagementIndex){
			
			return true;
			
		}
		
		return false;
	}

	public ArrayList<Integer> getPreferenceList() {
		return preferenceList;
	}

	public int getNbr() {
		return nbr;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object o){
		
		Person temp = (Person)o;
		return temp.getNbr() == nbr;
		
	}
	
	@Override
	public String toString(){
		
		return name;
		
	}
	
}
