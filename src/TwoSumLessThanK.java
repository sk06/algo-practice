import java.util.Arrays;

/*
 * Given an array A of integers and integer K, 
 * return the maximum S 
 * such that there exists i < j with A[i] + A[j] = S and S < K. 
 * If no i, j exist satisfying this equation, return -1.
 */
public class TwoSumLessThanK {
	
	static int twoSumLessThanK(int[] A, int K) {
		
		int maxSoFar = -1;
		
		for (int i= 0; i< A.length; i++){
			for (int j = 0; j < A.length; j++){
				if (i != j){
					int currentSum = A[i] + A[j];
					if (currentSum < K && currentSum>maxSoFar){
						maxSoFar = currentSum;
					}
				}
			}
		}
		return maxSoFar;
        
    }
	
	static int twoSumLessThanK_Better(int[] A, int K) {
		
		int maxSoFar = -1;
		int i = 0, j = A.length -1, temp = 0;
		Arrays.sort(A);
		while (i < j){
			temp = A[i] + A[j];
			if (temp >= K){
				j--;
			} 
			else {
				if (maxSoFar < temp) maxSoFar = temp;
				i++;
			}
			
		}
		return maxSoFar;
        
    }
	
	public static void main(String[] args) {
		System.out.println(twoSumLessThanK(new int[]{34,23,1,24,75,33,54,8}, 60));
		System.out.println(twoSumLessThanK(new int[]{10,20,30}, 15));
		System.out.println(twoSumLessThanK_Better(new int[]{34,23,1,24,75,33,54,8}, 60));
		System.out.println(twoSumLessThanK_Better(new int[]{10,20,30}, 15));
		System.out.println(twoSumLessThanK_Better(new int[]{254,914,110,900,147,441,209,122,571,942,136,350,160,127,178,839,201,386,462,45,735,467,153,415,875,282,204,534,639,994,284,320,865,468,1,838,275,370,295,574,309,268,415,385,786,62,359,78,854,944},200));
	}

}
