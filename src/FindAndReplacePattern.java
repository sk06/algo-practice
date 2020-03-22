import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * You have a list of words and a pattern, and you want to know which words in words matches the pattern.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

(Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.)

Return a list of the words in words that match the given pattern. 

You may return the answer in any order.

 

Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
since a and b map to the same letter.
*/

public class FindAndReplacePattern {
	
	public List<String> findAndReplacePattern(String[] words, String pattern) {
	
		List<String> resultSet = new ArrayList<String>();
		for (String word: words){
			if (match(pattern, word)){
				resultSet.add(word);
			}
		}
		return resultSet;
    }
	
	private boolean match(String pattern, String word) {
		
		Map<Character, Character> m1 = new HashMap<>();
		Map<Character, Character> m2 = new HashMap<>();
		
		for (int i=0; i < word.length(); i++){
			char w = word.charAt(i);
            char p = pattern.charAt(i);
            if (!m1.containsKey(w)) m1.put(w, p);
            if (!m2.containsKey(p)) m2.put(p, w);
            if (m1.get(w) != p || m2.get(p) != w)
                return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		FindAndReplacePattern solution = new FindAndReplacePattern();
		String[] words = new String[]{"abc","deq","mee","aqq","dkd","ccc"};
		String pattern ="abb";
		System.out.println(solution.findAndReplacePattern(words, pattern));
	}

}
