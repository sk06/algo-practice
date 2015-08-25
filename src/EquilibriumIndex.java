import java.util.ArrayList;
import java.util.List;


public class EquilibriumIndex {

	public static void main(String[] args) {
		long[] input = {-1,3,-4,5,1,-6,2,1};
		System.out.println("EquilibriumIndex is " + findEquilibriumIndex(input));
	}
	
	public static long findEquilibriumIndex(long[] input){
		
		//long[] lSumSoFar = new long[input.length];
		
		long[] rSumSoFar = new long[input.length];
		
		long l_sum_so_far = 0;
		long r_sum_so_far = 0;
		
		for (int i =0, j = rSumSoFar.length-1; i < input.length; i++, j--)
		{
			//lSumSoFar[i] = l_sum_so_far;

			rSumSoFar[j] = r_sum_so_far;
			
			//l_sum_so_far+=input[i];
			
			r_sum_so_far+=input[j];
			
		}
		
		for (int i = 0; i < input.length; i ++){
			
			
			if (l_sum_so_far == rSumSoFar[i])
				return i;
			
			l_sum_so_far+=input[i];
			
		}
		return -1;
	}

}
