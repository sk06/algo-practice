import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] input = {12,35,767,45,67,87, 9, 23, 1, 34};
		System.out.println(Arrays.toString(input));
		qSort(input, 0, input.length-1);
		System.out.println(Arrays.toString(input));
		
	}

	private static void qSort(int[] input, int left, int right)
	{
		//System.out.println(Arrays.toString(input));
		int index = partition(input, left, right);
		
		if ( left < index - 1)
			qSort(input, left, index - 1);
		if (right > index)
			qSort(input, index, right);
			
	}
	
	private static int partition(int[] input, int left, int right){
		
		int pivot = input[(left + right) / 2];
		int i = left, j = right, tmp;
		while ( i <= j){
			while (input[i] < pivot) 
				i++;
			while (input[j] > pivot)
				j--;
			if (i <= j) {
				tmp = input[i];
				input[i] = input[j];
				input[j] = tmp;
                i++;
                j--;
			}
			
		}
		System.out.println(pivot);
		System.out.println(left);
		System.out.println(right);
		System.out.println(i);
		System.out.println(Arrays.toString(input));
		return i;
	}
	
}
