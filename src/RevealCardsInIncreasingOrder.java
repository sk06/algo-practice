import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;


public class RevealCardsInIncreasingOrder {
	
	public int[] deckRevealedIncreasing(int[] deck) {
		Arrays.sort(deck);
		int len = deck.length;
		int[] res = new int[len];
		Deque<Integer> q = new LinkedList<>();		
		for (int i=0; i<len; i++){
			q.add(i);
		}
		for (int card : deck){
			res[q.pollFirst()] = card;
			if (!q.isEmpty())
			{
				q.add(q.pollFirst());
			}
		}
		
		return res;    
    }
	
	public int[] deckRevealedIncreasing_Q(int[] deck) {
		Arrays.sort(deck);
		int len = deck.length;
		int[] res = new int[len];
		Queue<Integer> q = new LinkedList<>();		
		for (int i=0; i<len; i++){
			q.add(i);
		}
		for (int card : deck){
			res[q.poll()] = card;
			if (!q.isEmpty())
			{
				q.add(q.poll());
			}
		}
		
		return res;    
    }

	public static void main(String[] args) {
		RevealCardsInIncreasingOrder solution = new RevealCardsInIncreasingOrder();
		int[] deck = new int[]{17,13,11,2,3,5,7};
		System.out.println(Arrays.toString(solution.deckRevealedIncreasing_Q(deck)));
		
	}

}
