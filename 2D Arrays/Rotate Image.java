/**
 * Problem: Rotate Image
 * Platform: Leetcode
 * Difficulty: Medium
 * Pattern: Greedy approach
 * Solve Type: Fully Viewed 
 *
 * Key Insight: swap all the arrays of 2d matrix. then swap the upper half triange with below half except secondary diagonal.

 * Time: O(N)
 * Space: O(1)
 */
class Solution {
    int n;

    public void reverse(int[] arr) {
        int si = 0;
        int ei = n - 1;

        while (si < ei) {
            int temp = arr[si];
            arr[si] = arr[ei];
            arr[ei] = temp;

            si++;
            ei--;
        }
        return;
    }

    public void rotate(int[][] matrix) {
        n = matrix.length;

        for (int[] arr : matrix) {
            reverse(arr);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + j < n - 1) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                    matrix[n - 1 - j][n - 1 - i] = temp;
                }
            }
        }
        return;
    }
}
