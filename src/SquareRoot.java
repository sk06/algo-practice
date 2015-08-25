
public class SquareRoot {

	public static void main(String[] args) {
		double number = 121;
		squareRoot(number);
		mySquareRoot(number);

	}

	private static void mySquareRoot(double number) {
		
		// guess = number/2
		// sqrt = 1/2(guess + number/guess)
		// continue until guess and sqrt are close
		
		double sqrt = number;
		double guess = number/2;
		
		
		while(sqrt != guess) {
			guess = sqrt;
			sqrt = 0.5 * (guess + number/guess);
			
			if((guess - sqrt) < 1.0)
				break;
		}
		
		System.out.println(sqrt);
		
	}
	
	private static void squareRoot(double number) {
		
		// guess = number/2
		// sqrt = 1/2(guess + number/guess)
		// continue until guess and sqrt are close
		
		double sqrt = number/2;
		double guess;
		
        do
        {
        	guess=sqrt;
        	sqrt = (guess + (number/guess))/2;
        }
        while((guess-sqrt)!=0);
		
		System.out.println(sqrt);
		
	}

}
