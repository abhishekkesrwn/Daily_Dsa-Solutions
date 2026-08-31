/**
 * Problem: Grid Teleportation Traversal
 * Platform: Leetcode
 * Difficulty: Medium
 * Pattern: BFS Traversal
 * Solve Type: Fully Viewed — needs re-attempt
 *
 * Key Insight: Hashmap to store the position of same portals, then all the portal has same dist and if there is no obstacle then update 
                the dist[nr][nc] by using bfs
 * Time: O(N^w)
 * Space: O(N^2)
 */
class Solution {
    public int minMoves(String[] mat) {
        HashMap<Character, ArrayList<int[]>> portals = new HashMap<>();
        HashSet<Character> usedPortals = new HashSet<>();
        int n = mat.length;
        int m = mat[0].length();
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char curr = mat[i].charAt(j);
                if (curr >= 'A' && curr <= 'Z') {
                    portals.computeIfAbsent(curr, k -> new ArrayList<>()).add(new int[] { i, j });
                }
            }
        }

        int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerFirst(new int[] { 0, 0 });
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;

        while (!dq.isEmpty()) {
            int[] curr = dq.pollFirst();
            int r = curr[0];
            int c = curr[1];

            if (r == n - 1 && c == m - 1) {
                return dist[r][c];
            }
            char currCell = mat[r].charAt(c);
            if (currCell >= 'A' && currCell <= 'Z' && !usedPortals.contains(currCell)) {
                usedPortals.add(currCell);
                for (int[] portal : portals.get(currCell)) {
                    int pr = portal[0];
                    int pc = portal[1];
                    if (dist[pr][pc] > dist[r][c]) {
                        dist[pr][pc] = dist[r][c];
                        dq.offerFirst(new int[] { pr, pc });
                    }
                }
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];
                if (nr >= 0 && nr <= n - 1 && nc >= 0 && nc <= m - 1 && mat[nr].charAt(nc) != '#') {
                    if (dist[nr][nc] > dist[r][c] + 1) {
                        dist[nr][nc] = dist[r][c] + 1;
                        dq.offerLast(new int[] { nr, nc });
                    }
                }
            }
        }
        return -1;
    }
}
