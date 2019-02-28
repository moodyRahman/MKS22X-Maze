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

private int x;
private int y;

public Maze(String fname){
	try {
		reader(fname);
	} catch(FileNotFoundException e) {
		System.out.println("NOT A VALID FILE >:(");
		System.exit(0);
	}

	// for (int x = 0; x<b.length; x++) {
	// 	System.out.println(b[x]);
	// }
}

private boolean findStart(){
	for (int x = 0; x < b.length; x++) {
		for (int y = 0; y < b[0].length(); y++) {
			if (b[x].contains('S')){
				this.x = x;
				this.y = y;
				return true;
			}
		}
	}
	return false;
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


private void down(){}

public static void main(String[] args) {
	Maze m = new Maze("dat1.dat");
}

}
