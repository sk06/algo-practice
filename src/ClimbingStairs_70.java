/*
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */
public class ClimbingStairs_70 {

	public static void main(String[] args) {
		ClimbingStairs_70 solution =  new ClimbingStairs_70();
		System.out.println(solution.climbStairs(2));
		System.out.println(solution.climbStairs(3));
		System.out.println(solution.climbStairs(10));

	}
	
	public int climbStairs(int n) {
		//int climbStairs_rec = climbStairs_Recursive(n);
		int climbStairs_table = climbStairs_DPTable(n);
		
		return climbStairs_table;
		
	}
	
	public int climbStairs_Recursive(int n) {
		if (n <=1) return 1;
		else if (n==2) return 2;
		else 
			return climbStairs_Recursive(n-1) + climbStairs_Recursive(n-2);

    }
	
	public int climbStairs_DPTable(int n) {
		
		int[] t = new int[n+1];
		
		for (int i = 1; i <=n ; i++){
			if (i==1) t[i] = 1;
			else if (i==2) t[2] = 2;
			else t[i] = t[i-1] + t[i-2];
		}
		return t[n];
		
	}


}
