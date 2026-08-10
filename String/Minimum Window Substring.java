/**
 * Problem: Minimum Window Substring
 * Platform: Leetcode
 * Difficulty: Hard
 * Pattern: Sliding Window
 * Solve Type: Fully Viewed — needs re-attempt
 *
 * Key Insight: Approach 1: Use frequency maps (freqP and freqS) to track target and current substring counts. Expand the window frame while updating 
                     frequencies; when frequencies match, record the indices and move the left pointer to find the next valid window.
Approach 2: Store target character frequencies. Expand the window in the source string, decrementing the required count when a match is found. 
Once the count reaches zero, contract the window from the left; if the removed character is part of the target string, increment the count to continue searching.

 * Time: O(N)
 * Space: O(N)
 */
class Solution {
    public String minWindow(String s, String t) {
        int sl = s.length();
        int tl = t.length();

        if (tl > sl)
            return "";

        int right = 0;
        int left = 0;
        int startIdx = 0;
        int minSize = 1000000;
        int count = t.length();
        int[] freqP = new int[128];

        for (int i = 0; i < tl; i++) {
            freqP[t.charAt(i)]++;
        }
        while (right < sl) {
            char rightChar = s.charAt(right);

            if (freqP[rightChar] > 0) {
                count--; // found one of the element
            }
            freqP[rightChar]--;
            right++;
            while (count == 0) {
                int size = right - left;
                if (minSize > size) {
                    startIdx = left;
                    minSize = size;
                }
                //move the window and check
                char leftChar = s.charAt(left);
                freqP[leftChar]++;
                // If a required character is removed from the window, increment count
                if (freqP[leftChar] > 0) {
                    count++;
                }
                left++;
            }
        }
        if (minSize == 1000000) {
            return "";
        }
        return s.substring(startIdx, startIdx + minSize);
    }
}
