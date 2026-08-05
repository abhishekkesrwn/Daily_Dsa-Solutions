/**
 * Problem: Maximum Sum of Three Numbers Divisible by Three
 * Platform: Leetcode
 * Difficulty: Medium
 * Pattern: Greedy approach
 * Solve Type: Fully Viewed 
 *
 * Key Insight:Sort the nums. Make arraylist for 0,1,2 remainders : since  one from each and any three numbers from these array list 
                 is multiple of 3, take sum and compare

 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        ArrayList<Integer> rz = new ArrayList<>();
        ArrayList<Integer> ro = new ArrayList<>();
        ArrayList<Integer> rt = new ArrayList<>();
        int maxSum = 0;
        int max = 0;
        int maxz = 0;
        int maxt = 0;
        int maxo = 0;

        for (int num : nums) {
            if (num % 3 == 0) {
                rz.add(num);
            } else if (num % 3 == 1) {
                ro.add(num);
            } else {
                rt.add(num);
            }
        }
        int sz = rz.size();
        int st = rt.size();
        int so = ro.size();
        if (sz > 0 && st > 0 && so > 0) {
            max = ro.get(so - 1) + rt.get(st - 1) + rz.get(sz - 1);
        }
        if (sz >= 3) {
            maxz = rz.get(sz - 1) + rz.get(sz - 2) + rz.get(sz - 3);
        }
        if (so >= 3) {
            maxo = ro.get(so - 1) + ro.get(so - 2) + ro.get(so - 3);
        }
        if (st >= 3) {
            maxt = rt.get(st - 1) + rt.get(st - 2) + rt.get(st - 3);
        }
        maxSum = Math.max(maxz, Math.max(maxo, Math.max(maxt, max)));
        return maxSum;
    }
}
