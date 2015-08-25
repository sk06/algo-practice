
public class PopularItem {

	public static void main(String[] args) {
		
		int[] input = {1,2,3,4,4,4,4,4,5,6,7,8};
		System.out.println(popularItem(input, 0, input.length-1));

	}

	private static int popularItem(int[] input, int start, int end) {
		//for(int index = start; index < end; index++){
			
			if(end - start < input.length/4){
				return -1;
			}
			else
			{
				int mid = (start + end)/2;
				int tempStart=mid, tempEnd = mid;
				
				while(tempStart > 0 && input[tempStart] == input[mid])
					tempStart--;

				while(tempEnd < input.length && input[tempEnd] == input[mid])
					tempEnd++;
				
				if((tempEnd -1) - (tempStart+1) +1 >= input.length/4)
					return input[mid];
				else
					return Math.max(popularItem(input, start, tempStart), popularItem(input, tempEnd, end));
				
			}
		
	}

}
