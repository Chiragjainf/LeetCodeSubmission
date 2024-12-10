class Solution {

    public int maxProfit(int[] prices) {
        int res = 0, n = prices.length;
        int rmax = prices[n-1];
        for(int i = n-2; i >= 0 ; i--) {
            res = Math.max(res, rmax - prices[i]);
            rmax = Math.max(rmax, prices[i]);
        }
        return res;
    }
}