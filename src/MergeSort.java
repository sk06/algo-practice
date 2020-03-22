import java.util.Arrays;


public class MergeSort {
	
	

	public static void main(String[] args) {
		int[] input = {12,35,767,45,67,87, 9, 23, 1, 34};
		System.out.println(Arrays.toString(input));
		int []tempArray = new int[input.length];
		mSort(tempArray, 0, tempArray.length-1);
		System.out.println(Arrays.toString(input));

	}

	private static void mSort(int[] input, int i, int j) {
		
		while (i < j){
			int mid = (i+j)/2;
			mSort(input, i, mid);
			mSort(input, mid+1, j);
			//merge(input, i, mid+1, j);
		}
		
		
	}
/*
	public static void merge(int []tempArray,int lowerIndexCursor,int higerIndex,int upperIndex){
		
		        int tempIndex=0;
		
		        int lowerIndex = lowerIndexCursor;
		
		        int midIndex = higerIndex-1;
		
		        int totalItems = upperIndex-lowerIndex+1;
		
		        while(lowerIndex <= midIndex && higerIndex <= upperIndex){
		
		            if(input[lowerIndex] < a[higerIndex]){
		
		                tempArray[tempIndex++] = a[lowerIndex++];
		
		            }else{
		
		                tempArray[tempIndex++] = a[higerIndex++];
		
		            }
		
		        }
		
		         
		
		        while(lowerIndex <= midIndex){
		
		            tempArray[tempIndex++] = a[lowerIndex++];
		
		        }
		
		         
		
		        while(higerIndex <= upperIndex){
		
		            tempArray[tempIndex++] = a[higerIndex++];
		
		        }
		
		         
		
		        for(int i=0;i<totalItems;i++){
		
		            a[lowerIndexCursor+i] = tempArray[i];
		
		        }
		
		    }

	*/

}
