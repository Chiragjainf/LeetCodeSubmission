class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int profit = 0, rmx = prices[n - 1];
        for(int i = n - 2; i >= 0; i--) {
            if(prices[i] >= rmx) {
                rmx = prices[i];
            } else {
                profit += (rmx - prices[i]);
                rmx = prices[i];
            }
        }

        return profit;
    }
}