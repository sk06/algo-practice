import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class ShortestPaths {

	public static void main(String[] args) {
		char[][] board = {{'*','s','-','*','-'},
						  {'-','-','-','-','-'},
						  {'*','-','*','*','-'},
						  {'*','-','*','*','-'},
						  {'-','-','e','-','-'}};
		int x = Integer.MAX_VALUE;
		int y = Integer.MAX_VALUE;
		
		//find the source node
		for (int i = 0 ; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				if ( board[i][j] == 's'){
					x = i; y = j;
					break;
				}
			}
		}
		
		
		//shortestPathDfs(board, x, y);
		
		shortestPathBfsDijkstras(board, new Node(x,y));

	}
	
	public static class Node {
		private int x;
		private int y;
		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	private static void shortestPathBfsDijkstras(char[][] board, Node source) {

		int[][] distance = new int[board.length][board[0].length];

		//initialise the distance matrix
		for (int i = 0 ; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				/*if ( board[i][j] == 's')
					distance[i][j] = 1;
				else*/
					distance[i][j] = 0;	
			}
		}
			
		Queue<Node> workQ = new PriorityQueue<Node>(10, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if (o1.x == o2.x && o1.y == o2.y)
					return 0;
				else
					return 1;
			}
		});
		workQ.add(source);
		
		while (!workQ.isEmpty()){

			Node temp = workQ.remove();
			
			if (board[temp.x][temp.y] == 'e') {
				System.out.println(distance[temp.x][temp.y] + 1);
				break;
			}

			if ((temp.y)+1 < board[0].length && board[temp.x][(temp.y) + 1] != '*' && distance[temp.x][(temp.y)+1] == 0) {
				distance[temp.x][(temp.y)+1] = distance[temp.x][temp.y] + 1;
				workQ.add(new Node(temp.x, (temp.y) + 1));
			}

			if ((temp.x)+1 < board.length && board[(temp.x) + 1][temp.y] != '*' && distance[(temp.x)+1][temp.y] == 0)  {
				distance[(temp.x)+1][temp.y] = distance[temp.x][temp.y] + 1;
				workQ.add(new Node((temp.x) + 1, temp.y));
			}

			if ((temp.x)-1 >= 0 && board[(temp.x) - 1][temp.y] != '*' && distance[(temp.x)-1][temp.y] == 0) {
				distance[(temp.x)-1][temp.y] = distance[temp.x][temp.y] + 1;
				workQ.add(new Node((temp.x) - 1, temp.y));
			}

			if ((temp.y)-1 >= 0 && board[temp.x][(temp.y) - 1] != '*' && distance[temp.x][(temp.y)-1] == 0 ) {
				distance[temp.x][(temp.y)-1] = distance[temp.x][temp.y] + 1;
				workQ.add(new Node(temp.x, (temp.y) - 1));
			}

		}
	}

	
	private static void shortestPathDfs(char[][] board, int x, int y) {
		
		boolean[][] visited = new boolean[board.length][board[0].length];
		
		//initialise the visited matrix
		for (int i = 0 ; i < board.length; i++){
			for(int j = 0; j < board[0].length; j++){
				visited[i][j] = false;
			}
		}
		
		
		
	}

}
