import java.util.*;
import java.io.*;

public class Maze{

    private char[][] grid;
    private int maxx, maxy;
    private int startx, starty;

    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    
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

    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private String clear(){
	return "[2J";
    }
    private String hide(){
	return "[?25l";
    }
    private String show(){
	return "[?25h";
    }
    private String invert(){
	return "[37";
    }
    public void clearTerminal(){
	System.out.println(clear());
    }
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public class Frontier{

	MyDeque<Integer> path;

	public Frontier(){
	}

	public void setCoor(int x, int y){
	    path.addLast(x);
	    path.addLast(y);
	}

	public void removeCoor(){
	    path.removeFirst();
	    path.removeFirst();
	}

    }

    /**  
    public String toString(){
    }

    public String toString(boolean animate){
    }

    public boolean solveBFS(boolean animate){
    }

    public boolean solveDFS(boolean animate){
    }

    public int[] solutionCoordinates(){	
    }
    */

}