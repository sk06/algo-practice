
/*
 * Assume you have a method isSubstring which checks if oneword is a substring
 * of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one
 * call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat"). 
 * 
 */

public class ArraysAndStrings9_StringRotation {
	
	/*
	 * If we imagine that 52 is a rotation of 51, then we can ask what the rotation point is. For example, if you
rotate waterbottle after wat. you get erbottlewat. In a rotation, we cut 51 into two parts, x and y,
and rearrange them to get 52.
51 = xy = waterbottle
x = wat
y = erbottle
s2 = yx = erbottlewat
So, we need to check if there's a way to split s1 into x and y such that xy = s1 and yx = s2. Regardless of
where the division between x and y is, we can see thatyx will always be a substring of xyxy.That is, s2 will
always be a substring of s1s1. 
	 */
	
	public static void main(String[] args){
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		System.out.println(isStringRotation(s1, s2));
	}

	private static boolean isStringRotation(String s1, String s2) {
		
		if (s1.length() == s2.length() && s1.length() > 0)
		{
			String temp = s1+s1;
			return temp.contains(s2); // return isSubstring(s1s1, s2);
		}

		return false;
	}

}
