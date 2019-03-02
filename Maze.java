import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Maze{

private ArrayList<String> boop = new ArrayList<String>();
private String[] b;
private int[][] moves = {
		{0, 1},
		{1, 0},
		{-1, 0},
		{0, -1},
			};

private int xcoor, ycoor;
private int steps;
char[][] maze;

public Maze(String fname){
	try {
		reader(fname);
	} catch(FileNotFoundException e) {
		System.out.println("NOT A VALID FILE >:(");
		System.exit(0);
	}

	toArray();
	if (!findStart()){
		System.out.println("no start");
		System.exit(1);
	}
	// maze[xcoor][ycoor] = ' ';
	betaPlacer(xcoor, ycoor);
}

private boolean betaPlacer(int x, int y){
	if (maze[x][y] == 'E'){
		return true;
	}
	for (int c = 0; c < 4; c++){
		if (maze[x][y] == ' '){
			maze[x][y] = '.';
			steps++;
			debug();
			// debug();
			if (betaPlacer(x+moves[c][0], y+moves[c][1])){
				debug();
				return true;
			}
			// debug();
			maze[x][y] = ' ';
			steps--;
		}
		else if (maze[x][y] == 'S') {
			debug();
			// debug();
			if (betaPlacer(x+moves[c][0], y+moves[c][1])){
				debug();
				return true;
			}
			// debug();
		}
	}
	return false;
}

private void toArray(){
	maze = new char [b.length][b[0].length()];
	for (int x = 0; x < b.length; x++){
		for (int y = 0; y < b[x].length(); y++){
			maze[x][y] = b[x].charAt(y);
		}
	}
}


private void debug(){
	System.out.println("\033[2J\033[1;1H");
	System.out.println(this);Text.wait(100); //adjust this delay
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

public boolean findStart(){
	for (int x = 0; x < b.length; x++){
		for (int y = 0; y < b[x].length(); y++){
			if (b[x].charAt(y) == 'S'){
				ycoor = y;
				xcoor = x;
				return true;
			}
		}
	}
	return false;
}

public String toString(){
	String output = "";
	for (int x = 0; x < maze.length; x++) {
		for (int y = 0; y < maze[x].length; y++) {
			output += maze[x][y];
		}
		output += "\n";
	}
	output += steps;
	return output;
}



public static void main(String[] args) {
	Maze m = new Maze("dat4.dat");
}

}
