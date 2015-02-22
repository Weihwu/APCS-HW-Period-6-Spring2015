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
		board[i][j] = '#';
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

    public boolean solve(int x){

	//starting from the first row
	board[0][x] = 'Q';
	for (int j = 0; j < board.length; j++){
	    if (solve(1,j)){
		return true;
	    }
	}
	return false;
    }

    public boolean solve(int row, int col){
	
	//check for queens in same column
	for (int i = 0; i < row; i++){
	    if (board[i][col] == 'Q'){
		return false;
	    }
	}

	//check for queens diagonally
	
	//up-left
	int row1 = row;
	int col1 = col;
	while (row1 >= 0 && col1 >= 0){
	    if (board[row1][col1] == 'Q'){
		return false;
	    }
	    row1--;
	    col1--;
	}

	//up-right
	row1 = row;
	col1 = col;
	while (row1 >= 0 && col1 < board.length){
	    if (board[row1][col1] == 'Q'){
		return false;
	    }
	    row1--;
	    col1++;
	}

	//when it passes all the checks
	board[row][col] = 'Q';
	
	//when it ends
	if (row == board.length-1){
	    return true;
	}

	//next row
	for (int j = 0; j < board.length; j++){
	    if (solve(row+1,j)){
		return true;
	    }
	}
	board[row][col] = '#';
	return false;
    }

    public static void main(String[]args){
	NQueens a;
	for (int i = 0; i < 8; i++){
	    a = new NQueens(8);
	    System.out.println("#" + (i+1));
	    if (a.solve(i)){
		System.out.println(a);
	    }else{
		System.out.println("No Solution");
	    }
	}
    }
}