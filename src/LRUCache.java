import java.util.HashMap;


public class LRUCache {

	private HashMap<Integer, Node> lruMap = null;
	int cacheSize = 10;
	Node tail, head;
	
	public class Node {
		public int key;
		public int value;
		public Node prev;
		public Node next;
		
		public Node(int value){
			this.value = value;
		}
		
		public Node()
	    {
	        this.next = null;
	        this.prev = null;
	        this.value = 0;
	        this.key = 0;
	    }
	    
	    public Node(int key, int value, Node next, Node prev)
	    {
	        this.value = value;
	        this.next = next;
	        this.prev = prev;
	        this.key = key;
	    }
	}
	
	public LRUCache(int capacity) {
		lruMap = new HashMap<Integer, Node>(capacity);
		cacheSize = capacity;
    }
    
    public int get(int key) {
    	if (lruMap.containsKey(key)){
    		Node node = lruMap.get(key);
    		if (node != tail){
    			remove(node);
    			addAsLatest(node);
    		}
    		return node.value;
    	} else    	
    		return -1;
    }
    
    public void set(int key, int value) {
    	if (lruMap.containsKey(key)){
    		Node node = lruMap.get(key);
    		node.value = value;
    		if (node != tail){
    			remove(node);
    			addAsLatest(node);
    		}
    	} else {
    		Node newNode = new Node(key, value, null, tail);
    		if (lruMap.size() < cacheSize) {
    			if (lruMap.isEmpty()) {
    				head = newNode;
    				tail = newNode;
    			}	
    		}
    		else
    			remove(head);
    		addAsLatest(newNode);
    	}
    }
    
    private void remove(Node node) {
    	if (node == head)
    		head = node.next;
    	Node prevNode = node.prev;
    	Node nextNode = node.next;
    	if (prevNode!=null) prevNode.next = nextNode;
    	if (nextNode!=null) nextNode.prev = prevNode;
    	lruMap.remove(node.key);
	}

	private void addAsLatest(Node node) {
		Node prevNode = tail;
		prevNode.next = node;
		tail = node;
		lruMap.put(node.key, node);
	}

	public static void main(String[] args) {
			
		/*Input:	10,[set(10,13),set(3,17),set(6,11),set(10,5),set(9,10),get(13),set(2,19),get(2),get(3),set(5,25),get(8),set(9,22),set(5,5),set(1,30),get(11),set(9,12),get(7),get(5),get(8),get(9),set(4,30),set(9,3),get(9),get(10),get(10),set(6,14),set(3,1),get(3),set(10,11),get(8),set(2,14),get(1),get(5),get(4),set(11,4),set(12,24),set(5,18),get(13),set(7,23),get(8),get(12),set(3,27),set(2,12),get(5),set(2,9),set(13,4),set(8,18),set(1,7),get(6),set(9,29),set(8,21),get(5),set(6,30),set(1,12),get(10),set(4,15),set(7,22),set(11,26),set(8,17),set(9,29),get(5),set(3,4),set(11,30),get(12),set(4,29),get(3),get(9),get(6),set(3,4),get(1),get(10),set(3,29),set(10,28),set(1,20),set(11,13),get(3),set(3,12),set(3,8),set(10,9),set(3,26),get(8),get(7),get(5),set(13,17),set(2,27),set(11,15),get(12),set(9,19),set(2,15),set(3,16),get(1),set(12,17),set(9,1),set(6,19),get(4),get(5),get(5),set(8,1),set(11,7),set(5,2),set(9,28),get(1),set(2,2),set(7,4),set(4,22),set(7,24),set(9,26),set(13,28),set(11,26)]
		Output:	 [-1,19,17,-1,-1,-1,5,-1,12,3,5,5,1,-1,30,5,30,-1,-1,24,18,-1,18,11,18,-1,4,29,30,12,11,29,17,22,18,-1,20,29,-1,-1,20]
		Expected:[-1,19,17,-1,-1,-1,5,-1,12,3,5,5,1,-1,30,5,30,-1,-1,24,18,-1,18,-1,18,-1,4,29,30,12,-1,29,17,22,18,-1,20,-1,18,18,20]*/
						
		LRUCache cache = new LRUCache(10);
		cache.set(10,13);cache.set(3,17); cache.set(6,11); cache.set(10,5);cache.set(9,10);
		System.out.println(cache.get(13));
		cache.set(2,19);
		System.out.println(cache.get(2));
		System.out.println(cache.get(3));
		cache.set(5,25);
		System.out.println(cache.get(8));
		cache.set(9,22);
		cache.set(5,5);cache.set(1,30);
		System.out.println(cache.get(11));
		cache.set(9,12);
		System.out.println(cache.get(7));
		System.out.println(cache.get(5));
		System.out.println(cache.get(8));
		System.out.println(cache.get(9));
		cache.set(4,30); cache.set(9,3);
		System.out.println(cache.get(9));
		System.out.println(cache.get(10));
		System.out.println(cache.get(10));
		cache.set(6,14);cache.set(3,1);
		System.out.println(cache.get(3));
		cache.set(10,11);
		System.out.println(cache.get(8));
		cache.set(2,14);
		System.out.println(cache.get(1));
		System.out.println(cache.get(5));
		System.out.println(cache.get(4));
		cache.set(11,4);cache.set(12,24);cache.set(5,18);
		System.out.println(cache.get(13));
		cache.set(7,23);
		System.out.println(cache.get(8));
		System.out.println(cache.get(12));
		cache.set(3,27);cache.set(2,12);
		System.out.println(cache.get(5));
		cache.set(2,9);cache.set(13,4);cache.set(8,18);cache.set(1,7);
		System.out.println(cache.get(6));
		cache.set(9,29);cache.set(8,21);
		System.out.println(cache.get(5));
		cache.set(6,30);cache.set(1,12);
		System.out.println(cache.get(10));
		cache.set(4,15);cache.set(7,22);cache.set(11,26);cache.set(8,17);cache.set(9,29);
		System.out.println(cache.get(5));
		cache.set(3,4);cache.set(11,30);
		System.out.println(cache.get(12));
		cache.set(4,29);
		System.out.println(cache.get(3));
		System.out.println(cache.get(9));
		System.out.println(cache.get(6));
		cache.set(3,4);
		System.out.println(cache.get(1));
		System.out.println(cache.get(10));
		cache.set(3,29);cache.set(10,28);cache.set(1,20);cache.set(11,13);
		System.out.println(cache.get(3));
		cache.set(3,12);cache.set(3,8);cache.set(10,9);
		cache.set(3,26);
		System.out.println(cache.get(8));
		System.out.println(cache.get(7));
		System.out.println(cache.get(5));
		cache.set(13,17);cache.set(2,27);cache.set(11,15);
		System.out.println(cache.get(12));
		cache.set(9,19);cache.set(2,15);cache.set(3,16);
		System.out.println(cache.get(1));
		cache.set(12,17);cache.set(9,1);cache.set(6,19);
		System.out.println(cache.get(4));
		System.out.println(cache.get(5));
		System.out.println(cache.get(5));
		cache.set(8,1);cache.set(11,7);cache.set(5,2);cache.set(9,28);
		System.out.println(cache.get(1));
		cache.set(2,2);cache.set(7,4);cache.set(4,22);cache.set(7,24);cache.set(9,26);cache.set(13,28);cache.set(11,26);	

	}

}

