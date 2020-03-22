

/*
 * 
 * Write a method to replace all spaces in a string with '%20'. 
 * You may assume that the string has sufficient space at the end to hold the additional characters 
 * and that you are given the true length of the string
 * EXAMPLE
 * Input: "Mr John Smith ", 13
 * Output: "Mr%20John%20Smith"
 * 
 */
public class ArraysAndStrings3_URLify {
	
	public static void main(String[] args){
		String str = "Mr John Smith    ";
		replaceSpaces(str.toCharArray(), 13);
	}

	private static void replaceSpaces(char[] str, int strLength) {
		int spaceCount = 0, index; 
		for (int i=0; i< strLength ; i++){
			if (str[i] == ' '){
				spaceCount++;
			}
		}
		index = strLength + spaceCount * 2 -1;
		if (strLength < str.length) str[strLength] = '\0';
		for (int j = strLength -1; j >= 0; j--){
			if (str[j] == ' '){
				str[index] = '0';
				str[index-1] = '2';
				str[index-2] = '%';
				index -= 3;
			} else {
				str[index] = str[j];
				index--;	
			}	
		}
		System.out.println(String.valueOf(str));

	}

}
