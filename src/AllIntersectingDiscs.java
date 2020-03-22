import java.util.Arrays;

/*
 * 
 * Given an array A of N integers we draw N discs in a 2D plane, such that i-th disc has center in (0,i) and a radius A[i]. We say that k-th disc and j-th disc intersect, if k-th and j-th discs have at least one common point.

Write a function

int number_of_disc_intersections(int[] A);
which given an array A describing N discs as explained above, returns the number of pairs of intersecting discs. For example, given N=6 and

A[0] = 1
A[1] = 5
A[2] = 2
A[3] = 1
A[4] = 4
A[5] = 0
there are 11 pairs of intersecting discs:

0th and 1st
0th and 2nd
0th and 4th
1st and 2nd
1st and 3rd
1st and 4th
1st and 5th
2nd and 3rd
2nd and 4th
3rd and 4th
4th and 5th
so the function should return 11. The function should return -1 if the number of intersecting pairs exceeds 10,000,000. The function may assume that N does not exceed 10,000,000.
 */
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
