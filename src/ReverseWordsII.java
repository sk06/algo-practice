/*
 * Given an input string , reverse the string word by word. 

Example:

Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]
Note: 

A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.
Follow up: Could you do it in-place without allocating extra space?
 */
public class ReverseWordsII {
	
	public void reverseWords(char[] s) {
		
		//reverse entire array
		char temp;
		for (int i=0,j=s.length-1; i< s.length; i++, j--){
			if(i<j){
				temp = s[i];
				s[i] = s[j];
				s[j] = temp;
			}	
		}
		int i=0;
		//reverse individual words
		for (int j=0; j< s.length; j++){
			if (s[j] == ' ' ){
				reverseWord(s, i, j-1);
				i = j+1;
			} else if (j == s.length-1){
				reverseWord(s, i, j);
			}
		}
		//System.out.println(new String(s));     
    }
	
	public void reverseWord(char[] s, int i, int j) {
		char temp;
		while(i<j){
			temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		ReverseWordsII solution = new ReverseWordsII();
		char[] ch = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
		solution.reverseWords(ch);
	}

}
