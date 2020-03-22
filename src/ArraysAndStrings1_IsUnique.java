
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
public class ArraysAndStrings1_IsUnique {
	/*
	 * Is Unique: 
	 * Implement an algorithm to determine if a string has all unique characters. 
	 * What if you cannot use additional data structures?
	 * 
	 */
	private static boolean isUnique(String str){
		HashMap<String, Integer> charCount = new HashMap<String, Integer>(str.length());
		for (int i =0 ; i< str.length(); i++){
			charCount.compute(Character.toString(str.charAt(i)), (key, val) -> (val == null) ? 1 : val + 1);
		}
		for (Integer value : charCount.values()){
			if (value > 1){
				return false;
			}
		}
		return true;
	};
	
	private static boolean isUnique_Better(String str){
		Set<Character> charSet = new HashSet<>(26);
		Character temp;
		for (int i =0 ; i< str.length(); i++){
			temp = Character.valueOf(str.charAt(i));
			if (charSet.contains(temp)){
				return false;
			}
			charSet.add(temp);
		}
		return true;
	};
	
	private static boolean isUniqueNoExtraSpace(String str){
		for (int i=0; i < str.length(); i++){
			for (int j = i+1 ; j< str.length(); j++){
				if (str.charAt(i) == str.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean isUniqueNoExtraSpace_Better(String str){
		/*System.out.println(1<<3 | 1<<4);
		System.out.println((8 & 1<<3));
		int n = 123;
		System.out.println(n & 1<<1);
		System.out.println((n & 1<<2) > 0);
		System.out.println((n & 1<<3) > 0);
		System.out.println((n & 1<<4) > 0);
		System.out.println(n & 1<<5);
		System.out.println(n & 1<<6);
		System.out.println(n & 1<<7);
		System.out.println(n & 1<<8);*/
		
		if (str.length() > 26) { // Only 26 characters
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) return false;
			checker |= (1 << val);
		}
		return true;
	}
	
	public static void main(String[] args){
		String s = "abcdefghjnvxb";
		//System.out.println(isUnique(s));
		//System.out.println(isUnique_Better(s));
		//System.out.println(isUniqueNoExtraSpace(s));
		//isUniqueNoExtraSpace_Better(s);
		System.out.println(1<<1);
		System.out.println(1<<3 | 1<<4);
		System.out.println((8 & 1<<3));
		int n = 123;
		System.out.println(n & 1<<1);
		System.out.println((n & 1<<2) > 0);
		System.out.println((n & 1<<3) > 0);
		System.out.println((n & 1<<4) > 0);
		System.out.println(n & 1<<5);
		System.out.println(n & 1<<6);
		System.out.println(n & 1<<7);
		System.out.println(n & 1<<8);
	}

}
