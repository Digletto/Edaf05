package gorilla;

import java.util.Set;

public class Alignment {

	public static void main(String args[]) {
		SequenceParser sp = new SequenceParser();
//		char wordI[] = sp.parseI();
//		char wordJ[] = sp.parseJ();
//		
//		run(wordI, wordJ);

		Set<String> queries = sp.getQueries().keySet();

		for (String s : queries) {
			run(sp.getSequence(s), sp.getSequence(sp.getQuery(s)));
		}
	}

	private static void run(char[] wordI, char[] wordJ) {
		int map[][] = new int[wordI.length][wordJ.length];
		CostMap cm = new CostMap();
		cm.setWordI(wordI);
		cm.setWordJ(wordJ);

		init(map, cm);

		for (int j = 1; j < wordJ.length; j++) {
			for (int i = 1; i < wordI.length; i++) {
				opt(i, j, cm, map); // opt(wordI.length-1, wordJ.length-1, cm,
									// map) utan for loops?
			}
		}
		//System.out.println(map[wordI.length - 1][wordJ.length - 1] + "");
		String aStrings[] = alignmentStrings(cm, map);
		System.out.println(aStrings[0]);
		System.out.println(aStrings[1]);
	}

	private static int opt(int i, int j, CostMap cm, int[][] map) {
		if (map[i][j] != Integer.MIN_VALUE)
			return map[i][j];
		int result = max(cm.getCost(cm.wordI[i], cm.wordJ[j]) + opt(i - 1, j - 1, cm, map), cm.spaceCost + opt(i - 1, j, cm, map),
				cm.spaceCost + opt(i, j - 1, cm, map));
		map[i][j] = result;
		return result;
	}

	private static int max(int diag, int right, int down) {
		int temp = Math.max(diag, right);
		return Math.max(temp, down);
	}

	private static String[] alignmentStrings(CostMap cm, int[][] map) {
		String a = "";
		String b = "";
		int i = cm.wordI.length-1;
		int j = cm.wordJ.length-1;
		while (i > 0 || j > 0)	{
		  if (i > 0 && j > 0 && map[i][j] == map[i-1][j-1] + cm.getCost(cm.wordI[i], cm.wordJ[j])) {
		    a = cm.wordI[i] + a;
		    b = cm.wordJ[j] + b;
		    i = i - 1;
		    j = j - 1;
		  }
		  else if (i > 0 && map[i][j] == map[i-1][j] + cm.spaceCost) {
		    a = cm.wordI[i] + a;
		    b = "-" + b;
		    i = i - 1;
		  }
		  else {
		    a = "-" + a;
		    b = cm.wordJ[j] + b;
		    j = j - 1;
		  }
		}
		return new String[] {a,b};
	}

	private static void init(int[][] map, CostMap cm) {
		for (int i = 0; i < map.length; i++) {
			map[i][0] = i * cm.spaceCost;
		}

		for (int j = 0; j < map[0].length; j++) {
			map[0][j] = j * cm.spaceCost;
		}

		for (int i = 1; i < map.length; i++) {
			for (int j = 1; j < map[0].length; j++) {
				map[i][j] = Integer.MIN_VALUE;
			}
		}
	}
}
