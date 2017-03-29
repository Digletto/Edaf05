package matching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class sortingAlgorithm {

	//woman-man
	private HashMap<Person,Person> pairs;
	private ArrayList<ArrayList<Person>> proposedToList;
	
	public HashMap<Person,Person> sort(HashMap<Integer, Person> menList, HashMap<Integer, Person> womenList){
		
		
		
		while(allNotComplete(menList)){
			
			Person m = firstFreeMan(menList);
			Person w = firstWomanToProposeTo(m);
			int womanIndex = firstWomanIndex();
			
			if(w.getEngagementIndex() == -1){
				
				w.setEngagementIndex(m);
				pairs.put(w,m);
				
			}
			else{
				if(w.prefers(m)){
					pairs.remove(w);
					pairs.put(w,m);
				}
			}
			
			
		}
		
		return null;
		
	}

	//first woman on m’s list to whom m has not yet proposed
	private int firstWomanIndex() {
		
		return 0;
	}

	private Person firstWomanToProposeTo(Person m) {
		
		ArrayList<Person> list = m.getPreferenceList();
		
		for(Person p : list){
			
			
			
		}
		
		return null;
	}

	private Person firstFreeMan(HashMap<Integer, Person> manList) {
		
		for(int i = 1; i <= manList.size(); i++){
			
			if(!pairs.containsValue(manList.get(i))){
				
				return manList.get(i);
				
			}
			
		}
		
		return null;
	}

	private boolean allNotComplete(HashMap<Integer,Person> menList) {
		
		if(pairs.size() == menList.size())
			return true;
		
		return false;
	}
	
	
}
