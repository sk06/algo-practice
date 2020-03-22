import java.util.Arrays;



/*
 * 
 * Given two strings, write a method to decide if one is a permutation of the other
 * 
 */

public class ArraysAndStrings2_CheckPermutation {
	
	public static void main(String[] args){
		String str1 = "abcdefghjnvxb";
		String str2 = "ghjnvxbabcdef";
		System.out.println(checkPermutation_Better(str1, str2));
		System.out.println(checkPermutationNoExtraSpace(str1, str2));
	}

	private static boolean checkPermutation_Better(String str1, String str2) {
		
		int[] chars = new int[128];
		
		for (int i=0; i< str1.length(); i++){
			chars[str1.charAt(i)]++;
		}
		
		for (int i = 0; i < str2.length(); i++) {
			chars[str2.charAt(i)]--;
		    if (chars[str2.charAt(i)] < 0) {
		    	return false;
		    }
		}
		
		return true;
	}

	private static boolean checkPermutationNoExtraSpace(String str1, String str2) {
		char[] charArray1 = str1.toCharArray();
		char[] charArray2 = str2.toCharArray();
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		if(Arrays.equals(charArray1, charArray2) ){
			return true;
		}
		return false;
	}

}
