public class NQueens {

    private char[][] board;

    public NQueens(){
	board = new char[1][1];
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[i].length; j++){
		board[i][j] = '#';
	    }
	}
    }
    
    public NQueens(int size){
	board = new char[size][size];
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[i].length; j++){
		board[i][j] = '-';
	    }
	}
    }

    public String toString(){
	String ans = "\n";
	for (int i = 0; i < board.length; i++){
	    for (int j = 0; j < board[i].length; j++){
		ans += board[i][j] + " ";
	    }
	    ans += "\n";
	}
	return ans;
    }
	
		
    public String name(){
	return "wu.weihou";
    }

    public boolean solve(){
	return solve(0);
    }

}