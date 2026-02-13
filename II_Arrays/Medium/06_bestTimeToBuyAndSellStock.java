package II_Arrays.Medium;

//optimal
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else
                profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
//TC - O(N)
//SC - O(1)




//Brute
/*
 * class Solution {
 * public int maxProfit(int[] prices) {
 * int maxProfit = 0;
 * 
 * for (int i = 0; i < prices.length; i++) { // buy day
 * for (int j = i + 1; j < prices.length; j++) { // sell day
 * int profit = prices[j] - prices[i];
 * if (profit > maxProfit) {
 * maxProfit = profit;
 * }
 * }
 * }
 * 
 * return maxProfit;
 * }
 * }
 */
