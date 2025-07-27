class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        Integer[][] dp = new Integer[obstacleGrid.length][obstacleGrid[0].length];
        return helper(obstacleGrid, 0, 0, obstacleGrid.length ,obstacleGrid[0].length, dp);
    }

    public int helper(int[][] obstacleGrid, int r, int c, int m, int n, Integer[][] dp) {
        

        if( r >= m || c >= n) {
            return 0;
        }

        if(obstacleGrid[r][c] == 1) {
            return 0;
        }

        if(r == m - 1 && c == n - 1) {
            return 1;
        }

        if(dp[r][c] != null) {
            return dp[r][c];
        }


        return dp[r][c] = helper(obstacleGrid, r + 1, c, m ,n, dp) + helper(obstacleGrid, r, c + 1, m ,n, dp);
    }
}
