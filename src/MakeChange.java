
public class MakeChange {

	public static void main(String[] args) {
		int[] coins = {1,10,25};
		System.out.println(makeChange(coins,30, coins.length-1));
				

	}

	private static int makeChange(int[] coins, int value, int index) {
		
		if (value < 0)
			return 0;
		
		if (value == 0)
			return 1;
		
		if (index < 0)
			return 1;
		
		
		if (value > coins[index])
		
					return Math.min(makeChange(coins,value, index-1), 
							1+makeChange(coins, value-coins[index], index));
		else 
					return makeChange(coins,value, index-1);
			
	}

}
