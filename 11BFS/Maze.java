import java.util.*;
import java.io.*;

public class Maze{

    private char[][] grid;
    private int maxx, maxy;
    private int startx, starty;
    private int endx, endy;

    private MyDeque<Loci> frontier;
    private int[] path;

    private static final String clear =  "\033[2J";
    private static final String hide =  "\033[?25l";
    private static final String show =  "\033[?25h";
    
    public Maze(String filename){

	frontier = new MyDeque<Loci>();
	path = new int[0];

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

	grid = new char[maxy][maxx];
	for (int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    grid[i/maxx][i%maxx] = c;
	    if (c == 'S'){
		startx = i%maxx;
		starty = i/maxx;
	    }
	    if (c == 'E'){
		endx = i%maxx;
		endy = i%maxy;
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
	private int count;
	
	private Loci last;
	
	public Loci(int x, int y, Loci last){
	    this.x = x;
	    this.y = y;
	    this.last = last;
	}

	public Loci(int x, int y, Loci last, int count){
	    this.x = x;
	    this.y = y;
	    this.count = count;
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
	public int getCount(){
	    return count;
	}

    }

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

    //Best First Search
    public boolean solveBest(){
	return solveBest(false);
    }
    public boolean solveBest(boolean animate){
	return solve('F', animate);
    }

    //AStar
    public boolean solveAStar(){
	return solveAStar(false);
    }
    public boolean solveAStar(boolean animate){
	return solve('A', animate);
    }

    //Solve

    private boolean solve(char type, boolean animate){
	int thisx;
	int thisy;
	int count = 0;

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
	    if (grid[thisy-1][thisx] == ' ' || grid[thisy-1][thisx] == 'E'){
		if (type == 'B'){
		    frontier.addLast(new Loci(thisx, thisy-1, place));
		}else if (type == 'D'){
		    frontier.addFirst(new Loci(thisx, thisy-1, place));
		}else if (type == 'F'){
		    frontier.add(new Loci(thisx, thisy-1, place), Math.abs(endx-thisx) + Math.abs(endy - (thisy-1)));
		}else{
		    frontier.add(new Loci(thisx, thisy-1, place), Math.abs(endx-thisx) + Math.abs(endy - (thisy-1)) + count+1);
		}
	    }
	    
	    if (grid[thisy][thisx+1] == ' ' || grid[thisy][thisx+1] == 'E'){
		if (type == 'B'){
		    frontier.addLast(new Loci(thisx+1, thisy, place));
		}else if (type == 'D'){
		    frontier.addFirst(new Loci(thisx+1, thisy, place));
		}else if (type == 'F'){
		    frontier.add(new Loci(thisx+1, thisy, place), Math.abs(endx-(thisx+1)) + Math.abs(endy - thisy));
		}else{
		    frontier.add(new Loci(thisx+1, thisy, place), Math.abs(endx-(thisx+1)) + Math.abs(endy - thisy) + count+1);
		}
	    }
	    
	    if (grid[thisy+1][thisx] == ' ' || grid[thisy+1][thisx] == 'E'){
		if (type == 'B'){
		    frontier.addLast(new Loci(thisx, thisy+1, place));
		}else if (type == 'D'){
		    frontier.addFirst(new Loci(thisx, thisy+1, place));
		}else if (type == 'F'){
		    frontier.add(new Loci(thisx, thisy+1, place), Math.abs(endx-thisx) + Math.abs(endy - (thisy+1)));
		}else{
		    frontier.add(new Loci(thisx, thisy+1, place), Math.abs(endx-thisx) + Math.abs(endy - (thisy+1)) + count+1);
		}
	    }
	    
	    if (grid[thisy][thisx-1] == ' ' || grid[thisy][thisx-1] == 'E'){
		if (type == 'B'){
		    frontier.addLast(new Loci(thisx-1, thisy, place));
		}else if (type == 'D'){
		    frontier.addFirst(new Loci(thisx-1, thisy, place));
		}else if (type == 'F'){
		    frontier.add(new Loci(thisx-1, thisy, place), Math.abs(endx-(thisx-1)) + Math.abs(endy - thisy));
		}else{
		    frontier.add(new Loci(thisx-1, thisy, place), Math.abs(endx-(thisx-1)) + Math.abs(endy - thisy) + count+1);
		}
	    }
	    
	    if (frontier.size() == 0){
		for (int i = 0; i < maxy; i++){
		    for (int j = 0; j < maxx; j++){
			if (grid[i][j] == 'x'){
			    grid[i][j] = ' ';
			}
		    }
		}
		return false;
	    }

	    if (type == 'F' || type == 'A'){
		place = frontier.removeSmallest();
		while (grid[place.getY()][place.getX()] == 'x'){
		    place = frontier.removeSmallest();
		}
	    }else{
	        place = frontier.removeFirst();
		while (grid[place.getY()][place.getX()] == 'x'){
		    place = frontier.removeFirst();
		}
	    }

	    thisx = place.getX();
	    thisy = place.getY();
	    
	    if (type == 'A'){
		count = place.getCount();
	    }
	} 

	MyDeque<Integer> solution = new MyDeque<Integer>();

	for (int i = 0; i < maxy; i++){
	    for (int j = 0; j < maxx; j++){
		if (grid[i][j] == 'x'){
		    grid[i][j] = ' ';
		}
	    }
	}
	
	solution.addFirst(place.getY());
	solution.addFirst(place.getX());
	place = place.getLast();
	
	while (place.getLast() != null){
	    if (grid[place.getY()][place.getX()] != 'S'){
		grid[place.getY()][place.getX()] = 'x';
	    }
	    solution.addFirst(place.getY());
	    solution.addFirst(place.getX());
	    place = place.getLast();
	}

	solution.addFirst(place.getY());
	solution.addFirst(place.getX());

	path = new int[solution.size()];
	for (int x = 0; solution.size() > 0; x++){
	    path[x] = solution.removeFirst();
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
	    return clear() + hide() + go(0,0) + toString() + "\n" + show + color(37,40);
	}
    }
 
    public static void main(String[] args){
	Maze a = new Maze("data1.dat");
	System.out.println(a);
	System.out.println();
	System.out.println(a.solveDFS());
	System.out.println();
	System.out.println(a);
	System.out.println(Arrays.toString(a.solutionCoordinates()));

	Maze b = new Maze("data3.dat");
	System.out.println(b);
	System.out.println();
	System.out.println(b.solveBFS());
	System.out.println();
	System.out.println(b);
	System.out.println(Arrays.toString(b.solutionCoordinates()));

	Maze c = new Maze("data1.dat");
	System.out.println(c);
	System.out.println();
	System.out.println(c.solveAStar());
	System.out.println();
	System.out.println(c);
	System.out.println(Arrays.toString(c.solutionCoordinates()));

	Maze d = new Maze("data1.dat");
	System.out.println(d);
	System.out.println();
	System.out.println(d.solveBest());
	System.out.println();
	System.out.println(d);
	System.out.println(Arrays.toString(d.solutionCoordinates()));
    }
}