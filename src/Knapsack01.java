
public class Knapsack01 {

	public static void main(String[] args) {
		int val[] = {60, 100, 120};
	    int wt[] = {10, 20, 30};
	    int  W = 50;

	    System.out.println(knapSack(W, wt, val, val.length-1));

	}

	private static int knapSack(int w, int[] wt, int[] val, int index) {
		
		if (index == 0 || w == 0){
			return 0;
		}
		
		if (w < wt[index])
			return knapSack(w, wt, val, index-1);
		else
			return Math.max(val[index] + knapSack(w-wt[index], wt, val, index-1), 
				knapSack(w, wt, val, index-1));
		
		
	}

}
