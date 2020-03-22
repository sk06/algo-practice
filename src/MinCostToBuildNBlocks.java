import java.util.HashMap;
import java.util.Map;

/*
 * Minimum cost to build N blocks from one block
Given a number N, the task is to build N blocks from 1 block by performing following operation:

Double the number of blocks present in the container and cost for this operation is X.
Increase the number of blocks present in the container by one and cost for this operation is Y.
Decrease the number of blocks present in the container by one and cost for this operation is Z.
Examples:

Input: N = 5, X = 2, Y = 1, Z = 3
Output: 4
Explanation:
In the first operation just increase the number of blocks by one, cost = 1 and block count = 2
In the second operation double the blocks, cost = 3 and block count = 4
In the third operation again increase the number_of_blocks by one, cost = 4 and block count = 5
So minimum cost = 4



Input: N = 7, X = 1, Y = 7, Z = 2
Output: 5
 */
public class MinCostToBuildNBlocks {
	
	int N = 5, X = 2, Y = 1, Z = 3;
	
	Map<Integer, Integer> memo = new HashMap<>();
	//DOES NOT WORK
	public int minCost(int n){

		int[] dp = new int[n+1];
		dp[0] = 1;
		for (int i = 1; i < N; i++){
			if (i == 1){
				dp[i] = 1;;
			} else {
				int case1 = i/2 <= 0  || i %2 ==1? Integer.MAX_VALUE: X + dp[i/2];
				int case2 = i-1 <= 0 ? Integer.MAX_VALUE: Y + dp[i-1];
				int case3 = i+1 >N ? Integer.MAX_VALUE: Z + dp[i+1];
				dp[n] = Math.min(case1, Math.min(case2, case3));
			}
		}

		return dp[n];

	}

	public static void main(String[] args) {
		MinCostToBuildNBlocks solution = new MinCostToBuildNBlocks();
		System.out.println(solution.minCost(5));

	}

}
