class Solution {

    public int coinChange(int[] coins, int amount) {
        Integer dp[][] = new Integer[coins.length] [amount + 1];
        int res = helper(coins, amount, 0, coins.length, 0, dp);
        return res == 10001 ? -1 : res; 
    }


    public int helper(int[] coins, int amount, int i, int n, int sum, Integer dp[][]) {

        if( i >= n || sum > amount) {
            return 10001;
        }

        if(sum == amount) {
            return 0;
        }

        //System.out.println(sum);

        if(dp[i][sum] != null) {
            return dp[i][sum];
        }


        int x = 10001;
        if (coins[i] <= amount ) {
            x = 1 + helper(coins, amount, i, n, sum + coins[i], dp);
        }
        int y = helper(coins, amount, i + 1, n, sum, dp);

        return dp[i][sum] = Math.min(x, y);
        
    }


}