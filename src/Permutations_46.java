import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
 */
public class Permutations_46 {

	public static void main(String[] args) {
		Permutations_46 solution = new Permutations_46();
		
		solution.permute(new int[]{1,2,3});
		
		System.out.println(solution.solutions.toString());
	}
	
	 List<List<Integer>> solutions = new ArrayList<>();
	    
	 public List<List<Integer>> permute(int[] nums) {

		 permute(nums, new int[nums.length], 0);
		 return solutions;
	 }

	private void permute(int[] nums, int[] sol, int idx) {
		
		if (idx == nums.length){
			solutions.add(Arrays.stream(sol).boxed().collect(Collectors.toList()));
			return;
		}
		
		for (int i = 0; i< nums.length; i++){
			int temp = nums[i];
			if (temp == Integer.MIN_VALUE) continue;
			sol[idx] = temp;
			nums[i] = Integer.MIN_VALUE;
			permute(nums, sol, idx+1);
			nums[i] = temp;
		}
		return;
	}

}
