package closestPair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PointParser {

	private Scanner s;
	private File file;

	public PointParser(String path) {
		file = new File(path);
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void restart() {
		try {
			s = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	//Returns unsorted array of points
	public XyList parse() {
		restart();
		ArrayList<Node> points = new ArrayList<Node>();
		String nxtLine; 
		
		do{
			
			nxtLine = s.nextLine();
			
		}while(!nxtLine.contains("NODE_COORD_SECTION")); 

		nxtLine = s.nextLine().trim();
		String[] splitLine = nxtLine.split(" ");
		while (!nxtLine.contains("EOF")) {
			Node p = new Node(Double.parseDouble(splitLine[1]), Double.parseDouble(splitLine[2]));
			nxtLine = s.nextLine().trim();
		}
		
		return new XyList(points);
	}
	
}
