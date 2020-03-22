/*
 * 37. Sudoku Solver
Hard

1394

82

Add to List

Share
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Empty cells are indicated by the character '.'.
 */
public class SudokuSolver_37 {
	
	public void solveSudoku(char[][] board) {
		if (board == null || board.length == 0)
			return;
			        
		solveSudoku(board, 0, 0);
        
    }
	
	public boolean solveSudoku(char[][] board, int row, int col) {

		if (row == board.length && col == 0){
			printBoard(board);
			return true;
		}

		int nextRow = col == board.length-1 ? row+1 : row;	
		int nextCol = col == board.length-1 ? col/board.length : col+1;
		
		if (board[row][col] == '.'){
			for (char num = '1'; num <= '9'; num++){
				if (validPlacement(board, num, row, col)) {
					board[row][col] = num;
					if(solveSudoku(board, nextRow, nextCol)) return true;
					board[row][col] = '.';	
				}	
			}	
		} else {
			return solveSudoku(board, nextRow, nextCol);
		}
		return false; 
	}


	
	private void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++){
			for (int j = 0; j < board[0].length; j++){
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		
	}

	private boolean validPlacement(char[][] board, char num, int row, int col) {
		//check entire row and column for num
		for (int i = 0; i < board.length; i++){
			if (board[row][i] == num || board[i][col] == num){
				return false;
			}
		}
		
		//check the submatrix for num
		for (int i = (row/3)*3; i < ((row/3)*3)+3; i++){
			for (int j = (col/3)*3; j < ((col/3)*3)+3 ; j++){
				if (board[i][j] == num){
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
			
		char[][] sudoku = { {'5','3','.','.','7','.','.','.','.'},
							{'6','.','.','1','9','5','.','.','.'},
							{'.','9','8','.','.','.','.','6','.'},
							{'8','.','.','.','6','.','.','.','3'},
							{'4','.','.','8','.','3','.','.','1'},
							{'7','.','.','.','2','.','.','.','6'},
							{'.','6','.','.','.','.','2','8','.'},
							{'.','.','.','4','1','9','.','.','5'},
							{'.','.','.','.','8','.','.','7','9'}};
		
		SudokuSolver_37 solution = new SudokuSolver_37();
		solution.solveSudoku(sudoku);
		
	}
	
	

}
