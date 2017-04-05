package matching;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class sortingAlgorithm {

	// woman-man
	private HashMap<Person, Person> pairs;
	HashMap<Integer, Person> menList = new HashMap<Integer, Person>();
	HashMap<Integer, Person> womenList = new HashMap<Integer, Person>();
	Person m1;

	public sortingAlgorithm(HashMap<Integer, Person> menList, HashMap<Integer, Person> womenList) {
		
		pairs = new HashMap<Person, Person>();

		this.menList = menList;
		this.womenList = womenList;
		
	}
	

	public HashMap<Person, Person> sort() {

		while (!allComplete()) {
			Person m = firstFreeMan();
			Person w = propose(m);
			
			if (!w.isEngaged()) {
				w.setEngagementIndex(m);
				w.setEngagementStatus(true);
				m.setEngagementStatus(true);
				pairs.put(w, m);
			} else {
				if (w.prefers(m)) {
					pairs.get(w).setEngagementStatus(false);
					pairs.remove(w);
					w.setEngagementIndex(m);
					m.setEngagementStatus(true);
					pairs.put(w, m);
				}
				else{
					
					m.setEngagementStatus(false);
					
				}
			}
		}
		return pairs;
	}

	public Person propose(Person m) {
		
		//find first woman to propose to
		Person w = womenList.get(m.getNextWoman());

		return w;
	}

	private Person firstFreeMan() {

		Set<Integer> set = menList.keySet();
		int index = -1;
		for (Integer i : set) {

			if(!menList.get(i).isEngaged){
				
				index = i;
				break;
				
			}
			
		}

		return menList.get(index);
	}

	private boolean allComplete() {

		return pairs.size() == menList.size();

	}

	public static void main(String[] args) {
		ParseFile pf = new ParseFile(args[0]);
		HashMap<Integer, Person> men = CreateMen(pf);
		HashMap<Integer, Person> women = CreateWomen(pf);

		sortingAlgorithm sa = new sortingAlgorithm(men, women);

		HashMap<Person, Person> result = sa.sort();
		printPairs(result);
	}

	private static void printPairs(HashMap<Person, Person> result) {
		Set<Entry<Person,Person>> set = result.entrySet();
		ArrayList<Entry<Person,Person>> list = new ArrayList<Entry<Person,Person>>(set);
		Collections.sort( list, new Comparator<Entry<Person, Person>>()
        {
            public int compare( Entry<Person, Person> o1, Entry<Person, Person> o2 )
            {
                return Integer.compare(o1.getValue().getNbr(), o2.getValue().getNbr());
            }
        } );
		
		for (Entry<Person,Person> e: list) {

			
			System.out.println(e.getValue() + " -- " + e.getKey());

		}
	}

	private static HashMap<Integer, Person> CreateWomen(ParseFile pf) {
		return createPersons(1, pf);
	}

	private static HashMap<Integer, Person> createPersons(int j, ParseFile pf) {
		ArrayList<Person> persons = new ArrayList<Person>();
		if (j == 0)
			persons = pf.parseMen();
		else
			persons = pf.parseWomen();
		pf.setPreferences(persons);
		HashMap<Integer, Person> map = new HashMap<Integer, Person>();
		for (Person p : persons)
			map.put(p.getNbr(), p);
		return map;
	}

	private static HashMap<Integer, Person> CreateMen(ParseFile pf) {

		return createPersons(0, pf);
	}

}
