package wordLadders;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LadderParser {

	public HashMap<String, String[]> words;
	public ArrayList<String[]> queries = new ArrayList<String[]>();
	public String wordList[];
	private Scanner scan;

	public LadderParser(InputStream in) {
		scan = new Scanner(in);
		String nxtLine = scan.nextLine();
		String split[] = nxtLine.split(" ");
		int nbrOfWords = Integer.parseInt(split[0]);
		int nbrOfQueries = Integer.parseInt(split[1]);

		readWords(nbrOfWords);
		readQueries(nbrOfQueries);

		Similarity sim = new Similarity();
		sim.constructSimilarity(words, wordList);
		scan.close();
	}

	private void readQueries(int nbrOfQueries) {
		for (int i = 0; i < nbrOfQueries; i++) {
			String split[] = scan.nextLine().split(" ");
			String temp[] = {split[0], split[1]};
			queries.add(temp);
		}
	}

	private void readWords(int nbrOfWords) {
		wordList = new String[nbrOfWords];
		for (int i = 0; i < nbrOfWords; i++) {
			String nxtLine = scan.nextLine();
			words.put(nxtLine, null);
			wordList[i] = nxtLine;
		}
	}
}
