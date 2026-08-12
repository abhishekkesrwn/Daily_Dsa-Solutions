/**
 * Problem: Maximum Non-Adjacent Nodes Sum

 * Platform: Geeks for Geeks
 * Difficulty: Medium
 * Pattern: Traversal
 * Solve Type: Self
 *
 * Key Insight: create a custom class info to save take and skip information for every node.
                 if we skip the current node then we have option to take or skip its child node and for take : take the current and its child skip value.

 * Time: O(N)
 * Space: O(1)
 */
/*
class Node {
	int data;
	Node left, right;
	
	Node(int data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
*/

class Solution {
	public class Info {
		int skip;
		int take;
		public Info(int skip, int take) {
			this.skip = skip;
			this.take = take;
		}
	}
	public Info solve(Node root) {
		if (root == null) {
			return new Info(0, 0);
		}
		
		Info left = solve(root.left);
		Info right = solve(root.right);
		
		int skip = Math.max(left.skip, left.take) + Math.max(right.skip, right.take);
		int take = root.data + left.skip + right.skip;
		return new Info (skip, take);
	}
	public int getMaxSum(Node root) {
		// code here
		Info in = solve(root);
		int take = in.take;
		int skip = in.skip;
		return Math.max(skip, take);
	}
}
