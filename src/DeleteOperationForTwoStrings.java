import java.util.HashMap;
import java.util.Map;

/*
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same, where in each step you can delete one character in either string.

Example 1:
Input: "sea", "eat"
Output: 2
Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 */
public class DeleteOperationForTwoStrings {
	
	public Map<String, Integer> memo = new HashMap<>();
	
	public int minDistance(String word1, String word2) {
		return minDistanceMemoized(word1.toCharArray(), word1.length(), word2.toCharArray(), word2.length());
	}

	public int minDistanceMemoized(char[] word1, int n, char[] word2, int m) {
		String key = String.valueOf(n)+"|"+String.valueOf(m);
		Integer dist = memo.get(key);
		if (dist != null){
			return dist;
		}
		
//		dist =  minDistance2(word1, n, word2, m);
		if (n == 0 && m >0) dist= m;
		else if (m==0 && n>0) dist = n;
		else if (n==0 && m==0) dist= 0;
		else {
			if (word1[n-1] == word2[m-1]){

			dist = minDistanceMemoized(word1, n-1, word2, m-1);
			} else {
				// delete from word2
				int a = minDistanceMemoized(word1, n, word2, m-1);
				int b = minDistanceMemoized(word1, n-1, word2, m);
				dist = 1 + Math.min(a,b);
			}
		}
		
		memo.put(key, dist);
		return dist;
	}
	
	public int minDistance2(char[] word1, int n, char[] word2, int m) {
		
		if (n == 0 && m >0) return m;
		if (m==0 && n>0) return n;
		if (n==0 && m==0) return 0;
		if (word1[n-1] == word2[m-1]){
			return minDistance2(word1, n-1, word2, m-1);
		} else {
			// delete from word2
			int a = minDistance2(word1, n, word2, m-1);
			int b = minDistance2(word1, n-1, word2, m);
			return 1 + Math.min(a,b);
		}
	}

	public static void main(String[] args) {
		DeleteOperationForTwoStrings solution = new DeleteOperationForTwoStrings();
		//System.out.println(solution.minDistance("sea", "eat"));
//		System.out.println(solution.minDistance("dinitrophenylhydrazine",
//		"benzalphenylhydrazone"));
		String x = "dinitrophenylhydrazine";
		String y= "benzalphenylhydrazone";
		System.out.println(solution.minDistanceMemoized(x.toCharArray(), x.length(), y.toCharArray(), y.length()));
		
	}

}
