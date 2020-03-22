
public class MaxIncreaseSkyline {
	
	public static int maxIncreaseKeepingSkyline(int[][] grid) {
		if (grid.length <= 0){
			return 0;
		}
		int[] topBottom = new int[grid.length];
		int[] leftRight = new int[grid[0].length];
		
		
		for (int i = 0; i < grid.length; i++){
			int temp = 0, temp2 = 0, maxRowSoFar = 0, maxColumnSofar = 0;
			for (int j = 0; j < grid[0].length; j++){
				temp = grid[i][j];
				temp2 = grid[j][i];
				if (maxRowSoFar < temp){
					maxRowSoFar = temp;
				}
				if (maxColumnSofar < temp2){
					maxColumnSofar = temp2;
				}
			}
			leftRight[i] = maxRowSoFar;
			if(maxColumnSofar > topBottom[i])
				topBottom[i] = maxColumnSofar;
		}
		int runningSum =0;
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[0].length; j++){
				runningSum += Math.min(leftRight[i] - grid[i][j], topBottom[j] - grid[i][j]);
			}
		}
		return runningSum;
        
    }
	
	public static void main (String[] args){
		
		int[][] grid = new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
		int[][] grid2 = {{59,88,44},{3,18,38},{21,26,51}};
		System.out.println(maxIncreaseKeepingSkyline(grid));
		System.out.println(maxIncreaseKeepingSkyline(grid2));
		
	}
	
	

}
