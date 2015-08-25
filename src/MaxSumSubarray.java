
public class MaxSumSubarray {

	public static void main(String[] args) {
		int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		int max_sum = maxSubArraySum(a, a.length);
		System.out.println(max_sum);
	}
	
	static int maxSubArraySum(int a[], int size)
	{
	   int max_so_far = 0, max_ending_here = 0;
	   int i;
	   for(i = 0; i < size; i++)
	   {
	     max_ending_here = max_ending_here + a[i];
	     if(max_ending_here < 0)
	        max_ending_here = 0;
	     if(max_so_far < max_ending_here)
	        max_so_far = max_ending_here;
	    }
	    return max_so_far;
	} 
	 



}
