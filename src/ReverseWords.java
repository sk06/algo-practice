import java.util.StringTokenizer;

public class ReverseWords {

	public static void main(String[] args) {
		String s = "the sky is blue";
		//s = "  a  b";
		//System.out.println(reverse(s));
		System.out.println(betterReverse(s));

	}
	
	private static String betterReverse(String s) {
		
		//reverse the entire string
		char[] sArr = s.toCharArray();
		int i = 0, j=sArr.length-1; 
				
		while (i <=j ) {
			char tmp = sArr[i];
			sArr[i]=sArr[j];
			sArr[j]=tmp;
			i++;
			j--;
		}
		
		System.out.println(sArr);
		
		//then reverse each word
		int wStart = 0, wEnd = 0;
		while (wStart <= wEnd && wEnd < sArr.length - 1){
			if (Character.isLetterOrDigit(sArr[wEnd]) )			
				wEnd++;
			else {
				reverseWord(sArr, wStart, wEnd-1);
				int tmp = wEnd;
				if (wEnd <= sArr.length - 1){
					wEnd = tmp+1;
					wStart = wEnd;
				}		
			}	
		}
		
		return new String(sArr);
	}

	private static void reverseWord(char[] sArr, int wStart, int wEnd) {
		while (wStart <= wEnd ) {
			char tmp = sArr[wStart];
			sArr[wStart]=sArr[wEnd];
			sArr[wEnd]=tmp;
			wStart++;
			wEnd--;
		}
		
	}

	public static String reverse(String s) {
		if (s == null || s.equals(" ") || s.isEmpty())
            return s;
		String[] words = s.split("\\s+");
		StringBuffer sb = new StringBuffer();
		for (int i = words.length - 1; i >= 0 ; i--)
		{
			if(words[i].trim() != "") {
			    sb.append(words[i]);
			    sb.append(" ");
		    }
			
		}
		return sb.toString();
        
    }

}
