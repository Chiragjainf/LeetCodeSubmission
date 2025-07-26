class Solution {

    public int coinChange(int[] coins, int amount) {

        int dp[] = new int[amount + 1];
        Arrays.fill(dp, 10001);
        dp[0] = 0;
        //System.out.println(dp[0]);

        for(int i = 1; i <= amount; i++) {
            for(int j = coins.length - 1; j >= 0; j--) {
                if(coins[j] <= i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                    //System.out.println(dp[i]);
                }

            }
        }

        return dp[amount] > 10000 ? -1 : dp[amount];



        // Integer dp[][] = new Integer[coins.length][2 * amount + 1];
        // int res = helper(coins, amount, 0, 0, dp);
        // return res > 10000 ? -1 : res;
    }


     public int helper(int[] coins, int amount, int currAmount, int index, Integer dp[][]) {

        if(currAmount == amount) {
            return 0;
        }

        if(currAmount > amount) {
            return 10001;
        }

        if(index >= coins.length) {
            return 10001;
        }

        if(dp[index][currAmount] != null) {
            return dp[index][currAmount];
        }

        int x = 10001;

        if(coins[index] <= amount) {
            x = 1 + helper(coins, amount, currAmount + coins[index], index, dp);
        }
        int y = helper(coins, amount, currAmount, index + 1, dp);

        return dp[index][currAmount] = Math.min(x, y);
        
    }
}