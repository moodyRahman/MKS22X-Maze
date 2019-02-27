import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Maze{

private ArrayList<String> boop = new ArrayList<String>();


public Maze(String fname){
	try {
		File fl = new File(fname);
		Scanner scn = new Scanner(fl);
		while (scn.hasNextLine()) {
	                String a = scn.nextLine();
			System.out.println(a);
	        }
	} catch(Exception e) {
		System.out.println("NOT A VALID FILE >:(");
		System.exit(0);
	}


	// while(inf.hasNextLine()){
	// 	String line = inf.nextLine();
        // }
}



}
