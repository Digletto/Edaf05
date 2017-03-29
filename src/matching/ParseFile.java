package matching;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ParseFile {
	Scanner s;

	public ParseFile(String path) {
		try {
		File f = new File(path);
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Integer> parsePref(Person p){
		return parsePreference(p);
	}
	
	private ArrayList<Integer> parsePreference(Person p) {
		int nbr = p.getNbr();
		String nxtLine;
		ArrayList<Integer> prefs = new ArrayList<Integer>();
		while(s.hasNextLine()) {
			nxtLine = s.nextLine();
			if(nxtLine.contains(nbr + ":")) {
				prefs = parsePref(nxtLine);
			}
		}
		return prefs;
	}

	private ArrayList<Integer> parsePref(String nxtLine) {
		ArrayList<Integer> prefs = new ArrayList<Integer>();
		String subLine = nxtLine.substring(3);
		for(String s : subLine.split(" ")){
			prefs.add(Integer.parseInt(s));
		}
		return prefs;
	}
}
