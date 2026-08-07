/**
 * Problem: Sliding Window Maximum
 * Platform: Leetcode
 * Difficulty: Medium
 * Pattern: Greedy approach
 * Solve Type: Fully Viewed — needs re-attempt
 *
 * Key Insight: use pq to store the num and its index in descending order and remove the element if its index is out of range

 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    public class Pair implements Comparable<Pair> {
        int idx;
        int num;
        public Pair(int idx, int num){
            this.idx = idx;
            this.num = num;
        }
        @Override
        public int compareTo(Pair other){
            return Integer.compare(other.num, this.num);
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n-k + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        for(int i=0;i<k-1;i++){
            pq.add(new Pair(i, nums[i]));
        }
        int j =0;
        for(int i=k-1;i<n;i++){
            pq.add(new Pair(i, nums[i]));
            //remove all the element idx <= i-k : to maintain window
            while(pq.peek().idx <= i-k){
                pq.remove();
            }
            result[j++] = pq.peek().num;
        }
        return result;
    }
}
