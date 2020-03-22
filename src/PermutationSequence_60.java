import java.util.Arrays;

/*
 * The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
 */

public class PermutationSequence_60 {

	public static void main(String[] args) {
		PermutationSequence_60 solution = new PermutationSequence_60();
		System.out.println(solution.getPermutation(3, 3));
	}
	
	int kSoFar = 0;
	
	public String getPermutation(int n, int k) {
		
		int[] nums = new int[n];
		for (int i = 0; i < n; i++){
			nums[i] = i+1;
		}
		
        int[] kSol = getPermutation(nums, new int[n], k, 0);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < kSol.length; i++){
            sb.append(kSol[i]);
        }
        return sb.toString(); 
    }

	private int[] getPermutation(int[] nums, int[] sol, int k, int idx) {
		if (idx == nums.length){
			kSoFar++;
		}
		
		for (int i = 0; i<nums.length; i++){
			int temp = nums[i];
			if (temp == Integer.MIN_VALUE) continue;
			nums[i] = Integer.MIN_VALUE;
			sol[idx] = temp;
			getPermutation(nums, sol, k, idx+1);
			if (k == kSoFar){
				return sol;
			}
			nums[i] = temp;
		}
		
		return sol;
		
	}

}
