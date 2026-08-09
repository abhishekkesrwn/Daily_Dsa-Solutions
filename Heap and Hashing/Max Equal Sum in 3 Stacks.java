/**
 * Problem: Max Equal Sum in 3 Stacks

 * Platform: GFG
 * Difficulty: Medium
 * Pattern: Greedy approach
 * Solve Type: Partially Viewed
 *
 * Key Insight: As we remove element from the top of stack the remaining sum is the suffix sum up to current element. So, if we put all the suffix sums of stack1 
               and stack2 in an unordered set and traverse the suffix sum array of stack3, and if we find a suffix sum which is present 
               in all three then it is our ans.

 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    public int maxEqualSum(ArrayList<Integer> s1, ArrayList<Integer> s2,
                           ArrayList<Integer> s3) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        int n1 = s1.size();
        int n2 = s2.size();
        int n3 = s3.size();
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        int ans = 0;
        
        for(int i = n1-1;i>=0;i--){
            sum1 += s1.get(i);
            set.add(sum1);
        }
        for(int i = n2-1;i>=0;i--){
            sum2 += s2.get(i);
            if(set.contains(sum2)){
                set2.add(sum2);
            }
            
        }
        for(int i = n3-1;i>=0;i--){
            sum3 += s3.get(i);
            if(set2.contains(sum3)){
                ans = Math.max(ans, sum3);
            }
        }
        return ans;
    }
}
