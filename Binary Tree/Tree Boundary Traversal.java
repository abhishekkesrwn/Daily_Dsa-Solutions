/**
 * Problem:Tree Boundary Traversal

 * Platform: GFG
 * Difficulty: Medium
 * Pattern: Tree Traversal
 * Solve Type: Fully Viewed
 *
 * Key Insight: first checkfor root is leaf or not. there may be no left
               child while traversing left boundary then its right child will be the boundary vice versa for right boudary

 * Time: O(N)
 * Space: O(H) // call stack height
 */
/* Node Structure
class Node {
	int data;
	Node left, right;
	
	Node(int val) {
		data = val;
		left = right = null;
	}
} */

class Solution {
	ArrayList<Integer> list;
	public boolean isLeaf(Node root) {
		if (root.left == null && root.right == null) {
			return true;
		}
		return false;
	}
	public void left(Node root) {
		if (root == null || isLeaf(root))
			return;
		
		list.add(root.data);
		// Fallback: If left child is null, boundary continues to the right
        if (root.left != null) {
            left(root.left);
        } else {
            left(root.right);
        }
	}
	
	public void leaf(Node root) {
		if (root == null)
			return;
		leaf(root.left);
		leaf(root.right);
		
		if (isLeaf(root)) {
			list.add(root.data);
		}
	}
	public void right(Node root) {
		if (root == null || isLeaf(root))
			return;
		// Fallback: If right child is null, boundary continues to the left
        if (root.right != null) {
            right(root.right);
        } else {
            right(root.left);
        }
		list.add(root.data);
	}
	public ArrayList<Integer> boundaryTraversal(Node root) {
		// code here
		list = new ArrayList<>();
		
		list.add(root.data);
		if(isLeaf(root))return list;
		left(root.left);
		leaf(root);
		right(root.right);
		return list;
	}
}
