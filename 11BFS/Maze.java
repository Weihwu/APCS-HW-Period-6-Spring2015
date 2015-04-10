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

    //Background
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
    private String color(int foreground,int background){
        return ("\033[0;" + foreground + ";" + background + "m");
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

    public class Loci{

	private int x;
	private int y;
	
	private Loci last;
	
	public Loci(int x, int y, Loci last){
	    this.x = x;
	    this.y = y;
	    this.last = last;
	}

	public int getX(){
	    return x;
	}
	public int getY(){
	    return y;
	}
	public Loci getLast(){
	    return last;
	}

    }

    private MyDeque<Loci> Frontier;
    private int[] path;

    //BFS
    public boolean solveBFS(){
	return solveBFS(false);
    }

    public boolean solveBFS(boolean animate){
	return solve("BFS", animate);
    }

    //DFS
    public boolean solveDFS(){
	return solveDFS(false);
    }

    public boolean solveDFS(boolean animate){
	return solve("DFS", animate);
    }

    //Solve

    private boolean solve(String type, boolean animate){
	return true;
    }

    public int[] solutionCoordinates(){	
	return path;
    }

    public String toString(){
	String ans = ""+maxx+","+maxy+"\n";
	for(int i=0;i<maxx*maxy;i++){
	    if(i%maxx ==0 && i!=0){
		ans+="\n";
	    }
	    ans += grid[i%maxx][i/maxx];
	}
	return hide()+invert()+go(0,0)+ans+"\n"+show();	
    }

    public String toString(boolean animate){
	return "";
    }
 
}