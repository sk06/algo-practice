import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;


public class CampusBikes_1057 {


	public class Triple{
		public int distance;
		public int wIndex;
		public int bIndex;

		public Triple(int distance, int wIndex, int bIndex){
			this.distance = distance;
			this.wIndex = wIndex;
			this.bIndex = bIndex;
		}

		@Override
		public String toString() {
			return "T[distance=" + distance + ", wIndex=" + wIndex
					+ ", bIndex=" + bIndex + "]";
		}
		
		
	}



	public int[] assignBikes(int[][] workers, int[][] bikes) {

		Set<Integer> assignedWorkers = new HashSet<>();
		PriorityQueue<Triple> q = new PriorityQueue<Triple>(workers.length, new Comparator<Triple>() {

			@Override
			public int compare(Triple o1, Triple o2) {

				if (o1.distance == o2.distance) {
					return ( o1.wIndex == o2.wIndex) ? o1.bIndex - o2.bIndex : o1.wIndex - o2.wIndex;
				}
				return o1.distance - o2.distance;
			}
		});

		for (int i = 0; i < bikes.length;i++){
			for (int j = 0; j < workers.length; j++){
				int dist = Math.abs(bikes[i][0] - workers[j][0]) + Math.abs(bikes[i][1] - workers[j][1]);
				q.add(new Triple(dist, j, i));
			}
		}
		int[] ans = new int[bikes.length];

		while (!q.isEmpty()){
			Triple t = q.poll();
			if(!assignedWorkers.contains(t.wIndex)){
				assignedWorkers.add(t.wIndex);
				ans[t.bIndex] = t.wIndex;
			}
		}

		return ans;
	}


	public static void main(String[] args) {
		CampusBikes_1057 solution = new CampusBikes_1057();
		/*int[][] workers = {{0,0},{1,1},{2,0}};
		int[][] bikes = {{1,0},{2,2},{2,1}};*/
		int[][] workers = {{0,0},{2,1}};
		int[][] bikes = {{1,2},{3,3}};
		int[] bikeAssignment = solution.assignBikes(workers, bikes);

		System.out.println(Arrays.toString(bikeAssignment));

	}
	
	/*[Triple [distance=1, wIndex=0, bIndex=0], 
	 Triple [distance=1, wIndex=1, bIndex=0], 
	 Triple [distance=1, wIndex=2, bIndex=0], 
	 Triple [distance=1, wIndex=1, bIndex=2], 
	 Triple [distance=2, wIndex=1, bIndex=1], 
	 Triple [distance=2, wIndex=2, bIndex=1], 
	 Triple [distance=3, wIndex=0, bIndex=2], 
	 Triple [distance=4, wIndex=0, bIndex=1], 
	 Triple [distance=1, wIndex=2, bIndex=2]]*/

}
