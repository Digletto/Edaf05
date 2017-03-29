package matching;

import java.io.File;
import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		Person p = new Person(2, "w");
		ParseFile pf = new ParseFile("tests/sm-kt-p-4.in.txt");
		ArrayList<Integer> prefList = new ArrayList<Integer>();
		prefList = pf.parsePref(p);
		System.out.println(prefList.get(0));
		for(Integer i : prefList)
			System.out.print(i + " ");
	}
}
