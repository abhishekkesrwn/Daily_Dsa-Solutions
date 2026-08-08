/**
 * Problem: Longest Possible Route in a Matrix with Hurdles

 * Platform: GFG
 * Difficulty: Medium
 * Pattern: BackTracking
 * Solve Type: Self 
 *
 * Key Insight: explore all the paths to find the maxPathLength, return if base condition or in case of hurdle
 * Time: O(4 ^(n+m)
 * Space: O(N) //call stack
 */
class Solution {
	int maxLength;
	int m;
	int n;
	public void solve(int[][] mat, int xs, int ys, int xd, int yd, int length) {
		if (xs < 0 || ys < 0 || xs >= m || ys >= n || mat[xs][ys] == 0) {
			return ;
		}
		
		if (xs == xd && ys == yd) {
			maxLength = Math.max(maxLength, length);
			return;
		}
		
		int[] distx = {1, -1, 0, 0};
		int[] disty = {0, 0, -1, 1};
		//mark visited
		mat[xs][ys] = 0;
		for (int i = 0; i<4; i++) {
			solve(mat, xs + distx[i], ys + disty[i], xd, yd, length + 1);
		}
		//mark unvisited
		mat[xs][ys] = 1;
	}
	
	public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {
		// code here
		m = mat.length;
		n = mat[0].length;
		maxLength = -1;
		
		solve(mat, xs, ys, xd, yd, 0);
		return maxLength;
	}
}
