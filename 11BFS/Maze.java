import java.util.*;
import java.io.*;

public class Maze{

    private char[][] grid;
    private int maxx, maxy;
    private int startx, starty;
    
    public Maze(String filename){
	startx = -1;
	starty = -1;
	String ans ="";
	try{

	    Scanner in = new Scanner(new File(filename));
	    while (in.hasNext()){
		String line = in.nextLine();
		if (maxy == 0){
		    maxx = line.length();
		}
		maxy++;
		ans += line;
	    }

	}catch (Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}

	grid = new char[maxx][maxy];
	for (int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    grid[i%maxx][i/maxx] = c;
	    if (c == '5'){
		startx = i%maxx;
		starty = i/maxx;
	    }
	}
    }
}