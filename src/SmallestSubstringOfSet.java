import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class SmallestSubstringOfSet {

	public static void main(String[] args) {
		String input = "abbcdaaabbbccd";

		HashSet<Character> set = new HashSet<Character>();
		
		set.add('a');
		set.add('b');
		set.add('c');
		
		System.out.println(findMin(input,set));

	}
	
	public static String findMin (String s, HashSet<Character> set){
		int len = set.size() , count = 0 , tail = 0 , minLen = Integer.MAX_VALUE;
		String result = "" ;
		HashMap<Character, Integer> map = new HashMap<> ();
		for (int i = 0 ; i < s.length() ; ++i) {
			char ch = s.charAt(i) ;
			if (set.contains(ch)) {
				int c = map.containsKey(ch) ? map.get(ch) + 1 : 1 ;
				if (c == 1) count++;
				map.put(ch, c) ;
			}
			while (count == len) {					
				if (set.contains(s.charAt(tail))) {
				  	int v = map.get(s.charAt(tail));				  
				  	if (v - 1 == 0) {					  		
				  		count--;
				  	}
				  	map.put(s.charAt(tail), v - 1) ;					 
				}							
			 	if (i - tail + 1 < minLen) {
			  		minLen = i - tail + 1 ;
			  		result = s.substring(tail, i + 1) ;
			  	}	
				tail++;
			}
		}				
		return result;
}

}
