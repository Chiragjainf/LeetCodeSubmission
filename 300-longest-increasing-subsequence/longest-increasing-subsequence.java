class Solution {
    public int lengthOfLIS(int[] nums) {

        if(nums.length == 0) {
            return 0;
        }

        int dp[] = new int[nums.length];

        Arrays.fill(dp, 1);

        int res = 1;

        for(int i = 1; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;

        // Integer dp[][] = new Integer[nums.length][nums.length + 1];
        // return helper(nums, 0, -1, nums.length, dp);
    }


     public int helper(int[] nums, int index, int prev, int n,  Integer dp[][]) {

        if(index >= n) {
            return 0;
        }

        if(dp[index][prev + 1] != null) {
            return dp[index][prev + 1];
        }

        int x = 0;
        if(prev == -1 || nums[prev] < nums[index]) {
            x = 1 + helper(nums, index + 1, index, n, dp);
        }

        int y = helper(nums, index + 1, prev, n, dp);

        return dp[index][prev + 1] = Math.max(x, y);
        
    }
}