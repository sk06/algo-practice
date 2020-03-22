import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
 * Given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.

You can attend an event i at any day d where startTimei <= d <= endTimei. Notice that you can only attend one event at any time d.

Return the maximum number of events you can attend.

 

Example 1:


Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.
Example 2:

Input: events= [[1,2],[2,3],[3,4],[1,2]]
Output: 4
Example 3:

Input: events = [[1,4],[4,4],[2,2],[3,4],[1,1]]
Output: 4
Example 4:

Input: events = [[1,100000]]
Output: 1
Example 5:

Input: events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
Output: 7
 

Constraints:

1 <= events.length <= 10^5
events[i].length == 2
1 <= events[i][0] <= events[i][1] <= 10^5
 */
public class MaximumNumberOfEventsThatCanBeAttended_1353 {

	public static void main(String[] args) {
		MaximumNumberOfEventsThatCanBeAttended_1353 solution = new MaximumNumberOfEventsThatCanBeAttended_1353();
		int[][] events = new int[][]{{1,2},{2,3},{3,4}};
		int[][] events2 = new int[][]{{1,3},{1,4},{1,5},{1,1},{1,2},{1,6},{1,7}};
		int[][] events3 = new int[][]{{1,100000}};
		int[][] events4 = new int[][]{{1,2},{1,2},{3,3},{1,5},{1,5}};
		int[][] events5 = new int[][]{{1,5},{1,5},{1,5},{2,3},{2,3}};
		System.out.println(solution.maxEvents(events5));
		
	}
	
	public int maxEvents(int[][] events) {
		
		Arrays.sort(events, new SortbyEnd());
		
		if (events.length == 0) return 0;
		
		int attended = 1, lastDay = events[0][0];
		for (int i= 1; i<events.length; i++){
			int start = events[i][0];
			int end = events[i][1];
			if (end > lastDay){
				attended++;
				lastDay = Math.max(start, lastDay+1);
			}
		}
		return attended;
	}
	
	class SortbyEnd implements Comparator<int[]> { 
        public int compare(int[] a, int[] b) {
        	if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1]; 
        } 
    } 

	Map<Integer, List<Integer>> eventMap = new HashMap<>();
	int firstStart = Integer.MAX_VALUE, lastEnd = Integer.MIN_VALUE, maxEvents = 0;
	
	public int maxEvents_NOGOOD(int[][] events) {
		
		for (int i =0; i< events.length; i++){
			int[] eventArr = events[i];
			int eventId = i;
			int start = eventArr[0];
			int end = eventArr[1];
			if (firstStart > start){
				firstStart = start;
			}
			if (lastEnd < end){
				lastEnd = end;
			}
			for(int j = start; j<=end; j++){
				eventMap.compute(j, (k,v) -> {
		            if(v==null) {
		                v=new ArrayList<>();
		            }
		            v.add(eventId);
		            return v;
		            }	
				);
			}	
		}		
		 maxEvents(firstStart, eventMap, new HashSet<>());  
		 return maxEvents;
    }
	
	void maxEvents(int day, Map<Integer, List<Integer>> events, Set<Integer> attendedEvents) {

		if (day > lastEnd){
			maxEvents = attendedEvents.size() > maxEvents ? attendedEvents.size() : maxEvents;
		} else {

			List<Integer> dayEvents = eventMap.get(day);
			if (dayEvents != null && dayEvents.size() > 0){
				for (Integer dayEvent : dayEvents){
					if (!attendedEvents.contains(dayEvent)){
						attendedEvents.add(dayEvent);
						maxEvents(day+1, events, attendedEvents);
						attendedEvents.remove(dayEvent);
					}
				}
			} 
			
			maxEvents(day+1, events, attendedEvents);
		}        
	}
	
	

}
