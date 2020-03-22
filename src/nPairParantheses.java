
public class nPairParantheses {

	public static void main(String[] args) {

		//return n pairs of parantheses
		printPar(3);

	}
	public static void printPar(int count){
        char[] str = new char[count*2];   // Create a char array to store the parentheses
        printPar(count,count,str,0);      //call the printPar method, the parameters are the left,
                                    //the right parentheses, the array to store the 
                                    //parentheses, and the counter
    }

	public static void printPar(int l, int r, char[] str, int count){  
		//Use recursion method to 
		// print the parentheses

		if(l == 0 && r == 0){     //if there are no parentheses available, print them out  
			System.out.println(str); //Print out the parentheses
		}

		else{
			if(l > 0){    // try a left paren, if there are some available
				str[count] = '(';
				printPar(l - 1, r, str, count + 1); //Recursion
			}
			// Add constraint that a parenthesis is open before inserting a closing paranthesis
			// hence, add l < r - meaning one 'l' is printed before going for an 'r'
			if(r > 0 && l < r){   // try a right paren, if there are some available
				str[count] = ')';
				printPar(l, r - 1, str, count + 1);  //Recursion
			}
		}
	}

}