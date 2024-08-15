class Solution {
    public int climbStairs(int n) {

        Integer dp[] = new Integer[n+1];

        return helper(n, dp);
        
    }

    public int helper(int n, Integer dp[]) {

        if(n == 0) {
            return 1;
        }

        if(n < 0) {
            return 0;
        }

        if(dp[n] != null) {
            return dp[n];
        }


        int x = helper(n-1, dp);
        int y = helper(n-2, dp);

        return dp[n] =  x + y;
        
    }
}