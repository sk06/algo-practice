
/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ImmutableListNode {
 *     public void printValue(); // print the value of this node.
 *     public ImmutableListNode getNext(); // return the next node.
 * };
 */

public class LinkedListInReverse {
	
	public static class ImmutableListNode{
		private int value;
		private ImmutableListNode next;
		
		public ImmutableListNode(int value, ImmutableListNode next) {
			this.value = value;
			this.next = next;
		}
		
		public ImmutableListNode(int value) {
			this.value = value;
			this.next = null;
		}
		
		public void printValue(){
			System.out.println(value);
			
		}
		public ImmutableListNode getNext(){
			return next;
		}	
	}
	
	public void printLinkedListInReverse(ImmutableListNode head) {
		int n = lengthOfList(head);
		for (int i = n ; i>0; i--){
			printNthNode(head, i, 1);
		}
	}
		
	
	public void printNthNode(ImmutableListNode node, int n, int i){
		if (node != null && i == n){
			node.printValue();
			return;
		}
		i++;
		printNthNode(node.getNext(), n, i);
	}
	
	public int lengthOfList(ImmutableListNode head){
		if (head == null){
			return 0;
		}
		return 1+ lengthOfList(head.getNext());
	}
	
	public void printLinkedListInReverseBetter(ImmutableListNode head) {
		if (head.getNext() != null){
			 printLinkedListInReverseBetter(head.getNext());
		} 
		head.printValue();
	}
	
	public static void main(String[] args) {
		LinkedListInReverse solution = new LinkedListInReverse();
		ImmutableListNode four = new ImmutableListNode(4);
		ImmutableListNode three = new ImmutableListNode(3, four);
		ImmutableListNode two = new ImmutableListNode(2, three);
		ImmutableListNode head = new ImmutableListNode(1, two);
		//solution.printLinkedListInReverse(head);
		solution.printLinkedListInReverseBetter(head);
	}
	
}
