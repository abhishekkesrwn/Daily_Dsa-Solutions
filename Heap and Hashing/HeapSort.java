/**
 * Problem: Best Time to Buy and Sell Stock II
 * Platform: Leetcode
 * Difficulty: Medium
 * Pattern: Sorting Algorithm
 * Solve Type: Fully Viewed
 
 * Key Insight: heapify the array(non-leaf) to max Heap for ascending order, push largest element to last 
 * Time: O(NlogN)
 * Space: O(1)
 */
class Solution {
    public void heapify(int[] nums, int i, int size) {
        int minIdx = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && nums[minIdx] < nums[left]) {
            minIdx = left;
        }
        if (right < size && nums[minIdx] < nums[right]) {
            minIdx = right;
        }
        if (minIdx != i) {
            int temp = nums[i];
            nums[i] = nums[minIdx];
            nums[minIdx] = temp;
            heapify(nums,minIdx, size);
        }
    }

    public int[] sortArray(int[] nums) {
        //heapify the non leaf nodes
        int n = nums.length;
        for (int i = n / 2; i >= 0; i--) {
            heapify(nums, i, n);
        }
        //swap the element one by one and heapify
        for (int i = n - 1; i > 0; i--) {
            int temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;
            heapify(nums, 0, i);
        }
        return nums;
    }
}
