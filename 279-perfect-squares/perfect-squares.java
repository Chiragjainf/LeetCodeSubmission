class Solution {

    int ans = 10000;
    public int numSquares(int n) {
        
        Integer dp[] = new Integer[n + 1];
        return helper(n, dp);
        //return ans;
    }


    public int helper(int n, Integer dp[]) {

        if(n == 0) {
            return 0;
        }

        if(n < 0) {
            return 10000;
        }

        if(dp[n] != null) {
            return dp[n];
        }

        int res = 10000;

        for(int i = 1; i * i <= n; i++) {
            if( i * i <= n) {
                res = Math.min(res, 1 + helper(n - i * i, dp));
            }
        }

        //ans = Math.min(ans, res);

        return dp[n] = res;
        
    }
}