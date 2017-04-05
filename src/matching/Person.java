package matching;

import java.util.ArrayList;
import java.util.HashMap;

public class Person {

	String name;
	int nbr;
	int engagementIndex = 0;
	ArrayList<Integer> preferenceList;
	boolean isEngaged = false;
	
	// person.nbr - index
	HashMap<Integer, Integer> preferenceMap;

	public Person(int i, String string) {
		nbr = i;
		name = string;
		engagementIndex = -1;
		preferenceList = new ArrayList<Integer>();
		preferenceMap = new HashMap<Integer, Integer>();

	}

	public void setPreferenceList(ArrayList<Integer> list) {

		preferenceList.addAll(list);

		for (int i : list) {

			preferenceMap.put(i, list.indexOf(i));

		}

	}

	public int getEngagementIndex() {

		return engagementIndex;

	}
	
	public void setEngagementStatus(boolean status){
		
		this.isEngaged = status;
		
	}

	public boolean isEngaged() {

		return isEngaged;

	}

	// SET INDEX TO INDEX OF RECIEVED PERSON IN PREFERENCE LIST
	public void setEngagementIndex(Person m) {

		engagementIndex = getIndex(m);

	}

	public void setEngagementIndex(int i) {

		engagementIndex = i;

	}

	public int incrementEngagementIndex() {
 
		engagementIndex++;
		return engagementIndex;

	}

	public int getIndex(Person m) {

		return preferenceMap.get(m.nbr);
	}

	public boolean prefers(Person m) {
		if (preferenceMap.get(m.getNbr()) < engagementIndex) {
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
	public boolean equals(Object o) {

		Person temp = (Person) o;
		return temp.getNbr() == nbr;

	}

	@Override
	public String toString() {

		return name;

	}

	public int getNextWoman() {
		
		return preferenceList.get(incrementEngagementIndex());
	}

}
