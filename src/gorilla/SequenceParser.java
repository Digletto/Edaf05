package gorilla;

import java.util.HashMap;
import java.util.Scanner;

public class SequenceParser {

	int organismNumber;
	int queryNumber;
	Scanner scan;
	HashMap<String, char[]> sequences;
	HashMap<String, String> queries;

	public SequenceParser() {

		sequences = new HashMap<String, char[]>();
		scan = new Scanner(System.in);
		String[] ns = scan.nextLine().trim().split(" ");
		organismNumber = Integer.parseInt(ns[0]);
		queryNumber = Integer.parseInt(ns[1]);
		parseOrganisms();
		parseQueries();

	}

	public void parseOrganisms() {

		for (int i = 0; i < organismNumber; i++) {

			String name = scan.nextLine().trim();
			char[] sequence = scan.nextLine().toCharArray();
			
			sequences.put(name, sequence);

		}

		// char wordI[] = new char[5];
		// wordI[0] = '*';
		// wordI[1] = 'n';
		// wordI[2] = 'a';
		// wordI[3] = 'm';
		// wordI[4] = 'e';
		// return wordI;

	}

	public void parseQueries() {
		// char wordJ[] = new char[5];
		// wordJ[0] = '*';
		// wordJ[1] = 'm';
		// wordJ[2] = 'e';
		// wordJ[3] = 'a';
		// wordJ[4] = 'n';
		// return wordJ;

		for (int i = 0; i < queryNumber; i++) {

			String[] line = scan.nextLine().trim().split(" ");
			String name1 = line[0];
			String name2 = line[1];
			
			queries.put(name1, name2);

		}
		
	}

	public char[] getSequence(String name) {

		return sequences.get(name);

	}

	public HashMap<String, String> getQueries() {

		return queries;

	}
	
	public String getQuery(String query) {

		//get corresponding sequence
		return queries.get(query);

	}
}
