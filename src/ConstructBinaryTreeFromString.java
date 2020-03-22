


/*
 * You need to construct a binary tree from a string consisting of parenthesis and integers.

The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.

You always start to construct the left child node of the parent first if it exists.

Example:
Input: "4(2(3)(1))(6(5))"
Output: return the tree root node representing the following tree:

       4
     /   \
    2     6
   / \   / 
  3   1 5   
Note:
There will only be '(', ')', '-' and '0' ~ '9' in the input string.
An empty tree is represented by "" instead of "()".


  - left dfs
	  2
	   - left dfs (3)
	   - right dfs (1)
	  i++ remove )
  - ri


 */
public class ConstructBinaryTreeFromString {
	
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	     TreeNode(int x) { val = x; }
	  }
	
	int index = 0;
	
    public TreeNode str2tree(String s) {
        if(s.isEmpty()) return null;
        TreeNode root = new TreeNode(getNextDigit(s, 0));
        dfs(root, s);
        return root;
    }
    
    private void dfs(TreeNode root, String s){
        if(index < s.length() && s.charAt(index) == '('){
            root.left = new TreeNode(getNextDigit(s, ++index));
            dfs(root.left, s);
            // Right only if there exists
            if(index < s.length() && s.charAt(index) == '('){
                root.right = new TreeNode(getNextDigit(s, ++index));
                dfs(root.right, s);
            }
        }
        index++;
    }
    
    private int getNextDigit(String s, int start){
        while(index < s.length() && (Character.isDigit(s.charAt(index)) || s.charAt(index) == '-')) index++;
        return Integer.parseInt(s.substring(start, index));
    }
	
	public static void main(String[] args) {
		ConstructBinaryTreeFromString solution = new ConstructBinaryTreeFromString();
		TreeNode root = solution.str2tree("4(2(3)(1))(6(5))");
		
		System.out.println(root);

	}

}
