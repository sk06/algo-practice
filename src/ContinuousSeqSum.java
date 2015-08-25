
public class ContinuousSeqSum {

	public static void main(String[] args) {
		
		int[] inputArr = {23,5,4,7,2,11,1};
		int sum = 20;
		int sum_so_far = 0;
		for (int i = 0 ; i < inputArr.length; i++){
			for (int j = i; j < inputArr.length; j++){
				sum_so_far = sum_so_far + inputArr[j];
				if (sum_so_far > sum){
					sum_so_far = 0;
					break;
				}
				
				if (sum_so_far == sum)
					System.out.println(true);
			}
		}
		
		

	}

}
