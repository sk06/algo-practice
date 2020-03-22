

/*
 * Given the root of a binary search tree with distinct values, 
 * modify it so that every node has a new value equal to the 
 * sum of the values of the original tree that are greater than or equal to node.val.
 */
public class BstToGst {
	
	   static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	     TreeNode(int x) { val = x; }
	  }
	  
	  public static void main(String[] args){
		  TreeNode root = new TreeNode(4);
		  TreeNode zero = new TreeNode(0);
		  TreeNode one = new TreeNode(1);
		  TreeNode two = new TreeNode(2);
		  TreeNode three = new TreeNode(3);
		  TreeNode four = new TreeNode(4);
		  TreeNode five = new TreeNode(5);
		  TreeNode six = new TreeNode(6);
		  TreeNode seven = new TreeNode(7);
		  TreeNode eight = new TreeNode(8);
		  root.left = one;
		  root.right = six;
		  one.left = zero;
		  one.right=two;
		  two.right=three;
		  six.left = five;
		  six.right = seven;
		  seven.right = eight;
		  //printReverseTree(root);
		  //bstToGst(root);
		  bstToGst(root, sumOfTree(root));
		  printTreeInOrder(root);
		  
	  }

	private static void printTreeInOrder(TreeNode node) {
		
		if (node == null){
			return;
		}
		printTreeInOrder(node.left);
		System.out.println(node.val);
		printTreeInOrder(node.right);	
	}
	
	private static void printReverseTree(TreeNode node) {
		
		if (node == null){
			return;
		}
		printReverseTree(node.right);
		System.out.println(node.val);
		printReverseTree(node.left);		
	}
	
	private static int sumOfTree(TreeNode node) {
		if (node == null){
			return 0;
		}
		return sumOfTree(node.left) + node.val + sumOfTree(node.right);	
	}
	
	public static int bstToGst(TreeNode node, int sum) {
		if (node == null)
		{
			return sum;
		}
        int temp = node.val;
        node.val = bstToGst(node.left, sum);
        return bstToGst(node.right, node.val-temp);
    }
	
	public static TreeNode bstToGst(TreeNode root) {
	    reverseInorder(root,0);
	    return root;
	}
	public static int reverseInorder(TreeNode root,int a){
	    if(root==null)return a;
	    root.val+=reverseInorder(root.right,a);
	    return reverseInorder(root.left,root.val);
	}

}
