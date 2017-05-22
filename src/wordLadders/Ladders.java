package wordLadders;

import java.util.HashMap;
import java.util.HashSet;

public class Ladders {

	public static void main(String[] args) {
		LadderParser lp = new LadderParser(System.in);
		HashMap<String, String[]> words = lp.words;

		for (String query[] : lp.queries) {
			run(words, query[0], query[1]);
		}
	}

	private static void run(HashMap<String, String[]> words, String query0, String query1) {
		System.out.println("" + WL(words, query0, query1));
	}

	private static int WL(HashMap<String, String[]> words, String start, String finish) {
		HashSet<String> added = new HashSet<String>();
		return WLrec(words, added, start, finish, 1);
	}

	private static int WLrec(HashMap<String, String[]> words, HashSet<String> added, String current, String finish,
			int depth) {

		added.add(current);

		for (String child : words.get(current)) {
			if (child == finish)
				return depth;
			if (added.contains(child))
				continue;

			int recResult = WLrec(words, added, child, finish, depth + 1);
			if (recResult != -1)
				return recResult;
		}
		return -1;
	}
}
