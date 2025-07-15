class Solution {
    public int rob(int[] nums) {
        
        int n = nums.length;

        if(n == 1) {
            return nums[0];
        }

        Integer dp1[] = new Integer[n + 1];
        int first = helper(nums, 0 , n - 1, dp1);
        Integer dp2[] = new Integer[n + 1];
        int second = helper(nums, 1 , n, dp2);

        return Math.max(first , second);
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