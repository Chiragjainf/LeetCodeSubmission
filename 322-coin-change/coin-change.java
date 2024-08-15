class Solution {


    public int coinChange(int[] coins, int amount) {

        
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;





        for(int i = 1;  i <= amount; i++) {
            for(int j = 0; j < coins.length; j++) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], (dp[i - coins[j]] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : dp[i - coins[j]] + 1);
                }
            }
        }



        //Arrays.fill(dp,)

        //coinChangeHelper(coins, amount, 0, dp);

        if(dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        return dp[amount];
    }


    public int coinChangeHelper(int[] coins, int amount, int i, int dp[]) {


        if(amount == 0) {
            return 0;
        }


        if( i == coins.length || amount < 0) {
            return 1000000;
        }
        
        if(dp[amount] != 0) {
            return dp[amount];
        }

        dp[amount] = Math.min(1 + coinChangeHelper(coins, amount - coins[i], i, dp), 
        coinChangeHelper(coins, amount, i+1, dp));

        return dp[amount];
        
    }
}