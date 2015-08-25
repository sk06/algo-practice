
public class BitMagic {

	public static void main(String[] args) {
		//int i = 15;
		
		//String binStr = Integer.toBinaryString(i);
		
		//System.out.println(binStr);
		
		System.out.println(turnOffK(15,1));
		System.out.println(turnOffK(15,2));
		System.out.println(turnOffK(15,3));
		System.out.println(turnOffK(15,4));
		System.out.println(turnOffK(15,5));
		System.out.println(turnOffK(15,6));

	}
	
	public static	int turnOffK(int n, int k)
	{
	// k must be greater than 0
	if (k <= 0) return n;

	// Do & of n with a number with all set bits except
	// the k'th bit

	int x = (1 << (k - 1));
	int negationOfX= ~x;
	System.out.println(" k-1 = "+ Integer.toBinaryString(k-1));
	System.out.println(" x = "+ Integer.toBinaryString(x));
	System.out.println(" negationOfX = "+ Integer.toBinaryString(negationOfX));
	System.out.println(" n= "+ Integer.toBinaryString(n));
	return (n & negationOfX);
	}

}

