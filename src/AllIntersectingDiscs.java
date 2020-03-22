import java.util.Arrays;

public class AllIntersectingDiscs {



		public static void main(String[] args) {
			int[] input = {1,5,2,1,4,0};
			System.out.println(printIntersectingDiscs2(input));
		}
		
		public static int printIntersectingDiscs2(int[] a){

			int result = 0;
			double[] begin = new double[a.length];
			double[] end = new double[a.length];

			for (int i = 0; i < a.length; i++)
			{
				begin[i] = i - a[i];
				end[i] = i + a[i];
			}
			
			Arrays.sort(begin);

			for (int i = 0; i < a.length; i++)
			{
				double e = end[i];
				int index = Arrays.binarySearch(begin, e+0.5);
				int insert = -(index + 1);
				result += (insert - i - 1);
				if (result > 10000000) {return (-1);}
			}

			return result;
			}
		
		public static int printIntersectingDiscs(int[] a){

			int result = 0;
			int[] dps = new int[a.length];
			int[] dpe = new int[a.length];

			for (int i = 0; i < a.length; i++)
			{
				dps[Math.max(0, i - a[i])]++;
				dpe[Math.min(a.length - 1, i + a[i])]++;
			}

			int t = 0;
			for (int i = 0; i < a.length; i++)
			{
				if (dps[i] > 0)
				{
					result += t * dps[i];
					result += dps[i] * (dps[i] - 1) / 2;
					t += dps[i];
				}
				t -= dpe[i];
			}

			return result;
			}

	


}
