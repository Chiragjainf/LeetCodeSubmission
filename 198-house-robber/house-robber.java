class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        Integer dp[] = new Integer[n + 1];
        return helper(nums, 0 , n, dp);
    }

    public int helper(int[] nums, int i, int n, Integer dp[]) {
        
        if(i >= n) {
            return 0;
        }

        if(dp[i] != null) {
            return dp[i];
        }

        int take = nums[i] + helper(nums, i + 2, n, dp);

        int nontake = helper(nums, i + 1, n, dp);


        return dp[i] = Math.max(take, nontake);
    }
}