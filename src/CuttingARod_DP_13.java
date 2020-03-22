import java.util.HashMap;
import java.util.Map;


/*
 * Cutting a Rod | DP-13
Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. 
Determine the maximum value obtainable by cutting up the rod and selling the pieces. 
For example, if length of the rod is 8 and the values of different pieces are given as following, 
then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)


length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 1   5   8   9  10  17  17  20

And if the prices are as following, then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)

length   | 1   2   3   4   5   6   7   8  
--------------------------------------------
price    | 3   5   8   9  10  17  17  20
 */

public class CuttingARod_DP_13 {
	
	private int cutRod(int[] lengths, int[] prices, int n)
	{
		return cutRod_DPTable(lengths, prices, n);
	}
	

	private int cutRod_recursive(int[] lengths, int[] prices, int n) {
		if (n <= 0){
			return 0;
		}
		int maxSoFar = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++){
			maxSoFar = Integer.max(maxSoFar, cutRod_recursive(lengths, prices, n-lengths[i]) + prices[i]);
		}
	
		return maxSoFar;
	}

	Map<Integer, Integer> memo = new HashMap<>();
	
	private int cutRod_memo(int[] lengths, int[] prices, int n) {
		if (n <= 0){
			return 0;
		}
		if (memo.containsKey(n)){
			return memo.get(n);
		}
		int maxSoFar = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++){
			maxSoFar = Integer.max(maxSoFar, cutRod_memo(lengths, prices, n-lengths[i]) + prices[i]);		
		}
		memo.put(n, maxSoFar);
		return maxSoFar;
	}

	private int cutRodBottomUp(int[] lengths, int[] prices, int[] dptable, int n) {
		if (n <= 0){
			return 0;
		}

		int maxSoFar = Integer.MIN_VALUE;
		for (int i = 0; i < lengths.length; i++){
			if (n-lengths[i] < 0) continue;
			maxSoFar = Integer.max(maxSoFar, dptable[n-lengths[i]] + prices[i]);
		}
		return maxSoFar;
	}
	
	private int cutRod_DPTable(int[] lengths, int[] prices, int n){
		
		int[] dp = new int[n+1];
	
		for (int j = 1; j <= n; j++){
			int maxSoFar = Integer.MIN_VALUE;
			for (int i = 0; i < lengths.length; i++){
				if (j-lengths[i] <= 0) continue;
				maxSoFar = Integer.max(maxSoFar, dp[j-lengths[i]] + prices[i]);
			}
			maxSoFar = Integer.max(maxSoFar, prices[j-1]);
			dp[j] = maxSoFar;
		}
		
		return dp[n];
		
	}
	
	public static void main(String[] args) {
		CuttingARod_DP_13 solution = new CuttingARod_DP_13();
		
		int[] lengths = {1,2,3,4,5,6,7,8};
		int[] prices = {1,5,8,9,10,17,17,20};
		System.out.println(solution.cutRod(lengths, prices, 8));
		solution.memo = new HashMap<>();
		int[] lengths1 = {1,2,3,4,5,6,7,8};
		int[] prices1 = {3,5,8,9,10,17,17,20};
		System.out.println(solution.cutRod(lengths1, prices1, 8));
		

	}

}
