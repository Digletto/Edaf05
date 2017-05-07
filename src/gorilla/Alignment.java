package gorilla;

public class Alignment {

	public static void main(String args[]) {
		SequenceParser sp = new SequenceParser("test.txt");
		char wordI[] = sp.parseI();
		char wordJ[] = sp.parseJ();

		run(wordI, wordJ);
	}

	private static void run(char[] wordI, char[] wordJ) {
		int map[][] = new int[wordI.length][wordJ.length];
		CostMap cm = new CostMap();
		cm.setWordI(wordI);
		cm.setWordJ(wordJ);

		init(map, cm);

		for (int j = 1; j < wordJ.length; j++) {
			for (int i = 1; i < wordI.length; i++) {
				opt(i, j, cm, map);
			}
		}
		System.out.println(map[1][1] + "");
	}

	private static int opt(int i, int j, CostMap cm, int[][] map) {
		if(i == cm.wordI.length || j == cm.wordJ.length)
			return 0;
		if(map[i][j] != Integer.MIN_VALUE)
			return map[i][j];
		int result =  max(cm.getCost(i, j) + opt(i + 1, j + 1, cm, map), cm.spaceCost + 
				opt(i + 1, j, cm, map), cm.spaceCost + opt(i, j + 1, cm, map));
		map[i][j] = result;
		return result;
	}

	private static int max(int diag, int right, int down) {
		int temp = Math.max(diag, right);
		return Math.max(temp, down);
	}

	private static void init(int[][] map, CostMap cm) {
		for (int i = 0; i < map[0].length; i++) {
			map[0][i] = i * cm.spaceCost;
		}
		for (int j = 0; j < map.length; j++) {
			map[j][0] = j * cm.spaceCost;
		}
		for (int i = 1; i < map[0].length; i++) {
			for (int j = 1; j < map.length; j++) {
				map[i][j] = Integer.MIN_VALUE;
			}
		}
	}
}
