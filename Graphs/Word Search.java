/**
 * Problem: Word Search  
 * Platform: Leetcode
 * Difficulty: Medium
 * Pattern: Backtracking
 * Solve Type: Paritally Viewed 
 *
 * Key Insight: compare the characters of 2d array and word at i index move in four direction if matches else return false;

 * Time: O(N*M*4^L)
 * Space: O(1)
 */
class Solution {
    int n;
    int m;
    int wordSize;
    String word;

    public boolean solve(int i, int j,int idx, char[][] board) {
        if (idx == wordSize) {
            return true;
        }
        if (i < 0 || j < 0 || i > n - 1 || j > m - 1 || board[i][j] == '#' || idx > wordSize
        || board[i][j] != word.charAt(idx)) {
            return false;
        }
        char original = board[i][j];
        board[i][j] = '#';

        boolean ans = false;
        
            boolean isFound = solve(i+1,j, idx +1,board) || 
            solve(i-1,j, idx +1,board) ||
            solve(i,j+1, idx +1,board) ||
            solve(i,j-1, idx +1,board) ;
        board[i][j] = original;
        return isFound;
    }

    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        wordSize = word.length();
        char first = word.charAt(0);
        this.word = word;
        boolean result = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == first && solve(i, j, 0, board)) {
                    return true;
                }
            }
        }
        return false;
    }
}
