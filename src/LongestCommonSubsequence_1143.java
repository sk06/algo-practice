import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Given two strings text1 and text2, return the length of their longest common subsequence.

A subsequence of a string is a new string generated from the original string with some characters(can be none) deleted without changing the relative order of the remaining characters. (eg, "ace" is a subsequence of "abcde" while "aec" is not). A common subsequence of two strings is a subsequence that is common to both strings.

 

If there is no common subsequence, return 0.

 

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
 

Constraints:

1 <= text1.length <= 1000
1 <= text2.length <= 1000
The input strings consist of lowercase English characters only.
 */
public class LongestCommonSubsequence_1143 {

	public static void main(String[] args) {
		LongestCommonSubsequence_1143 solution = new LongestCommonSubsequence_1143();
		//System.out.println(solution.longestCommonSubsequence("abcde", "ace"));
		solution.printAllLCS("abcbdab", "bdcaba");

	}
	
	public void printAllLCS(String s1, String s2){
		
		int m = s1.length(), n = s2.length();
		
		//fill DP table
		int[][] T = new int[m+1][n+1];
		
		for (int i = 1; i<=m; i++){
			for (int j = 1; j<=n; j++){
				if (s1.charAt(i-1) == s2.charAt(j-1)){
					T[i][j] = T[i-1][j-1] + 1;
				} else {
					T[i][j] = Math.max(T[i-1][j], T[i][j-1]);	
				}
			}
		}
		
		
		List<String> allLCS = getAllLCS(s1, s2,m,n,T);
		
		for (String lcs : allLCS){
			System.out.println(lcs);
		}
	}
	
	
	
	private List<String> getAllLCS(String s1, String s2, int m, int n, int[][] T) {
		//Get list of LCS from the DP table
		if (m == 0 || n ==0){
			return Collections.nCopies(1, "");
		}
		if (s1.charAt(m-1) == s2.charAt(n-1)){
			char c = s1.charAt(m-1);
			List<String> lcs = getAllLCS(s1,s2,m-1,n-1,T);
			return lcs.stream().map(s->s+c).collect(Collectors.toList());
		}
		else {
			if (T[m][n-1] == T[m-1][n]){
				List<String> lcsLeft = getAllLCS(s1,s2,m-1,n,T);
				List<String> lcsUp = getAllLCS(s1,s2,m,n-1,T);
				return Stream.concat(
						lcsLeft.stream(),
						lcsUp.stream()).collect(Collectors.toList());
			} else if (T[m][n-1] > T[m-1][n]){
				return getAllLCS(s1,s2,m,n-1,T);
			} else {
				return getAllLCS(s1,s2,m-1,n,T);
			}	
		}
	}

	public int longestCommonSubsequence(String text1, String text2) {

		return LCS_DPTable(text1, text2);
    }
	
	public int LCS_DPTable(String s1, String s2){
		
		int m = s1.length();
		int n = s2.length();
		int[][] T = new int[m+1][n+1];
		
		for (int i = 1; i<=m; i++){
			for (int j = 1; j<=n; j++){
				if (s1.charAt(i-1) == s2.charAt(j-1)){
					T[i][j] = T[i-1][j-1] + 1 ;
				}
				else {
					T[i][j] = Math.max(T[i-1][j], T[i][j-1]);
				}
			}
		}
		return T[m][n];
	}
	
	public int LCS_DPTable_Optimized(String s1, String s2){
		
		int m = s1.length();
		int n = s2.length();
		int prev = 0, curr = 0;
		int[] T = new int[n+1];
		for (int i = 1; i<=m; i++){
			for (int j = 1; j<=n; j++){
				if (s1.charAt(i-1) == s2.charAt(j-1)){
					curr = T[j-1] + 1 ;
				}
				else {
					curr = Math.max(T[j], prev);
				}
				T[j-1] = prev;
				prev = curr;
				T[j] = curr; 
			}
			prev = 0;
		}
		return T[n];
	}
	
	Map<String, Integer> memo = new HashMap<>();
	public int LCS_Memo(String s1, String s2, int m, int n){
		//base case - if either of the strings is empty, LCS is 0,return 0
		if(m == 0 || n ==0){
			return 0;
		}
		
		String key = m+"|"+n;
		
		if (memo.get(key) == null){
			if (s1.charAt(m-1) == s2.charAt(n-1)){
				memo.put(key, LCS_Memo(s1, s2, m-1, n-1) + 1)  ;
			}
			else {
				memo.put(key, Math.max(LCS_Memo(s1, s2,m-1,n), LCS_Memo(s1,s2,m,n-1)));
			}
		}
		
		return memo.get(key);
	}

}
