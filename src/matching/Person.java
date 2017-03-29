package matching;

import java.util.ArrayList;

public class Person {

	String name;
	int nbr;
	int engagementIndex= -1;

	public Person(int i, String string) {
		nbr = i;
		name = string;
	}

	public int getEngagementIndex(){
		
		return engagementIndex;
		
	}

	//SET INDEX TO INDEX OF RECIEVED PERSON IN PREFERENCE LIST
	public void setEngagementIndex(Person m) {
		
		
	}

	public boolean prefers(Person m) {
		return false;
	}

	public ArrayList<Person> getPreferenceList() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getNbr() {
		return nbr;
	}
	
}
