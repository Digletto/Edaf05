package gorilla;

public class CostMap {

	public int spaceCost = -4;
	public char wordI[];
	public char wordJ[];
	public Blosum blosum;

	public CostMap() {
//		HashMap<Character, Integer> a = new HashMap<Character, Integer>();
//		HashMap<Character, Integer> e = new HashMap<Character, Integer>();
//		HashMap<Character, Integer> m = new HashMap<Character, Integer>();
//		HashMap<Character, Integer> n = new HashMap<Character, Integer>();
//		a.put('*', -4);
//		a.put('a', 4);
//		a.put('e', -1);
//		a.put('m', -1);
//		a.put('n', -2);
//		e.put('*', -4);
//		e.put('e', 5);
//		e.put('a', -1);
//		e.put('m', -2);
//		e.put('n', 0);
//		m.put('*', -4);
//		m.put('m', 5);
//		m.put('a', -1);
//		m.put('e', -2);
//		m.put('n', -2);
//		n.put('*', -4);
//		n.put('n', 6);
//		n.put('a', -2);
//		n.put('e', 0);
//		n.put('m', -2);
//
//		map.put('a', a);
//		map.put('e', e);
//		map.put('m', m);
//		map.put('n', n);
//		spaceCost = -4;
		blosum = new Blosum();
	}

<<<<<<< HEAD
	public int getCost(char a, char b) {
		return blosum.getCost(blosum.char2id.get(Character.toUpperCase(a)), blosum.char2id.get(Character.toUpperCase(b)));
=======
	
	//Change to blosum
	public HashMap<Character, Integer> get(char c) {
		return map.get(c);
	}

	public int getCost(int i, int j) {

		return blosum.getCost(i, j);
>>>>>>> branch 'master' of https://github.com/Digletto/Edaf05.git
	}

	public void setWordI(char[] wordI) {
		this.wordI = wordI;
	}

	public void setWordJ(char[] wordJ) {
		this.wordJ = wordJ;
	}
}
