/*
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, 
and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
Note:
cost will have a length in the range [2, 1000].
Every cost[i] will be an integer in the range [0, 999].
 */
public class MinCostClimbingStairs_746 {

	public static void main(String[] args) {
		System.out.println(MinCostClimbingStairs_746.minCostClimbingStairs_Recursion(new int[]{10, 15, 20}));
		System.out.println(MinCostClimbingStairs_746.minCostClimbingStairs_Recursion(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
		System.out.println(MinCostClimbingStairs_746.minCostClimbingStairs_DPTable(new int[]{10, 15, 20}));
		System.out.println(MinCostClimbingStairs_746.minCostClimbingStairs_DPTable(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
	}
	
	public static int minCostClimbingStairs_Recursion(int[] cost) {
		
		return minCostClimbingStairs_Recursion(cost, cost.length);
	
	}
	
	public static int minCostClimbingStairs_Recursion(int[] cost, int n) {
		
		if (n <= 1 ){
			return 0;
		} else {
			return Math.min(
					minCostClimbingStairs_Recursion(cost, n-1) + cost[n-1], 
					minCostClimbingStairs_Recursion(cost, n-2) + cost[n-2]
							);
		}
	
	}

	public static int minCostClimbingStairs_DPTable(int[] cost) {
		int n = cost.length;
		int dp[] = new int[n+1];
		for (int i = 2; i<=n; i++){
			dp[i] = Math.min(dp[i-1] + cost[i-1], 
					dp[i-2] + cost[i-2]);
		}
		return dp[n];
	}
}
