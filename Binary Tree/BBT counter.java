/**
 * Problem: BBT counter
 * Platform: GFG
 * Difficulty: Easy Medium
 * Pattern: DP approach
 * Solve Type: Fully Viewed — needs re-attempt
 *
 * Key Insight: for balanced tree : left subtree height : h-1 or right subtree height : h-1, or both has height h. dp[i-1]* dp[i-2]* 2 + dp[i-1]*dp[i-1]

 * Time: O(h)
 * Space: O(h)
 */
// User-defined Solution class

class Solution {
    public int countBT(int h) {
        // code here
        int[] dp = new int[h+1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        //to make balanced binary tree of height h : lheight : h-1 rh : h-2 or 
        //right tree h : h-1 or lh = h-2 or rh = lh = h-1;
        for(int i =2;i<=h;i++){
            dp[i] = dp[i-1]*(dp[i-1] + 2*dp[i-2]);
        }
        return dp[h];
    }
}
