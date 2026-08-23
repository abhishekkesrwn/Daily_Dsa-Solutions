/**
 * Problem: First Missing Positive
 * Platform: Leetcode
 * Difficulty: Hard
 * Pattern: Cyclic index swap
 * Solve Type: Fully Viewed — needs re-attempt
 *
 * Key Insight: The core idea is to rearrange the array so that every valid positive integer $x$ is placed exactly at index $x - 1$ (e.g., the number 1 goes to index 0, 2 goes to index 1, and so on).

 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for(int i=0;i<n ;i++){
            while(nums[i] >= 1 && nums[i] <= n && nums[nums[i] -1] != nums[i]){
                int temp = nums[i];
                nums[i] = nums[temp -1];
                nums[temp -1] = temp;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return n+1;    
    }
}
