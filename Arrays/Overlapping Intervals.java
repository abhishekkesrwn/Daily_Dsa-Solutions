/**
 * Problem: Overlapping Intervals
 * Platform: GFG
 * Difficulty: Medium
 * Pattern: Greedy approach
 * Solve Type: Self
 *
 * Key Insight: use greedy approach to sort the interval array according its start if first end> seconds end merge two intervals and remove second

 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    public ArrayList<ArrayList<Integer>> mergeOverlap(int[][] arr) {
        // Code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        for(int[] el : arr){
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(el[0]);
            ans.add(el[1]);
            result.add(ans);
        }
        
        result.sort((a,b) -> a.get(0) - b.get(0));
        int i =0;
        while(i<result.size()-1){
            ArrayList<Integer> a = result.get(i);
            ArrayList<Integer> b = result.get(i+1);
            
            int aEnd = a.get(1);
            int bStart = b.get(0);
            int bEnd = b.get(1);
            
            if(aEnd >= bStart){
                aEnd = Math.max(aEnd, bEnd);
                a.set(1, aEnd);
                result.remove(i+1);
            }
            else i++;
        }
        return result;
    }
}
