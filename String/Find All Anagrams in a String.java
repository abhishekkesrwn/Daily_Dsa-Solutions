/**
 * Problem: Find All Anagrams in a String
 * Platform: Leetcode
 * Difficulty: Medium
 * Pattern: Sliding Window
 * Solve Type: Fully Viewed — Mastered after 3 times 
 *
 * Key Insight: create the window by adding frequency thenmove the window of isize = p.lenght and if both the frequency array is equal add its left index
 * Time: O(26N)
 * Space: O(26)
 */


class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        char[] pArr = p.toCharArray();
        char[] sArr = s.toCharArray();
        int psize = pArr.length;
        int ssize = sArr.length;
        int[] pfreq = new int[26];
        int[] sfreq = new int[26];
        int left = 0;
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length()) {
            return list;
        }
        for (int i = 0; i < psize; i++) {
            pfreq[pArr[i] - 'a']++;
        }
        for (int i = 0; i < psize - 1; i++) {
            sfreq[sArr[i] - 'a']++;
        }

        for (int i = psize - 1; i < ssize; i++) {
            sfreq[sArr[i] - 'a']++;

            boolean isFound = true;
            for (int j = 0; j < 26; j++) {
                if (sfreq[j] != pfreq[j]) {
                    isFound = false;
                    break;
                }
            }
            if (isFound) {
                list.add(left);
            }
            sfreq[sArr[left] - 'a']--;
            left++;
        }
        return list;
    }
}
