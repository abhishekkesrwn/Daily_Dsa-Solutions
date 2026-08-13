/**
 * Problem: Search in Rotated Sorted Array
 * Platform: Leetcode
 * Difficulty: Medium
 * Pattern: Greedy approach
 * Solve Type: Fully Viewed — needs re-attempt
 *
 * Key Insight:first find the mid of array and its position whether it is on first half of sorted array or second, 
               if it is on first then find the target is on first half or other half and so on

 * Time: O(logN)
 * Space: O(1)
 */
class Solution {
    public int solve(int[] nums, int target, int si, int ei) {
        int mid = si + (ei - si) / 2;
        if (si > ei)
            return -1;
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] >= nums[si]) {
            if (nums[mid] > target && nums[si] <= target) {
                return solve(nums, target, si, mid - 1);
            } else {
                return solve(nums, target, mid + 1, ei);
            }
        } else {
            if (nums[mid] < target && nums[ei] >= target) {
                return solve(nums, target, mid + 1, ei);
            } else {
                return solve(nums, target, si, mid - 1);
            }
        }
    }

    public int search(int[] nums, int target) {
        int si = 0;
        int ei = nums.length - 1;
        return solve(nums, target, si, ei);
    }
}
