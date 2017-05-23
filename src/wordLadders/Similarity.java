package wordLadders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Similarity {

	public void constructSimilarity(HashMap<String, ArrayList<String>> words, String[] wordList) {
		for (String word : wordList) {
			words.put(word, new ArrayList<String>());
			for (String wordj : wordList) {
				if (wordj != word && checkSim(word, wordj)) {
					words.get(word).add(wordj);
				}
			}
		}
	}

	private boolean checkSim(String word, String wordj) {
		char nodeWord[] = word.toCharArray();
		HashSet<Character> otherWord = stringToSet(wordj);
		Boolean temp = true;
		for (int i = 1; i < 5; i++) {
			if(!otherWord.contains(nodeWord[i]))
				temp = false;
			else otherWord.remove(nodeWord[i]);
		}
		return temp;
	}

	private HashSet<Character> stringToSet(String wordj) {
		HashSet<Character> temp = new HashSet<Character>();
		for(char c:wordj.toCharArray())
			temp.add(c);
		return temp;
	}

}
