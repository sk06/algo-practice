
public class SudokuSolverChar {
	
	public static void main(String[] args) {
		char[][] puzzle = {{'.','3','6','9','.','.','.','.','.'},
						  {'4','9','.','3','.','.','5','6','.'},
						  {'2','.','.','.','.','8','.','.','9'},
						  {'6','7','.','8','.','3','9','1','.'},
						  {'3','.','4','1','9','7','6','.','8'},
						  {'.','1','9','6','.','4','.','7','2'},
						  {'9','.','.','2','.','.','.','.','5'},
						  {'.','4','7','.','.','9','.','8','6'},
						  {'.','.','.','.','.','6','1','9','.'}};
		/*
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
		
		printPuzzle(puzzle);
						  
	}

	private static void printPuzzle(char[][] puzzle) {
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle[0].length; j++){
				System.out.print(puzzle[i][j] + ",");
			}
		System.out.println("\n");
		}		
	}

	private static boolean solvePuzzle(char[][] puzzle) {
		
		for (int i = 0; i < puzzle.length; i++) {
			for (int j = 0; j < puzzle[0].length; j++){
				//if 0, place a number between 1 - 9 after checking for validity of the placement
				if (puzzle[i][j] == '.'){
					//return false after this loop if none of the numbers are right
					for(char num = '1'; num <= '9'; num++){
						if (isValidPlacement(puzzle, i, j, num)){
							puzzle[i][j] = num;
							
							if (!solvePuzzle(puzzle)){
								puzzle[i][j] = '.';
							} else 
								return true;
						} 
						
					}
					return false;
				}
			}
		}	
		return true;
		
	}
	
	private static boolean isValidPlacement(char[][] puzzle, int row, int col, char num)
	{
		// Perform the following checks for valid placement of num
	
		//Check if the row and column already has num
		for (int i = 0; i < 9; i++) {
			if (puzzle[row][i] == num || puzzle[i][col] == num)
				return false;
		}
		
		//Check if sub-block already has num		
		for (int i = row/3*3; i < (row/3*3)+3; i++){
			for (int j = col/3*3; j < (col/3*3)+3; j++){
				if (puzzle[i][j] == num)
					return false;
			}
		}	
		
		return true;
	}
}

