import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 * 
 * 
 */
public class TwoSum {
	
	
	    public static int[] twoSum(int[] nums, int target) {
	        
	        for (int i= 0; i< nums.length; i++){
	        	int num1 = nums[i];
	        	int index = search(nums, target - num1, i);
	        	if(index > 0)
	        	{
	        		return new int[]{i, index};
	        	}
	        }
	        return new int[0];      
	    }
	    
	    private static int search(int[] nums, int key, int currentIndex) {
			for (int i=0; i< nums.length; i++){
				if (nums[i] == key && currentIndex != i){
					return i;
				}
			}
			return 0;
		}
	    
	    public static int[] twoSum_Better(int[] nums, int target) {
	        Map<Integer, Integer> map = new HashMap<>();
	        for (int i = 0; i < nums.length; i++) {
	            int complement = target - nums[i];
	            if (map.containsKey(complement)) {
	                return new int[] { map.get(complement), i };
	            }
	            map.put(nums[i], i);
	        }
	        throw new IllegalArgumentException("No two sum solution");
	    }

		public static void main(String[] args){
	    	int[] nums = new int[]{2,7,2,5,3};
	    	int target = 8;
	    	//System.out.println(Arrays.toString(twoSum(nums, target)));
	    	System.out.println(Arrays.toString(twoSum_Better(nums, target)));
	    	
	    }
	

}
