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

    private MyDeque<Loci> frontier;
    private int[] path;

    //BFS
    public boolean solveBFS(){
	return solveBFS(false);
    }

    public boolean solveBFS(boolean animate){
	return solve('B', animate);
    }

    //DFS
    public boolean solveDFS(){
	return solveDFS(false);
    }

    public boolean solveDFS(boolean animate){
	return solve('D', animate);
    }

    //Solve

    private boolean solve(char type, boolean animate){
	int thisx;
	int thisy;

	thisx = startx;
	thisy = starty;
	
	Loci place = new Loci(thisx, thisy, null);


	while (grid[thisy][thisx] != 'E'){
	    
	    if (animate){
		System.out.println(toString(true));
		wait(20);
	    }

	    if (grid[thisy][thisx] != 'S'){
		grid[thisy][thisx] = 'x';
	    }

	    //Checking Clockwise
	    if (grid[thisy-1][thisx] != '#' && grid[thisy-1][thisx] != 'x'){
		if (type == 'B'){
		    frontier.addLast(new Loci(thisx, thisy-1, place));
		}else{
		    frontier.addFirst(new Loci(thisx, thisy-1, place));
		}
	    }

	    if (grid[thisy][thisx+1] != '#' && grid[thisy][thisx+1] != 'x'){
		if (type == 'B'){
		    frontier.addLast(new Loci(thisx+1, thisy, place));
		}else{
		    frontier.addFirst(new Loci(thisx+1, thisy, place));
		}
	    }

	    if (grid[thisy+1][thisx] != '#' && grid[thisy+1][thisx] != 'x'){
		if (type == 'B'){
		    frontier.addLast(new Loci(thisx, thisy+1, place));
		}else{
		    frontier.addFirst(new Loci(thisx, thisy+1, place));
		}
	    }

	    if (grid[thisy][thisx-1] != '#' && grid[thisy][thisx-1] != 'x'){
		if (type == 'B'){
		    frontier.addLast(new Loci(thisx-1, thisy, place));
		}else{
		    frontier.addFirst(new Loci(thisx-1, thisy, place));
		}
	    }
	} 
	return true;
    }

    public int[] solutionCoordinates(){	
	return path;
    }

    public String toString(){
	String ans = "";
	for (int i = 0; i < grid.length; i++){
	    for (int j = 0; j < grid[i].length; j++){
		ans += grid[i][j];

	    }
	    ans += "\n";
	}
	return ans;
    }

    public String toString(boolean animate){
	if (!animate){
	    return toString();
	}else{
	    return hide + go(0,0) + toString() + "\n" + show + color(37,40);
	}
    }
 
}