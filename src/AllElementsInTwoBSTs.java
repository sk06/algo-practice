import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/*
 * Given two binary search trees root1 and root2.

	Return a list containing all the integers from both trees sorted in ascending order.
	
Example 1:
Input: root1 = [2,1,4], root2 = [1,0,3]
Output: [0,1,1,2,3,4]

Example 2:
Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
Output: [-10,0,0,1,2,5,7,10]

Example 3:
Input: root1 = [], root2 = [5,1,7,0,2]
Output: [0,1,2,5,7]

Example 4:
Input: root1 = [0,-10,10], root2 = []
Output: [-10,0,10]

Example 5:
Input: root1 = [1,null,8], root2 = [8,1]
Output: [1,1,8,8]

 */

public class AllElementsInTwoBSTs {
	
	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		getInorderList(root1, list1);
		getInorderList(root2, list2);
		
		return mergeLists(list1, list2);
    }
	
	public List<Integer> mergeLists(List<Integer> list1, List<Integer> list2) {
		int m = list1.size();
		int n = list2.size();
		int i=0, j=0;
		List<Integer> mergedList = new ArrayList<>(m+n);
		while(i<m && j<n){
			if (list1.get(i)<list2.get(j)){
				mergedList.add(list1.get(i));
				i++;
			} else {
				mergedList.add(list2.get(j));
				j++;
			}
		}
		if(i < m) {
			addRemaining(list1, mergedList, i);
		}
		if (j < n) {
			addRemaining(list2, mergedList, j);
		}
		
		return mergedList;
	}

	public void addRemaining(List<Integer> list, List<Integer> mergedList, int index) {
		
		while(index<list.size()){
			mergedList.add(list.get(index));
			index++;
		}
	}

	public void getInorderList(TreeNode root, List<Integer> allElements){
		if (root.left == null && root.right == null){
			allElements.add(root.val);
			return;
		}
		if (root!= null){
			if(root.left != null)
				getInorderList(root.left, allElements);
			allElements.add(root.val);
			if(root.right != null)
				getInorderList(root.right, allElements);
		}		
	}
	
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	public static void main(String[] args) {
		AllElementsInTwoBSTs solution = new AllElementsInTwoBSTs();
		
		TreeNode one = new TreeNode(1);
		TreeNode four = new TreeNode(4);
		TreeNode zero = new TreeNode(0);
		TreeNode three = new TreeNode(3);
	
		TreeNode root1 = new TreeNode(2);
		root1.left = one;
		root1.right = four;
		TreeNode root2 = new TreeNode(1);
		root2.left = zero;
		root2.right = three;
		
		//System.out.println(solution.getAllElements(root1, root2));
		System.out.println(solution.getAllElementsOnePass(root1, root2));

	}

	private List<Integer> getAllElementsOnePass(TreeNode root1, TreeNode root2) {
		
		Deque<TreeNode> s1 = new ArrayDeque<>(), s2 = new ArrayDeque<>();
		List<Integer> out = new ArrayList<>();
		
		
		while(root1 != null || root2 != null || !s1.isEmpty() || !s2.isEmpty()){
			
			while (root1 != null){
				s1.push(root1);
				root1=root1.left;
			}
			
			while (root2 != null){
				s2.push(root2);
				root2=root2.left;
			}
			
			if (s2.isEmpty() || !s1.isEmpty() && s1.getFirst().val <= s2.getFirst().val){
				root1 = s1.pop();
				out.add(root1.val);
				root1 = root1.right;
			} else {
				root2 = s2.pop();
				out.add(root2.val);
				root2 = root2.right;
			}
			
		}
		
		return out;
	}

}
