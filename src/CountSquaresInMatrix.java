/*
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

 

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
Example 2:

Input: matrix = 
[
  [1,0,1],
  [1,1,0],
  [1,1,0]
]
Output: 7
Explanation: 
There are 6 squares of side 1.  
There is 1 square of side 2. 
Total number of squares = 6 + 1 = 7.
 

Constraints:

1 <= arr.length <= 300
1 <= arr[0].length <= 300
0 <= arr[i][j] <= 1*/

public class CountSquaresInMatrix {
	
	public int countSquares(int[][] matrix) {
		
		int m = matrix.length;
		int n = matrix[0].length;
		int k = m < n ? m : n;
		int result = 0;
		
		for (int i = 0; i<m ;i++){
			for( int j=0; j<n; j++){
				if (matrix[i][j] == 1){
					int temp = findSquares(matrix,i,j,m,n,k);
					result += temp;
					System.out.println("Squares starting index->"+i+","+j+" are "+temp);
				} 
			}
		}
		
		return result;
        
    }
	
	public int countSquaresDP(int[][] matrix) {
	        int[][] dp = new int[matrix.length][matrix[0].length];
	        int sum = 0;
	        for(int i=0;i<matrix.length;i++){
	            for(int j=0;j<matrix[0].length;j++){
	                if(i==0 || j==0){
	                    dp[i][j] = matrix[i][j]==1?1:0;
	                }else if(matrix[i][j]==1){
	                    dp[i][j] = 1+Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
	                    
	                }
	                
	                sum += dp[i][j];
	            }
	        }
	        return sum;
	}

	private int findSquares(int[][] matrix, int i, int j, int m, int n, int k) {
		
		int squares = 1;
		if(i==1 && j ==0){
			System.out.println("index 1,0");
		}
		for (int s=2; s<k ; s++){
			for (int index = 1; index <=s; index++){
				if(i+index <m && j+index <n){
					if (matrix[i][j+index] == 0 || matrix[i+index][j] == 0 || matrix[i+index][j+index] == 0){
						break;
					}
					squares++;
				}
			}
			System.out.println("Squares of side lenth "+s+" starting at index ->"+i+","+j+ " are "+squares);
			
		}
		return squares;
	}
	
	public static void main(String[] args) {
		CountSquaresInMatrix solution = new CountSquaresInMatrix();
		int[][] matrix = {
		                   {0,1,1,1},
		                   {1,1,1,1},
		                   {0,1,1,1}
		                 };
		
		int[][] matrix2 = {	{0,1,1,1},
							{1,1,0,1},
							{1,1,1,1},
							{1,0,1,0}};
		System.out.println(solution.countSquaresDP(matrix2));
	}

}
