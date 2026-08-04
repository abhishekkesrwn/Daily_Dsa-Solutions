/**
 * Problem: Best Time to Buy and Sell Stock II
 * Platform: Leetcode
 * Difficulty: Medium
 * Pattern: Greedy approach
 * Solve Type: Fully Viewed — needs re-attempt
 *
 * Key Insight: pocket holds the water. so for the pocket there is left and right boundary and the water level = difference between height min height of boundaries.

 * Time: O(N)
 * Space: O(N)
 */
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int trappedWater = 0;

        //initialisation
        leftMax[0] = height[0];
        rightMax[n-1] = height[n-1];

        //filling the boundary arrays
        for(int i =1;i<n;i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]);
        }

        for(int i =n-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1], height[i]);
        }

        for(int i=0;i<n;i++){
            int minBoundary = Math.min(leftMax[i], rightMax[i]);

            int waterLevel = minBoundary - height[i];

            trappedWater += waterLevel;
        }
        return trappedWater;
    }
}
