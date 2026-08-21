/**
 * Problem: Closest Equal Element Queries
 * Platform: Leetcode
 * Difficulty: Medium
 * Pattern: Greedy 
 * Solve Type: Fully Viewed 
 *
 * Key Insight: add new array list for numbers of nums array and store
               indexes in the list. find prev and next index and compare linear and circular distance and store in closest array of curr index.

 * Time: O(N)
 * Space: O(N)
 */
class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int n = nums.length;
        int[] closest = new int[n];

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        Arrays.fill(closest, -1);

        for (ArrayList<Integer> list : map.values()) {
            int m = list.size();
            if (m <= 1)
                continue;

            for (int i = 0; i < m; i++) {
                int curr = list.get(i);
                int prev = list.get((i-1 +m)%m);
                int next = list.get((i+1)%m);

                int dist1 = Math.min(Math.abs(curr - prev), n - Math.abs(curr - prev));
                int dist2 = Math.min(Math.abs(curr - next), n - Math.abs(curr - next));
                closest[curr] = Math.min(dist1, dist2);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            ans.add(closest[queries[i]]);
        }
        return ans;
    }
}
