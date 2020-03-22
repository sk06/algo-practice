import java.util.Arrays;


/*
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are set to 0. 
 * 
 */
public class ArraysAndStrings8_ZeroMatrix {
	
	public static void main(String[] args){
		
		int[][] inputMatrix = { {1,2,3,4,5},
								{6,7,8,9,8},
								{1,2,0,3,4},
								{5,0,6,7,8}};
		System.out.println(Arrays.deepToString(ZeroMatrix(inputMatrix)));	
	}

	private static int[][] ZeroMatrix(int[][] inputMatrix) {
		
		boolean[] rows = new boolean[inputMatrix.length];
		boolean[] columns = new boolean[inputMatrix[0].length];
		
		for (int i =0; i < inputMatrix.length; i++){
			for (int j = 0; j < inputMatrix[i].length; j++){
				if (inputMatrix[i][j] == 0){
					rows[i] = true;
					columns[j] =  true;
				}
			}
		}
		return setZeroRowColumn(inputMatrix, rows, columns);
		
	}

	private static int[][] setZeroRowColumn(int[][] inputMatrix, boolean[] rows, boolean[] columns) {
		int[][] outputMatrix = inputMatrix.clone();
		System.out.println("Setting rows->"+Arrays.toString(rows)+" columns->"+Arrays.toString(columns)+"to 0");
		for (int i =0; i < inputMatrix.length; i++){
			for (int j = 0; j < inputMatrix[i].length; j++){
				if (rows[i] || columns[j]){
					outputMatrix[i][j] = 0;
				}
			}
		}
		return outputMatrix;
	}
}
