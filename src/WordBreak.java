import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class WordBreak {

	public static void main(String[] args) {
		/*s = "leetcode",
				dict = ["leet", "code"].

				Return true because "leetcode" can be segmented as "leet code".*/
		
		String[] dictArray = {"lee", "t", "code"};
		Set<String> dict = new HashSet<String>(Arrays.asList(dictArray));
		String s  = "leetcode";
		System.out.println("True/False : " + wordBreak3(s, dict));

	}
	
	public static boolean wordBreak2(String s, Set<String> dict) {
		
		if (s.isEmpty())
			return true;
		
		for (int i = 0; i < s.length(); i++){
			if( dict.contains(s.substring(0, i+1))) {
				if (wordBreak2(s.substring(i+1), dict)) {
					return true;
				}
			}
		}
		
        return false;
    }
	
	public static boolean wordBreak(String s, Set<String> dict) {
	
	String[] dictArray = dict.toArray(new String[dict.size()]);
	
	for(int i = 1; i < dict.size()+1; i++){
        for(int j = 0; j < i; j ++){
			//if(dict.contains(s.substring(i, j)) && wordBreak(dict.contains(s))
		}
		
	}
	
	return false;
	}
	public static boolean wordBreak3(String s, Set<String> dict) {
	
	 boolean[] d = new boolean[s.length() + 1]; 
	 d[0] = true; 
	 for (int i = 1; i <= s.length(); ++i) { 
		 for (int j = 0; j < i; ++j) { 
			 if (d[j] && dict.contains(s.substring(j, i)))
					 d[i] = true;
			 } 
		 } 
	 System.out.println(Arrays.toString(d));
	 return d[s.length()]; 
	}

}
