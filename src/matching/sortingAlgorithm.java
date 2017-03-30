package matching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class sortingAlgorithm {

	// woman-man
	private HashMap<Person, Person> pairs;
	private HashMap<Integer, ArrayList<Integer>> proposedToMap;

	HashMap<Integer, Person> menList = new HashMap<Integer, Person>();
	HashMap<Integer, Person> womenList = new HashMap<Integer, Person>();
	Person m1;

	public sortingAlgorithm() {

		//TODO: initialize proposedtomap properly, also all other maps and whatnot
		
		Person m1 = new Person(1, "m");
		Person m2 = new Person(3, "m'");
		Person w1 = new Person(2, "w");
		Person w2 = new Person(4, "w'");
		
		menList.put(1, m1);
		menList.put(3, m2);
		womenList.put(2, w1);
		womenList.put(4, w2);
		
		//initializing proposedtomap to have empty lists
		proposedToMap = new HashMap<Integer, ArrayList<Integer>>();
		proposedToMap.put(1, new ArrayList<Integer>());
		proposedToMap.put(3, new ArrayList<Integer>());
		
		pairs = new HashMap<Person, Person>();

	}

	public HashMap<Person, Person> sort(HashMap<Integer, Person> menList, HashMap<Integer, Person> womenList) {

		while (allNotComplete(menList)) {

			Person m = firstFreeMan();
			Person w = firstWomanToProposeTo(m);

			if (w.getEngagementIndex() == -1) {

				w.setEngagementIndex(m);
				pairs.put(w, m);

			} else {
				if (w.prefers(m)) {
					pairs.remove(w);
					w.setEngagementIndex(m);
					pairs.put(w, m);
				}
			}

		}

		return pairs;

	}

	
	//TESTED AND WORKING
	public Person firstWomanToProposeTo(Person m) {

		ArrayList<Integer> list = m.getPreferenceList();
		int index = -1;

		for (Integer i : list) {

			//Has this woman not been proposed to by this man
			if (!proposedToMap.get(m.getNbr()).contains(i)) {

					proposedToMap.get(m.getNbr()).add(new Integer(i));
					index = i;
					break;


			}

		}

		return womenList.get(index);
	}

	//Tested, working
	private Person firstFreeMan() {
		
		Set<Integer> set = menList.keySet();
		for (Integer i : set) {
			
			if (!pairs.containsValue(menList.get(i))) {

				return menList.get(i);

			}

		}

		return null;
	}

	private boolean allNotComplete(HashMap<Integer, Person> menList) {

		if (pairs.size() == menList.size())
			return true;

		return false;
	}

	public static void main(String[] args) {

//		firstFreeWoman() Test
//		Person m1 = new Person(1, "m");
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(4);
//		list.add(2);
//		
//
//		m1.setPreferenceList(list);

		sortingAlgorithm sa = new sortingAlgorithm();
		Person m = sa.firstFreeMan();
		System.out.println(m);//put (p,p) in pairs in constructor when testing
		System.out.println(sa.firstFreeMan());

	}

}
