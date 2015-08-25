import java.util.Arrays;


public class SubsetSumProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,7,4,9,13,8,17,6,1,14};
		//This is exponential time recursive algorithm
		System.out.println(isSubsetSum(arr, arr.length, 19));
		//DP approach 
		System.out.println(isSubsetSumDP(arr, arr.length, 19));
	}

	private static boolean isSubsetSumDP(int[] arr, int n, int sum) {

	    // The value of subset[i][j] will be true if there is a subset of set[0..j-1]
	    //  with sum equal to i
	    boolean[][] subset = new boolean[sum+1][n+1];
	 
	    // If sum is 0, then answer is true
	    for (int i = 0; i <= n; i++)
	      subset[0][i] = true;
	 
	    // If sum is not 0 and set is empty, then answer is false
	    for (int i = 1; i <= sum; i++)
	      subset[i][0] = false;
	 
	     // Fill the subset table in bottom up manner
	     for (int i = 1; i <= sum; i++)
	     {
	       for (int j = 1; j <= n; j++)
	       {
	         subset[i][j] = subset[i][j-1];
	         if (i >= arr[j-1])
	           subset[i][j] = subset[i][j] || subset[i - arr[j-1]][j-1];
	       }
	     }
	 
	     //System.out.println(Arrays.deepToString(subset));	
	     for (int i = 0; i < sum; i++){
	    	 System.out.println(Arrays.toString(subset[i]));
	     }
	 
	     return subset[sum][n];
	
	}

	private static boolean isSubsetSum(int[] arr, int n, int sum) {
		if (sum == 0)
			return true;
		if (n == 0 && sum != 0)
		     return false;
		 
		 // If last element is greater than sum, then ignore it
		 if (arr[n-1] > sum)
		     return isSubsetSum(arr, n-1, sum);
		
		return isSubsetSum(arr, n-1, sum) || isSubsetSum(arr, n-1, sum-arr[n-1]);	
	}

}
