class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer dp[][] = new Integer[text1.length() + 1][text2.length() + 1];
        return helper(text1, text2, text1.length(), text2.length(), dp);
    }

    public int helper(String text1, String text2, int m, int n,  Integer dp[][]) {

        if(m == 0 || n == 0) {
            return 0;
        }

        if(dp[m][n] != null) {
            return dp[m][n];
        }

        int x = 0, y = 0, z = 0;

        if(text1.charAt(m - 1) == text2.charAt(n - 1)) {
            x = 1 + helper(text1, text2, m - 1, n - 1, dp);
        } else if(text1.charAt(m - 1) != text2.charAt(n - 1)) {
            y = helper(text1, text2, m - 1, n, dp);
            z = helper(text1, text2, m, n - 1, dp);
        }

        return dp[m][n] = Math.max(x, Math.max(y, z));
    }
}