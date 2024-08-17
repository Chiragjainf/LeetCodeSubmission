class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Integer dp[][] = new Integer[text1.length() + 1][text2.length() + 1];

        return helper(text1, text2, 0, 0, dp);
    }


    public int helper(String text1, String text2, int i, int j, Integer dp[][]) {

        if(i >= text1.length() || j >= text2.length()) {
            return 0;
        }


        if(dp[i][j] != null) {
            return dp[i][j];
        }
        int x = 0, y = 0;
        if(text1.charAt(i) == text2.charAt(j)) {
            x = 1 + helper(text1, text2, i+1, j+1, dp);
        } else {
            x = helper(text1, text2, i+1, j, dp);
            y = helper(text1, text2, i, j+1, dp);
        }

        return dp[i][j] = Math.max(x, y);

    }


}