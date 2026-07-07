/**
 * Problem: Best Time to Buy and Sell Stock II
 * Platform: Leetcode
 * Difficulty: Medium
 * Pattern: Greedy approach
 * Solve Type: Fully Viewed — needs re-attempt
 *
 * Key Insight: use greedy approach to sell every time when seen a price greater than current buying price and update bp after selling

 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        int bp = prices[0];

        for(int sp : prices){
            if(bp <sp){
                int profit = sp - bp;
                maxprofit+= profit;
            }
                bp = sp;
        }
        return maxprofit;
    }
}
