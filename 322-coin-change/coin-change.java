class Solution {

    public int coinChange(int[] coins, int amount) {
        Integer dp[][] = new Integer[coins.length][2 * amount + 1];
        int res = helper(coins, amount, 0, 0, dp);
        return res > 10000 ? -1 : res;
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