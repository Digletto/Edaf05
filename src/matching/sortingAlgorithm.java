package matching;

import java.io.File;
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

	public sortingAlgorithm(HashMap<Integer, Person> menList, HashMap<Integer, Person> womenList) {

		// initialize proposedtomap properly, also all other maps and
		// whatnot

		// Person m1 = new Person(1, "m");
		// Person m2 = new Person(3, "m'");
		// Person w1 = new Person(2, "w");
		// Person w2 = new Person(4, "w'");
		//
		// menList.put(1, m1);
		// menList.put(3, m2);
		// womenList.put(2, w1);
		// womenList.put(4, w2);
		//
		// ArrayList<Integer> tempPrefList = new ArrayList<Integer>();
		// tempPrefList.add(2);
		// tempPrefList.add(4);
		// m1.setPreferenceList(tempPrefList);
		// m2.setPreferenceList(tempPrefList);
		// tempPrefList.clear();
		// tempPrefList.add(1);
		// tempPrefList.add(3);
		// w1.setPreferenceList(tempPrefList);
		// w2.setPreferenceList(tempPrefList);
		//
		// //initializing proposedtomap to have empty lists
		// proposedToMap = new HashMap<Integer, ArrayList<Integer>>();
		// proposedToMap.put(1, new ArrayList<Integer>());
		// proposedToMap.put(3, new ArrayList<Integer>());
		//
		
		pairs = new HashMap<Person, Person>();

		this.menList = menList;
		this.womenList = womenList;
		initializeProposedToList();
	}

	private void initializeProposedToList() {

		proposedToMap = new HashMap<Integer, ArrayList<Integer>>();
		Set<Integer> set = menList.keySet();

		for (Integer i : set) {

			proposedToMap.put(i, new ArrayList<Integer>());

		}

	}

	public HashMap<Person, Person> sort() {

		while (!allComplete()) {

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

	// TESTED AND WORKING
	public Person firstWomanToProposeTo(Person m) {

		ArrayList<Integer> list = m.getPreferenceList();
		int number = -1;

		for (Integer i : list) {

			// Has this woman not been proposed to by this man
			if (!proposedToMap.get(m.getNbr()).contains(i)) {

				proposedToMap.get(m.getNbr()).add(new Integer(i));
				number = i;
				break;

			}

		}

		return womenList.get(number);
	}

	// Tested, working
	private Person firstFreeMan() {

		Set<Integer> set = menList.keySet();
		for (Integer i : set) {

			if (!pairs.containsValue(menList.get(i))) {

				return menList.get(i);

			}

		}

		return null;
	}

	private boolean allComplete() {

		Set<Integer> set = proposedToMap.keySet();
		boolean isDone = false;

		if (set.size() == menList.size()) {

			for (Integer i : set) {

				if (menList.get(i).preferenceList.size() == pairs.size()) {

					isDone = true;
					break;

				}

			}

		}

		return isDone;

	}

	public static void main(String[] args) {
		ParseFile pf = new ParseFile("tests/sm-random-50-in.txt"); //TODO: args[0]
		HashMap<Integer, Person> men = CreateMen(pf);
		HashMap<Integer, Person> women = CreateWomen(pf);

		sortingAlgorithm sa = new sortingAlgorithm(men, women);

		HashMap<Person, Person> result = sa.sort();
		printPairs(result);
		// firstFreeWoman() Test
		// Person m1 = new Person(1, "m");
		// ArrayList<Integer> list = new ArrayList<Integer>();
		// list.add(4);
		// list.add(2);
		//
		//
		// m1.setPreferenceList(list);

		// firstFreeMan() test
		// sortingAlgorithm sa = new sortingAlgorithm();
		// Person m = sa.firstFreeMan();
		// System.out.println(m);//put (p,p) in pairs in constructor when
		// testing
		// System.out.println(sa.firstFreeMan());

		// sortingAlgorithm sa = new sortingAlgorithm();
		// HashMap<Person,Person> map = sa.sort();
		// Set<Person> set = map.keySet();
		// for(Person p : set){
		//
		// System.out.println(p + "-" + map.get(p));
		//
		// }
	}

	private static void printPairs(HashMap<Person, Person> result) {
		Set<Person> set = result.keySet();
		for (Person p : set) {

			System.out.println(p + "-" + result.get(p));

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
