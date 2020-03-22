  
class AnagramProblem { 
  
	private static final int ALPHABET = 26;
    
    public static void main(String[] args) 
    { 
        String str1 = "hello", str2 = "billion"; 
        System.out.println(characterToAnagram(str1, str2)); 
    }

	private static int characterToAnagram(String str1, String str2) {

		int[] charCount1 = getCharCount(str1);
		int[] charCount2 = getCharCount(str2);
		
		return differenceInCharCount(charCount1, charCount2);
	}

	private static int differenceInCharCount(int[] charCount1, int[] charCount2) {
		int difference = 0;
		for (int i=0; i<ALPHABET; i++){
			difference += Math.abs(charCount1[i] - charCount2[i]);
		}
		return difference;
	}

	private static int[] getCharCount(String str1) {
		int[] charCount = new int[ALPHABET];
		int a = (int)'a';
		for(int i = 0; i<str1.length(); i++){
			char c = str1.charAt(i);
			charCount[(int)c-a]++;
		
		}
		return charCount;
	} 
} 