/**
 * Problem:/**
 * Problem:Maximum Tastiness of Candy Basket
 * Platform: Leetcode
 * Difficulty: Medium
 * Pattern: Greedy approach
 * Solve Type: Fully Viewed — needs re-attempt
 *
 * Key Insight: mid acts as the current guess for the maximum tastiness of the candy, instead of array we do binary search on tastiness of candy. Ceiling for the 
                 tastiness is difference b/w smallest and largest.

 * Time: O(NlogN + NlogD)
 * Space: O(1)
 */
class Solution {
    private boolean canFormBasket(int[] price, int k, int mid) {
        int count = 1;
        //pick the first candy
        int lastPlaced = price[0];

        for (int i = 1; i < price.length; i++) {
            if (price[i] - lastPlaced >= mid) {
                count++;
                lastPlaced = price[i];
            }
            if (count == k)
                return true;
        }
        return count >= k;
    }

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int left = 0;
        int right = price[price.length - 1] - price[0];
        int maxTastiness = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canFormBasket(price, k, mid)) {
                maxTastiness = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return maxTastiness;
    }
}
