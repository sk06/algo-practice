
/*
 * Given a string s of '(' , ')' and lowercase English characters. 

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
 

Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.
Example 4:

Input: s = "(a(b(c)d)"
Output: "a(b(c)d)"

Constraints:

1 <= s.length <= 10^5
s[i] is one of  '(' , ')' and lowercase English letters.
 */
public class MinRemoveForValidParanthesis {
	
	public String minRemoveToMakeValid(String s) {

		int l = 0;
		char[] array = s.toCharArray();
		for (int i=0; i<s.length(); i++){
			char ch = array[i];
			if (ch == '('){
				l++;;
			} else if (ch == ')'){
				if (l>0){
					l--;
				} else {
					array[i] = '-';
				}
			}
		}
		
		
		for (int i=s.length() - 1; i>=0; i--){
				if (l>0){
				if (array[i] == '('){
					array[i] = '-';
					l--;	
				}	
			}
		}
		return new String(array).replace("-", "");
    }

	public static void main(String[] args) {
		MinRemoveForValidParanthesis solution = new MinRemoveForValidParanthesis();
		System.out.println(solution.minRemoveToMakeValid("lee(t(c)o)de)"));
		System.out.println(solution.minRemoveToMakeValid("a)b(c)d"));
		System.out.println(solution.minRemoveToMakeValid("))(("));
		System.out.println(solution.minRemoveToMakeValid("(a(b(c)d)"));
		System.out.println(solution.minRemoveToMakeValid("lee(t(c)o)de)c"));
		System.out.println(solution.minRemoveToMakeValid("())()((("));
		System.out.println(solution.minRemoveToMakeValid("((((("));
	}

}
