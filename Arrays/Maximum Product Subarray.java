/**
 * Problem: Maximum Product Subarray
 * Platform: Leetcode
 * Difficulty: Medium
 * Pattern: Greedy approach
 * Solve Type: Fully Viewed — needs re-attempt
 *
 * Key Insight: track minsofar and maxsofar. if negative number occur swap both and find if curr element is min or max or currproduct. 
                at every step we decide to continue previous or to start new subarray.

 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    public int maxProduct(int[] nums) {
        int minsofar = nums[0];
        int maxsofar = nums[0];
        int finalmax = nums[0];

        for(int i =1;i<nums.length;i++){
            int num = nums[i];
            if(num < 0){
                int temp = minsofar;
                minsofar = maxsofar;
                maxsofar = temp;
            }
            minsofar = Math.min(num, minsofar*num);
            maxsofar = Math.max(num, maxsofar*num);

            finalmax = Math.max(finalmax, maxsofar);
        }
        return finalmax;
    }
}
