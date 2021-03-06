import java.io.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class MakeLake{
    int [][] field;
    int finalElevation;
    int row;
    int col;
    
    public static void main(String[] args){
	MakeLake a = new MakeLake();
	List<String> lines;
	
	try {
            lines = Files.readAllLines(Paths.get("makelake.in"), StandardCharsets.UTF_8);
	}catch(Exception e){
	    e.printStackTrace();
            return;
        }
	
	String[] firstLineArray = lines.get(0).split(" ");
        a.row = Integer.parseInt(firstLineArray[0]);
        a.col = Integer.parseInt(firstLineArray[1]);
        a.finalElevation = Integer.parseInt(firstLineArray[2]);
        lines.remove(0);
        a.field = new int[a.row][a.col];

	for (int i = 0; i < a.row; i++){
	    for (int j = 0; j < a.col; j++){
		a.field[i][j] = Integer.parseInt(lines.get(0).split(" ")[j]);
	    }
	    lines.remove(0);
	}
	for (int i = 0; i < lines.size(); i++){
            String[] currentLines = lines.get(i).split(" ");
            a.stomp(
		     Integer.parseInt(currentLines[0]),
		     Integer.parseInt(currentLines[1]),
		     Integer.parseInt(currentLines[2]));
        }

        try{
            String s = String.valueOf(a.calculateVolume());
	    System.out.println(s);
            Files.write(Paths.get("makelake.out"), s.getBytes());
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void stomp(int x, int y, int e){
        x--; 
	y--;
        int max = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (i+x < row &&
		    j+y < col &&
		    field[i + x][j + y] > max){
                    max = field[i + x][j + y];
                }
            }
        }
        for (int p = 0; p < e; p++){
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    if (i+x < row &&
			j+y < col &&
			field[i + x][j + y] == max){
                        field[i + x][j + y]--;
                    }
                }
            }
            max--;
        }
    }

    public int calculateVolume(){
        int sumDepth = 0;
        for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field[i].length; j++){
                if (field[i][j] < finalElevation)
                    sumDepth += finalElevation - field[i][j];
            }
        }
        return 6*12*6*12 *sumDepth;
    }

    public String toString(){
        String s = "";
        for (int i = 0; i < field.length; i++){
            for (int j = 0; j < field[i].length; j++)
                s += field[i][j] + " ";
            s += '\n';
        }
        return s;
    }

}