/**
 * Problem: Subsets II
 * Platform: Leetcode
 * Difficulty: Medium
 * Pattern: Backtracking
 * Solve Type: Partially Viewed 
 *
 * Key Insight:skip the duplicates after adding one of them : if(i >idx && nums[i] == nums[i-1])
 * Time: O(N * 2^N)
 * Space: O(V)
 */


class Solution {
    List<List<Integer>> result;
    List<Integer> ans;
    int n;
    public void solve(int[] nums, int idx){
        result.add(new ArrayList<>(ans));

        for(int i=idx;i<n;i++){
            //skip the duplicates after one of them
            if(i> idx && nums[i] == nums[i-1]) continue;
            ans.add(nums[i]);
            solve(nums, i+1);
            ans.remove(ans.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        n = nums.length;
        result = new ArrayList<>();
        ans = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums,0);
        return result;
    }
}
