import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Maze{

private ArrayList<String> boop = new ArrayList<String>();
private String[] b;
private int[][] moves = {
		{1, 0}, {-1, 0}, {0, -1}, {0, 1},
			};

private int xcoorstart, ycoorstart;

public Maze(String fname){
	try {
		reader(fname);
	} catch(FileNotFoundException e) {
		System.out.println("NOT A VALID FILE >:(");
		System.exit(0);
	}

	if (findStart()){
		System.out.println(xcoorstart);
		System.out.println(ycoorstart);
	}
	else {
		System.out.println("no start");
	}

	// for (int x = 0; x<b.length; x++) {
	// 	System.out.println(b[x]);
	// }
}

private void reader(String fname) throws FileNotFoundException{
	File fl = new File(fname);
	Scanner scn = new Scanner(fl);
	while (scn.hasNextLine()) {
		String a = scn.nextLine();
		boop.add(a);
	}
	b = new String[boop.size()];
	boop.toArray(b);
}

private boolean findStart(){
	for (int x = 0; x < b.length; x++){
		for (int y = 0; y < b[x].length(); y++){
			if (b[x].contains("S")){
				ycoorstart = y;
				xcoorstart = x;
				return true;
			}
		}
	}
	return false;
}



public static void main(String[] args) {
	Maze m = new Maze("dat1.dat");
}

}
