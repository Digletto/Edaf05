package matching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ParseFile {
	Scanner s;
	File f;

	public ParseFile(String path) {
		try {
		f = new File(path);
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void restart(){
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Person> parseMen() {
		return parsePersons(0);
	}
	
	public ArrayList<Person> parseWomen() {
		return parsePersons(1);
	}
	
	/**
	 * i = 0 for men, i = 1 for women
	 * 
	 */
	private ArrayList<Person> parsePersons(int i) {
		restart();
		String nxtLine;
		int nbrOfP; 
		ArrayList<Person> persons = new ArrayList<Person>();
		while(s.hasNextLine()) {
			nxtLine = s.nextLine();
			if(nxtLine.contains("=")){
				System.out.println("found it");
				nbrOfP = Integer.parseInt(nxtLine.substring(2));
				if(i==0)
					persons = createMenList(nbrOfP);
				else
					persons = createWomenList(nbrOfP);
			}
		}
		return persons;
	}
	
	private ArrayList<Person> createWomenList(int nbrOfP) {
		return createPersonList(1, nbrOfP);
	}

	private ArrayList<Person> createMenList(int nbrOfP) {
		return createPersonList(0, nbrOfP);
	}

	private ArrayList<Person> createPersonList(int i, int nbrOfP) {
		String nxtLine;
		ArrayList<Person> prsnList = new ArrayList<Person>();
		for (int m=0; m < nbrOfP; m++) {
			nxtLine = s.nextLine();
			if((m+i)%2 == 0) {
				prsnList.add(createPerson(nxtLine));
			}
		}
		return prsnList;
	}

	private Person createPerson(String nxtLine) {
		String split[] = nxtLine.split(" ");
		int nbr = Integer.parseInt(split[0]);
		Person p = new Person(nbr, split[1]);
		return p;
	}

	public ArrayList<Integer> parsePref(Person p){
		return parsePreference(p);
	}
	
	private ArrayList<Integer> parsePreference(Person p) {
		restart();
		int nbr = p.getNbr();
		String nxtLine;
		ArrayList<Integer> prefs = new ArrayList<Integer>();
		while(s.hasNextLine()) {
			nxtLine = s.nextLine();
			if(nxtLine.contains(nbr + ":")) {
				prefs = parsePref(nxtLine);
			}
		}
		return prefs;
	}

	private ArrayList<Integer> parsePref(String nxtLine) {
		ArrayList<Integer> prefs = new ArrayList<Integer>();
		String subLine = nxtLine.substring(3);
		for(String s : subLine.split(" ")){
			prefs.add(Integer.parseInt(s));
		}
		return prefs;
	}
}
