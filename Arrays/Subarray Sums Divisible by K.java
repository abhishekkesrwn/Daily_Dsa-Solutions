/**
 * Problem: Subarray Sums Divisible by K
 * Platform: Leetcode
 * Difficulty: Medium
 * Pattern: Greedy approach
 * Solve Type: Fully Viewed (Mastered)
 *
 * Key Insight: two numbers when divided by k will give same remainder then if both subtracted then will be divisible by k;
 * Time: O(NlogN)
 * Space: O(N)
 */
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int remainderCount[] = new int[k];
        remainderCount[0] = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int remainder = (sum % k + k) % k;
            count += remainderCount[remainder];

            remainderCount[remainder]++;
        }
        return count;
    }
}
