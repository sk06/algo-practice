
public class SudokuSolver {
	
	public static void main(String[] args) {
		int[][] puzzle = {{0,3,6,9,0,0,0,0,0},
						  {4,9,0,3,0,0,5,6,0},
						  {2,0,0,0,0,8,0,0,9},
						  {6,7,0,8,0,3,9,1,0},
						  {3,0,4,1,9,7,6,0,8},
						  {0,1,9,6,0,4,0,7,2},
						  {9,0,0,2,0,0,0,0,5},
						  {0,4,7,0,0,9,0,8,6},
						  {0,0,0,0,0,6,1,9,0}};
		/* Expected output
		7,3,6,9,4,5,8,2,1,
		4,9,8,3,1,2,5,6,7,
		2,5,1,7,6,8,4,3,9,
		6,7,5,8,2,3,9,1,4,
		3,2,4,1,9,7,6,5,8,
		8,1,9,6,5,4,3,7,2,
		9,6,3,2,8,1,7,4,5,
		1,4,7,5,3,9,2,8,6,
		5,8,2,4,7,6,1,9,3
		*/
		
		
		solvePuzzle(puzzle);
		
		//printPuzzle(puzzle);
						  
	}

	private static void printPuzzle(int[][] puzzle) {
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle[0].length; j++){
				System.out.print(puzzle[i][j] + ",");
			}
		System.out.println("\n");
		}		
	}

	private static boolean solvePuzzle(int[][] puzzle) {
		
		return solvePuzzle(puzzle, 0, 0);
	}
	
	private static boolean solvePuzzle(int[][] puzzle, int row, int col) {
		
		if (row == puzzle.length && col == 0){
			printPuzzle(puzzle);
			return true;
		}
		
		int nextRow = (col == puzzle[0].length - 1) ? row + 1 : row;
		int nextCol = (col == puzzle[0].length - 1) ? 0 : col +1;
			
		if (puzzle[row][col] == 0){
			for (int i = 1; i <= 9; i++){
				if (isValidPlacement(puzzle, row, col, i)){
					puzzle[row][col] = i;
					solvePuzzle(puzzle, nextRow, nextCol);
					puzzle[row][col] = 0;
				}
			}
		} else {
			solvePuzzle(puzzle, nextRow, nextCol);
		}
		
		return false;
	}
	
	private static boolean isValidPlacement(int[][] puzzle, int row, int col, int num)
	{
		//if num already exists in the row or column, return false
		for (int i = 0; i < puzzle.length; i++) {
			if (puzzle[row][i] == num || puzzle[i][col] == num){
				return false;
			}
		}
		//if num exists in the same 3x3 grid, return false
		for (int i = (row/3)*3 ; i < ((row/3)*3)+3; i++){
			for (int j = (col/3)*3; j < ((col/3)*3)+3; j++){
				if (puzzle[i][j] == num){
					return false;
				}
			}
		}
		
		
		return true;
	}

}
