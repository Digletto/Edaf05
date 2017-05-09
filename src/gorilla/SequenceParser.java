package gorilla;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SequenceParser {

	int organismNumber;
	int queryNumber;
	Scanner scan;
	HashMap<String, char[]> sequences;
	List<String> queries = new ArrayList<String>();

	public SequenceParser() {
		sequences = new HashMap<String, char[]>();
		scan = new Scanner(System.in);
//		try {
//			scan = new Scanner(new File("tests/gorilla/toy.in"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String[] ns = scan.nextLine().trim().split(" ");
		organismNumber = Integer.parseInt(ns[0]);
		queryNumber = Integer.parseInt(ns[1]);
		parseOrganisms();
		parseQueries();
	}

	public void parseOrganisms() {
		for (int i = 0; i < organismNumber; i++) {
			String name = scan.nextLine().trim();
			String temp = "-" + scan.nextLine();
			char[] sequence = temp.toCharArray();
			sequences.put(name, sequence);
		}
	}

	
	public void parseQueries() {
		for (int i = 0; i < queryNumber; i++) {
			String[] line = scan.nextLine().trim().split(" ");
			String name1 = line[0];
			String name2 = line[1];
			
			queries.add(name1 + ";" + name2);
		}
	}

	public char[] getSequence(String name) {
		return sequences.get(name);
	}

	public List<String> getQueries() {
		return queries;
	}

	public char[] parseI() {
		char wordI[] = new char[7];
		wordI[0] = '*';
		wordI[1] = 'K';
		wordI[2] = 'A';
		wordI[3] = 'T';
		wordI[4] = 'T';
		wordI[5] = 'I';
		wordI[6] = 'S';
		return wordI;
	}

	public char[] parseJ() {
		char wordJ[] = new char[6];
		wordJ[0] = '*';
		wordJ[1] = 'K';
		wordJ[2] = 'A';
		wordJ[3] = 'T';
		wordJ[4] = 'I';
		wordJ[5] = 'S';
		return wordJ;
	}
}
