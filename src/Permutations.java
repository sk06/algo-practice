import java.util.Arrays;


public class Permutations {

	public static void main(String[] args) {
		String s[] = {"a", "b", "c", "d"};
		
		//permute(s, 0, s.length -1);
		permutation("", "ABCD"); 
		//myPermutation("abc", 0, "abc".length()-1); //WRONG

	}

	private static void permute(String[] s, int start, int end) {
		
		if (end - start == 1){
			System.out.println(Arrays.toString(s));
			swap(start, end, s);
			System.out.println(Arrays.toString(s));
			swap(start, end, s);
		}
		else
		{
			for( int i = start, j =0; i <= end; i++, j++)
			{
				swap(start, start+j, s);
				permute(s, start+1, end);
				swap(start, start+j, s);
			}
		}
		
	}
	private static void swap(int firstIndex, int lastIndex, String[] s) {
		String temp = s[lastIndex];
		s[lastIndex]=s[firstIndex];
		s[firstIndex]=temp;
	}
	
	private static void permutation(String prefix, String str){
        int n = str.length();
        if (n == 0) 
            System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1));
        }
    }
	
	private static void myPermutation(String input, int start, int end)
	{
		if (input.length() == 2)
		{
			System.out.println(input);
			System.out.println(input.charAt(end)+":"+input.charAt(start));
		}
		else
		{
			for ( int i = start, j = 0; i < input.length(); i++, j++){
				myPermutation(input, start+j, end);
			}
		}
	}


}
