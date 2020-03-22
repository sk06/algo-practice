import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]

Input: [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]

 */

public class VerticalOrderTraversalOfBinaryTree {
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<int[]>> out = new TreeMap<Integer,List<int[]>>();
        verticalTraversal(root, out, 0,0);
        if (root == null){
        	return Collections.EMPTY_LIST;
        }
        List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
        for(List<int[]> y_val: out.values()) {
            Collections.sort(y_val, (a, b) -> (b[0]-a[0] == 0 ? a[1]-b[1]: b[0]-a[0]));
			List<Integer> list = new ArrayList<>();
            for(int[] pair: y_val) {
                list.add(pair[1]);
            }
            listOfLists.add(list);
        }
        return listOfLists;        
    }
	
	public void verticalTraversal(TreeNode node, Map<Integer,List<int[]>> out, int x, int y){
		if (node == null){
			return;
		}
		out.computeIfAbsent(x, k -> new ArrayList<>()).add(new int[]{y,node.val});
		verticalTraversal(node.left, out, x-1, y-1);
		verticalTraversal(node.right, out, x+1, y-1);
	}
	
	public List<List<Integer>> verticalTraversalBFS(TreeNode root) {
        Map<Integer, List<Integer>> out = new TreeMap<Integer,List<Integer>>();
        if (root == null){
        	return Collections.EMPTY_LIST;
        }
        List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
        
        
        
        return listOfLists;        
    }

	public static void main(String[] args) {
		
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
		TreeNode four = new TreeNode(4);
		TreeNode five = new TreeNode(5);
		TreeNode six = new TreeNode(6);
		TreeNode seven = new TreeNode(7);
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		one.left = two;
		one.right = three;
		TreeNode root = one;
		
		VerticalOrderTraversalOfBinaryTree solution = new VerticalOrderTraversalOfBinaryTree();
		System.out.println(solution.verticalTraversal(root));
	}

}
