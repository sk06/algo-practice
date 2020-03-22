import java.util.Arrays;



/*
 * Given a matrix mat where every row is sorted in increasing order, return the smallest common element in all rows.

If there is no common element, return -1.

 

Example 1:

Input: mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
Output: 5
 

Constraints:

1 <= mat.length, mat[i].length <= 500
1 <= mat[i][j] <= 10^4
mat[i] is sorted in increasing order.
 */
public class SmallestCommonElementInAllRows {
	
	public int smallestCommonElement(int[][] mat) {
		
		if (mat.length == 0){
			return -1;
		}
		if(mat.length == 1){
			return mat[0][0];
		}
		int[] firstRow = mat[0];
		for(int i=0; i<firstRow.length; i++){
			//check if firstRow[i] exists in subsequent rows
			int a = firstRow[i];
			boolean[] aExists =  new boolean[mat.length];
			aExists[0] = true;
			for (int j = 1; j< mat.length; j++){
				aExists[j] = (Arrays.binarySearch(mat[j], a)>=0) ? true: false;
			}
			for (int x = 0; x<aExists.length;x++){
				if (!aExists[x])
					break;
				if (aExists[x] && x == aExists.length -1){
					return a;
				}
					
			}			
		}
		return -1;   
    }

	public static void main(String[] args) {
		
		int[][] mat = new int[][]{{1,2,3,4,5},{2,4,5,8,10},{3,5,7,9,11},{1,3,5,7,9}};
		
		SmallestCommonElementInAllRows solution = new SmallestCommonElementInAllRows();
		System.out.println(solution.smallestCommonElement(mat));
		
	}

}
