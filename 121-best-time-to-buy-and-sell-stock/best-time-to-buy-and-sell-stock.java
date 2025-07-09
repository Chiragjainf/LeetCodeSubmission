class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length, mx = prices[n-1], profit = 0;

        for(int i = n - 2; i >= 0; i--) {
            profit = Math.max(profit, mx - prices[i]);
            mx = Math.max(mx, prices[i]);
        }

        return profit;
    }
}