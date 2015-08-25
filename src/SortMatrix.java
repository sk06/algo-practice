import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class SortMatrix {

	public static void main(String[] args) {
		int[][] matrix = {{20,40,60},
						  {5,60,90},
						  {45,50,55}};
		sortMatrix(matrix);
		}
	
	public static class Node {
		private int x;
		private int y;
		private int val;
		public Node(int val, int x, int y){
			this.val = val;
			this.x = x;
			this.y = y;
		}

	}

	private static void sortMatrix(int[][] matrix) {
		Queue<Node> workQ = new PriorityQueue<Node>(10, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o1.val-o2.val;
			}
		});
		
		for(int i = 0; i < matrix.length; i++){
			workQ.add(new Node(matrix[i][0],i, 0)) ;	
		}
		
		while (!workQ.isEmpty()){
			Node temp = workQ.remove();
			
			System.out.println(matrix[temp.x][temp.y]);
			if ((temp.y) + 1 < matrix[0].length)
				workQ.add(new Node(matrix[temp.x][(temp.y)+1],temp.x, (temp.y)+1));
			
		}

		
	}

	

}
