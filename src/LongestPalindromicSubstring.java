
public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		String s = "fdgabababaghgf";
		
		System.out.println(longestPalindromicString(s));

	}

	private static String longestPalindromicString(String s) {
		String prevLongPalindrome = "";
		for (int i = 1; i < s.length(); i++){
			String newPalindrome = checkForLongestPalindromeAroundIndex(s, i);
			if(newPalindrome.length() > prevLongPalindrome.length()) {
				prevLongPalindrome = newPalindrome;
			}
		}
		
		return prevLongPalindrome;
	}

	private static String checkForLongestPalindromeAroundIndex(String s, int i) {
		int beginIndex = i, endIndex = i;
		
		if (i == 0 || i == s.length())
			return s.substring(beginIndex, endIndex);
			
		
		while (beginIndex >= 0 && endIndex < s.length() && s.charAt(beginIndex) ==s.charAt(endIndex)){
			beginIndex--;
			endIndex++;
		}
		
		return s.substring(beginIndex+1, endIndex);
	}

}
