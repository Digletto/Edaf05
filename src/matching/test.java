package matching;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class test {

	public static void main(String[] args) {
//		Person p = new Person(2, "w");								//tests preflist parsing
//		ParseFile pf = new ParseFile("tests/sm-kt-p-4.in.txt");
//		ArrayList<Integer> prefList = new ArrayList<Integer>();
//		prefList = pf.parsePref(p);
//		for(Integer i : prefList)
//			System.out.print(i + " ");
		
		ArrayList<Person> menList = new ArrayList<Person>();
		ArrayList<Person> womenList = new ArrayList<Person>();
		menList = pf.parseMen();
		for(Person per : menList)
			System.out.println(per.getNbr() + " " + per.getName());
		womenList = pf.parseWomen();
		for(Person per : womenList)
			System.out.println(per.getNbr() + " " + per.getName());
	}
}
