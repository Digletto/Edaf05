package matching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class sortingAlgorithm {

	//woman-man
	private HashMap<Person,Person> pairs;
	private ArrayList<ArrayList<Integer>> proposedToList;
	
	HashMap<Integer, Person> menList = new HashMap<Integer, Person>();
	HashMap<Integer, Person> womenList = new HashMap<Integer, Person>();
	Person m1;
	
	
	
	public sortingAlgorithm(){
		
		Person m1 =new Person(1,"m");
		Person m2 =new Person(3,"m'");
		Person w1 =new Person(2,"w");
		Person w2 =new Person(4,"w'");
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(7);
		
		m1.setPreferenceList(list);
		
		menList.put(1,m1);
		menList.put(3,m2);
		womenList.put(2,w1);
		womenList.put(4,w2);
		
	}
	
	public HashMap<Person,Person> sort(HashMap<Integer, Person> menList, HashMap<Integer, Person> womenList){
		
		
		
		while(allNotComplete(menList)){
			
			Person m = firstFreeMan(menList);
			Person w = firstWomanToProposeTo(m);
			
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

	private Person firstWomanToProposeTo(Person m) {
		
		ArrayList<Integer> list = m.getPreferenceList();
		int index = -1;
		
		for(Integer i : list){
			
			if(!proposedToList.get(m.nbr).contains(i)){
				
				proposedToList.get(m.nbr).add(new Integer(i));
				index = i;
				break;
				
			}
			
		}
		
		return womenList.get(index);
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
	
	public static void main(String[] args){
		
		Person m1 =new Person(1,"m");
		sortingAlgorithm sa = new sortingAlgorithm();
		//System.out.println(sa.firstPersonToPropose(m1));
		
	}
	
}
