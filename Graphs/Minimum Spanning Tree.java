/**
 * Problem: Minimum Spanning Tree - Prim's Algorithm
 * Platform: GFG
 * Difficulty: Medium
 * Pattern: Greedy Approach
 * Solve Type: Fully Viewed
 *Mistake : not added other direction for undirected graph
 * Key Insight: initialise with any node with 0 cost then add its neighbor and cost and grow the tree.use priority queue to move cheap cost node forward. 
                 since the first node we added it ensure that its neighbor or its neighbors’s nbr node willl be there

 * Time: O(ElogE)
 * Space: O(V + E)
 */
class Solution {
	public class Info implements Comparable<Info> {
		int v;
		int wt;
		public Info(int v, int wt) {
			this.v = v;
			this.wt = wt;
		}
		@Override
		public int compareTo(Info other) {
			return Integer.compare(this.wt, other.wt);
		}
		
	}
	public int spanningTree(int V, int[][] edges) {
		// code here
		ArrayList<ArrayList<Info>> adj = new ArrayList<>();
		for (int i = 0; i<V; i++) {
			adj.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			adj.get(edge[0]).add(new Info(edge[1], edge[2]));
			adj.get(edge[1]).add(new Info(edge[0], edge[2]));
		}
		
		PriorityQueue<Info> pq = new PriorityQueue<>();
		boolean[] vis = new boolean[V];
		
		pq.add(new Info(0,0));
		
		int total = 0;
		while (!pq.isEmpty()) {
			Info curr = pq.remove();
			if(!vis[curr.v]){
			    vis[curr.v] = true;
			    total += curr.wt;
			    
			    for(Info i : adj.get(curr.v)){
			        pq.add(new Info(i.v, i.wt));
			    }
			}
		}
		return total;
	}
}
