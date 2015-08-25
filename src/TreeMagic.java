import java.util.Stack;


public class TreeMagic {

	public static void main(String[] args) {
		Node n5 = new Node (5, null, null);
		Node n7 = new Node (7, null, null);
		Node n8 = new Node (8, null, null);
		Node n12 = new Node (12, null, null);
		Node n6 = new Node (6, n5, n7);
		Node n10 = new Node (10, n8, n12);
		Node root = new Node(9, n6, n10);
		
		InOrderWalk(root);
		
		int k = 5;
		
		findKthSmallest(root, k);
		
		findKthLargest(root, k);
		
		circularLinkedList1(root); 

	}
	
	private static void findKthLargest(Node root, int k) {
		Stack<Node> stack = new Stack<Node>();
		
		Node current = root;
		
		while (!stack.isEmpty() || current != null){
			if (current != null) {
				stack.add(current);
				current = current.right;
			} else {
				current = stack.pop();
				k--;
				
				if (k == 0) {
					System.out.println(current.val);
					return;
				}
				
				current = current.left;
				
			}
		}
		
		
	}

	
	public static void findKthSmallest(Node node, int num){
	    Stack<Node> stack = new Stack<Node>();

	    Node current = node;
	    int tmp = num;

	    while(stack.size() > 0 || current!=null){
	        if(current!= null){
	            stack.add(current);
	            current = current.left;
	        }else{
	            current = stack.pop();
	            tmp--;

	            if(tmp == 0){
	                System.out.println(current.val);
	                return;
	            }

	            current = current.right;
	        }
	    }
	}

	private static void InOrderWalk(Node root) {
		if (root.left != null)InOrderWalk(root.left);
		System.out.print(root.val + " ");
		if (root.right != null)InOrderWalk(root.right);
		
	}
	
	private  static Node circularLinkedList1(Node root) {
        Node head =  circularLinkedList(root);
        Node tail = head;
        if (head == null)
            return null;

        while (head.left != null || tail.right != null)
        {
            if (head.left != null) head = head.left;
            if (tail.right != null) tail = tail.right;
        }

        head.left = tail;
        tail.right = head;

        Node tmp = head;

        while(tmp != null){

            System.out.println(tmp.val);
            tmp = tmp.right;
            if(tmp == head){
                break;
            }
        }

        return head;
    }

    private static Node circularLinkedList(Node root) {

        if(root == null) {
            return null;
        }

        Node left = circularLinkedList(root.left );

        if (left != null)
        {
            while (left.right != null)
            {
                left = left.right;
            }
            left.right = root;
            root.left = left;
        }

        Node right = circularLinkedList(root.right);
        if (right != null)
        {
            while (right.left != null)
            {
                right = right.left;
            }
            right.left = root;
            root.right = right;
        }
        return root;
    }

	public static class Node{
		int val;
		Node left;
		Node right;
		public Node(int val, Node left, Node right){
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
