import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
 */


public class PermutationsII_47 {

	public static void main(String[] args) {
		PermutationsII_47 solution = new PermutationsII_47();
		solution.permuteUnique(new int[]{1,1,2});
		System.out.println(solution.solutions.toString());

	}
	
	List<List<Integer>> solutions = new ArrayList<>();
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        permute(nums, new int[nums.length], 0);
        return solutions;
    }

	private void permute(int[] nums, int[] sol, int idx) {
		
		if (idx == nums.length){
			solutions.add(Arrays.stream(sol).boxed().collect(Collectors.toList()));
			return;
		}
		
		List<Integer> chosen =  new ArrayList<>();
		for (int i = 0; i<nums.length; i++){
			int temp = nums[i];
			if (temp == Integer.MIN_VALUE) continue;
			if (!chosen.contains(temp)){
				chosen.add(temp);
				nums[i] = Integer.MIN_VALUE;
				sol[idx] = temp;
				permute(nums, sol, idx+1);
				nums[i] = temp;
			}
		}
		return;	
	}

}
