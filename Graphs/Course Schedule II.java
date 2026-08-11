/**
 * Problem: Course Schedule II
 * Platform: Leetcode
 * Difficulty: Medium
 * Pattern: Topolical Sort
 * Solve Type: Fully Viewed 
 *
 * Key Insight: Detect Cycle in directed graph using dfs ( boolean array stack) and then topological sort using kahn's ALgorithm

 * Time: O(V + E)
 * Space: O(N)
 */
class Solution {
    ArrayList<ArrayList<Integer>> adj;
    boolean[] vis;
    boolean[] stack;
    public boolean hasCycle(int curr){
        vis[curr] = true;
        stack[curr] = true;
        for(int nbr : adj.get(curr)){
            if(stack[nbr]){
                return true;
            }
            if(!vis[nbr]){
                if(hasCycle(nbr)){
                    return true;
                }
            }
            //remove current element from stack
        }
        stack[curr] = false;
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();
        vis = new boolean[numCourses];
        stack = new boolean[numCourses];

        for(int i =0;i<numCourses;i++)   {
            adj.add(new ArrayList<>());
        }

        for(int edge[] : prerequisites){
            //directed graph
            adj.get(edge[1]).add(edge[0]);
        }

        boolean isCycle = false;
        
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(hasCycle(i)){
                    isCycle = true;
                    break;
                }
            }
        }
        if(isCycle) return new int[]{};
        Queue<Integer> q = new LinkedList<>();
        int[] indeg = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            for(int nbr : adj.get(i)){
                indeg[nbr]++;
            }
        }
        for(int i=0;i<indeg.length;i++){
            if(indeg[i] == 0){
                q.add(i);
            }
        }
        int[] result = new int[numCourses];
        int idx =0;
        while(!q.isEmpty()){
            int curr = q.remove();
            result[idx++] = curr;
            for(int nbr : adj.get(curr)){
                indeg[nbr]--;
                if(indeg[nbr] == 0){
                    q.add(nbr);
                }
            }
        }
        return result;
    }
}
