
public class nQueenProblem {

	public static void main(String[] args) {
		boolean[][] board = new boolean[4][4];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++){
				board[i][j] = false;
			}
		}
		
	placeQueen(board, 0);
	
	printBoard(board);

	}

	private static void printBoard(boolean[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++){
				System.out.print(board[i][j] + ",");
			}
		System.out.println("\n");
		}
		
	}


	private static boolean isSafe(boolean board[][], int row, int col)
	{
	    int i, j;
	 
	    /* Check this row on left side */
	    for (i = 0; i < col; i++)
	    {
	        if (board[row][i])
	            return false;
	    }
	 
	    /* Check upper diagonal on left side */
	    for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
	    {
	        if (board[i][j])
	            return false;
	    }
	 
	    /* Check lower diagonal on left side */
	    for (i = row, j = col; j >= 0 && i < board.length; i++, j--)
	    {
	        if (board[i][j])
	            return false;
	    }
	 
	    return true;
	}

	private static boolean placeQueen(boolean[][] board, int col) {
		
		if (col == board.length)
			return true;
		
		for (int row = 0; row < board.length; row++){
			if (isSafe(board,row, col)) {
				board[row][col] = true;
				if(placeQueen(board, col+1))
					return true;
				board[row][col] = false;
			}
			
				
		}
		
		return false;
		
		
	}

}
