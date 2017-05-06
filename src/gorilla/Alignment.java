package gorilla;

public class Alignment {

	public static void main(String args[]) {
		CostMap cm = new CostMap();
		SequenceParser sp = new SequenceParser("test.txt");
		char wordI[] = sp.parseI();
		char wordJ[] = sp.parseJ();
		
		run(wordI, wordJ);
	}

	private static void run(char[] wordI, char[] wordJ) {
		int map[][] = new int[wordI.length + 1][wordJ.length + 1];
		
		init(map);
		
		for(int j = 1; j < wordJ.length; j++) {
			for(int i = 1; i < wordI.length; i++) {
				map[i][j] = opt(i, j, map);
			}
		}
	}

	private static int opt(int i, int j, int[][] map) {
		return 0;
	}

	private static void init(int[][] map) {
		// TODO Auto-generated method stub
	}
}
