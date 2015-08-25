import java.util.Arrays;


public class DutchNationalFlagProblem {

	public static void main(String[] args) {
		int[] input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
		
		triPartition(input);

	}

	private static void triPartition(int[] input) {
		int lo = 0, mid = 0, hi = input.length-1;
		
		while (mid <= hi){
			switch (input[mid]){
			case 0:
				swap (input, lo++, mid++);
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(input, mid, hi--);
				break;
				
			
			}
		}
		
		System.out.println(Arrays.toString(input));
		
	}

	private static void swap(int[] input, int i, int j) {
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;	
	}



}
