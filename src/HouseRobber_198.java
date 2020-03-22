/*
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
             Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
             Total amount you can rob = 2 + 9 + 1 = 12.
 */
public class HouseRobber_198 {
	
	
	
	public int rob(int[] nums) {
		
		//int rob_recursive = rob_Recursive(nums, nums.length);
        
        int rob_DPTable = rob_DPTable(nums);
        return rob_DPTable;
        
    }
	
	private int rob_Recursive(int[] nums, int n) {
		
		if (n <= 1) return nums[0];
		
		return Math.max(rob_Recursive(nums, n-1), nums[n-1] + rob_Recursive(nums, n-2));

	}

	private int rob_DPTable(int[] nums) {
		
		int[] t = new int[nums.length+1];
		for (int n = 1; n <= nums.length; n++){
			if (n == 1){
				t[n] = nums[0];
			}
			else {
				t[n] = Math.max(t[n-1], nums[n-1]+t[n-2]);
			}
		}
		return t[nums.length];
	}

	public static void main(String[] args) {
		HouseRobber_198 solution = new HouseRobber_198();
		System.out.println(solution.rob(new int[]{1,2,3,1}));
		System.out.println(solution.rob(new int[]{2,7,9,3,1}));
	}

}
