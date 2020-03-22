/*
 * 256. Paint House
Easy

641

69

Add to List

Share
There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
The cost of painting each house with a certain color is different. You have to paint all the houses such that 
no two adjacent houses have the same color.

The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
For example, costs[0][0] is the cost of painting house 0 with color red; 
costs[1][2] is the cost of painting house 1 with color green, and so on... Find the minimum cost to paint all houses.

Note:
All costs are positive integers.

Example:

Input: [[17,2,17],[16,16,5],[14,3,19]]
Output: 10
Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue. 
             Minimum cost: 2 + 5 + 3 = 10.
             
Input
[[6,4,13],[10,9,15],[14,15,11],[17,15,9],[7,10,13],[18,9,4],[5,20,12]]

Expected Output
54
 */
public class HousePaint_256 {

	public static void main(String[] args) {
		
		HousePaint_256 solution = new HousePaint_256();
		System.out.println(solution.minCost(costs));
		
	}
	
	static int[][] costs = {{17,2,17}};
	int red =0, blue =1, green = 2;
	
	 public int minCost(int[][] costs) {
		 int n = costs.length-1;
		 if (costs.length==0){
			 return 0;
		 }
		 //return Math.min(minCost(n, red), Math.min(minCost(n, blue), minCost(n, green)));
	        
	     return minCost_DPTable(costs)   ;
	 }
	 
	 public int minCost_DPTable(int[][] costs) {
		 
		 int[][] dp = new int[costs.length][costs[0].length];
		 
		 
		 
		 for (int i=0; i<costs[0].length; i++)
		 {
			dp[0][i] =  costs[0][i];
		 }
		 
		 for (int n=1 ; n < costs.length; n++){
			 for (int i=0; i<costs[0].length; i++){
				 int subcost;
				 if (i == red){
					 subcost = Math.min(dp[n-1][blue], dp[n-1][green]);
				 } else if (i == blue){
					 subcost = Math.min(dp[n-1][red], dp[n-1][green]);
				 } else {
					 subcost = Math.min(dp[n-1][red], dp[n-1][blue]);
				 }
				 
				 dp[n][i] = costs[n][i] + subcost;
			 }
		 }
		 
		 return Math.min(dp[costs.length-1][0], Math.min(dp[costs.length-1][1], dp[costs.length-1][2]));
	 }
	 
	 public int minCost(int n, int color) {
		 
		 if (n <= 0)
		 {
			return costs[0][color];
		 }
		 
		 int subcost;
		 if (color == red){
			 subcost = Math.min(minCost(n-1,blue), minCost(n-1,green));
		 } else if (color == blue){
			 subcost = Math.min(minCost(n-1,red), minCost(n-1,green));
		 } else {
			 subcost = Math.min(minCost(n-1,red), minCost(n-1,blue));
		 }
		 
		 return costs[n][color] + subcost;
	        
	 }

}
