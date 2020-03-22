
/*
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
 * "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z). 
 * 
 */

public class ArraysAndStrings6_StringCompression {
	
	public static void main(String[] args){
		String str = "aabcccccaaa";
		System.out.println(compress(str));
	}

	private static String compress(String str) {
		
		if (str.length() ==0 || str.length() == 1){
			return str;
		}
		char[] result = new char[str.length()];
		char prev = str.charAt(0);
		int count = 1, index = 0;;
		
		for (int i = 1 ; i< str.length(); i++){
			
			if (str.charAt(i) == prev){
				count++;
			} else {
				if (index == str.length() - 1){
					return str;
				}
				result[index] = prev;
				result[index+1] = Character.forDigit(count, 10);
				index += 2;
				prev = str.charAt(i);	
				count = 1;
			}
			if (i == str.length() - 1){
				result[index] = prev;
				result[index+1] = Character.forDigit(count, 10);
			}		
		}
		
		return String.valueOf(result);
	
		
	}


}
