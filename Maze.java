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
private int xcoor, ycoor;
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

	xcoor = xcoorstart;
	ycoor = ycoorstart;

	solve(xcoor, ycoor);
}

private void toArray(){
	maze = new char [b.length][b[0].length()];
	for (int x = 0; x < b.length; x++){
		for (int y = 0; y < b[x].length(); y++){
			maze[x][y] = b[x].charAt(y);
		}
	}
}

public boolean solve(int x, int y){
	debug();
	if (maze[x][y] == 'E'){
		return true;
	}
	for(int c = 0; c < 4; c++){
		if (place(x, y)) {
			debug();
			if (solve(x + moves[c][0], y + moves[c][1] ) ){
				return true;
			}
			maze[x][y] = ' ';
		}
	}
	return false;
}

private void debug(){
	System.out.println(Text.go(1,1));
	System.out.println(this);Text.wait(1000); //adjust this delay
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

private boolean place(int x, int y){
	if (maze[x][y] == ' '){
		maze[x][y] = '.';
		return true;
	}
	return false;
}

public boolean findStart(){
	for (int x = 0; x < b.length; x++){
		for (int y = 0; y < b[x].length(); y++){
			if (b[x].charAt(y) == 'S'){
				ycoorstart = y;
				xcoorstart = x;
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
	return output;
}



public static void main(String[] args) {
	Maze m = new Maze("dat1.dat");
}

}
