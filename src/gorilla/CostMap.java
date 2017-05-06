package gorilla;

import java.util.HashMap;

public class CostMap {
	
	HashMap<Character, HashMap<Character, Integer>> map; 

	public HashMap<Character, Integer> get(char c) {
		return map.get(c);
	}

}
