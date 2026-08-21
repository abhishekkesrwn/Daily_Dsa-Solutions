/**
 * Problem: Number of Islands
 * Platform: Leetcode
 * Difficulty: Medium
 * Pattern: BFS
 * Solve Type: Fully Viewed
 *
 * Key Insight: visit the grid if it starts with 1, move in four direction and make grid char to 0 to avoid revisit

 * Time: O(N X M)
 * Space: O(1)
 */
[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]class Solution {
    int m;
    int n;
    public void solve(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] == '0'){
            return ;
        }

        grid[i][j] = '0';
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        for(int k=0;k<dx.length;k++){
            solve(grid,i+dx[k], j+dy[k]);
        }
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        m= grid.length;
        n = grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    solve(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
}
