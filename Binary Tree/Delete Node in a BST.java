/**
 * Problem: Delete Node in a BST
 * Platform: Leetcode
 * Difficulty: Medium
 * Pattern: Binary Tree Traversal
 * Solve Type: Fully Viewed 
 *
 * Key Insight: search the node to delete. if the node to delete is null return null , if it has single child return that child and for 
             two child : replace value with its inorder successor value then delete the Inordersuccessor node
 * Time: O(N)
 * Space: O(1)
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
    public TreeNode inorderSuccessor(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(root.val > key) {
            root.left = deleteNode(root.left, key);
        }else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }else{
            //leaf
            if(root.left == null && root.right == null) return null;
            if(root.left == null) return root.right;
            else if(root.right == null) return root.left;

            //two child
            TreeNode IS = inorderSuccessor(root.right);
            root.val = IS.val;
            //delete the is node
            root.right = deleteNode(root.right, IS.val);
        }
        return root;
    }
}
