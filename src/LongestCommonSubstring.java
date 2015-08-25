
public class LongestCommonSubstring {

	public static void main(String[] args) {
		char X[] = "ABCD".toCharArray();
	    char Y[] = "BCFGK".toCharArray();
	
	 
	    System.out.println(LCSubStr(X, Y, X.length, Y.length));

	}
	
	/* Returns length of longest common substring of X[0..m-1] and Y[0..n-1] */
	private static int LCSubStr(char[] X, char[] Y, int m, int n)
	{
	    // Create a table to store lengths of longest common suffixes of
	    // substrings.   Notethat LCSuff[i][j] contains length of longest
	    // common suffix of X[0..i-1] and Y[0..j-1]. The first row and
	    // first column entries have no logical meaning, they are used only
	    // for simplicity of program
	    int[][] LCSuff = new int[m+1][n+1];
	    int result = 0;  // To store length of the longest common substring
	 
	    /* Following steps build LCSuff[m+1][n+1] in bottom up fashion. */
	    for (int i=0; i<=m; i++)
	    {
	        for (int j=0; j<=n; j++)
	        {
	            if (i == 0 || j == 0)
	                LCSuff[i][j] = 0;
	 
	            else if (X[i-1] == Y[j-1])
	            {
	                LCSuff[i][j] = LCSuff[i-1][j-1] + 1;
	                result = Math.max(result, LCSuff[i][j]);
	            }
	            else LCSuff[i][j] = 0;
	            
	        }

            printArray(LCSuff);
	    }
	    return result;
	}

	private static void printArray(int[][] lCSuff) {

		for(int i = 0; i < lCSuff.length; i++){
			for(int j= 0; j < lCSuff[0].length; j++) {
				System.out.print(lCSuff[i][j] + ",");
			}
			System.out.println("\n");
		}
		System.out.println("--------------");
	}

}
