/**
 * Problem: Construct Binary Tree from Preorder and PostOrder.java
 * Platform: Leetcode
 * Difficulty: Medium
 * Pattern: Recursion
 * Solve Type: self 
 *
 * Key Insight: from preorder we get root then find corresponding index in inorder recursively create new root and left subtree includes 
                 all the left part from the root and similar for right subtree

 * Time: O(N)
 * Space: O(N)
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int k =0;
    public TreeNode solve(HashMap<Integer, Integer> map,int[] preorder, int[] inorder, int si, int ei){
        if(si>ei) return null;

        int idx = map.get(preorder[k++]);
        TreeNode root = new TreeNode(inorder[idx]);
        root.left = solve(map, preorder, inorder, si, idx-1);
        root.right = solve(map, preorder, inorder, idx+1, ei);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = preorder.length;
        // to find the index index in inorder using preorder
        for(int i=0;i<n;i++){
            map.put(inorder[i] , i);
        }
        return solve(map, preorder, inorder, 0, n-1);
    }
}
