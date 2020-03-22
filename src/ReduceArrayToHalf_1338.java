import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

/*
 * Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.

Return the minimum size of the set so that at least half of the integers of the array are removed.

 

Example 1:

Input: arr = [3,3,3,3,5,5,5,2,2,7]
Output: 2
Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
Possible sets of size 2 are {3,5},{3,2},{5,2}.
Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has size greater than half of the size of the old array.
Example 2:

Input: arr = [7,7,7,7,7,7]
Output: 1
Explanation: The only possible set you can choose is {7}. This will make the new array empty.
Example 3:

Input: arr = [1,9]
Output: 1
Example 4:

Input: arr = [1000,1000,3,7]
Output: 1
Example 5:

Input: arr = [1,2,3,4,5,6,7,8,9,10]
Output: 5
 

Constraints:

1 <= arr.length <= 10^5
arr.length is even.
1 <= arr[i] <= 10^5
 */
public class ReduceArrayToHalf_1338 {
	
	
	
	public int minSetSize(int[] arr) {
		int size = arr.length, sizeSoFar=0;
		Map<Integer, Integer> map = new TreeMap<>();
		Set<Integer> res = new HashSet<>();
		for (int i=0; i<size; i++){
			map.compute(arr[i], (k, v) -> (v == null) ? 1 : v+1);
		}
		
		if (map.size() == 1){
			return 1;
		}
		
		LinkedHashMap<Integer, Integer> reverseSortedValueMap = new LinkedHashMap<>();
		map.entrySet()
		    .stream()
		    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())) 
		    .forEachOrdered(x -> reverseSortedValueMap.put(x.getKey(), x.getValue()));
		
		for (Map.Entry<Integer,Integer> entry : reverseSortedValueMap.entrySet()){
			if (sizeSoFar < size/2){
				res.add(entry.getKey());
				sizeSoFar+=entry.getValue();
			}
		}
		
		return res.size();
        
    }
	
	public int minSetSize_Heap(int[] arr) {
		int size = arr.length, sizeSoFar=0;
		Map<Integer, Integer> map = new TreeMap<>();
		Set<Integer> res = new HashSet<>();
		for (int i=0; i<size; i++){
			map.compute(arr[i], (k, v) -> (v == null) ? 1 : v+1);
		}

		if (map.size() == 1){
			return 1;
		}

		PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
		pq.addAll(map.entrySet());


		while(!pq.isEmpty())
		{
			Map.Entry<Integer,Integer> entry = pq.remove();
			if (sizeSoFar < size/2){
				res.add(entry.getKey());
				sizeSoFar+=entry.getValue();
			} else 
				break;
		}
		return res.size();
	}
	
	public static void main(String[] args) {
		ReduceArrayToHalf_1338 solution = new ReduceArrayToHalf_1338();
		System.out.println(solution.minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));
		System.out.println(solution.minSetSize_Heap(new int[]{3,3,3,3,5,5,5,2,2,7}));

	}

}
