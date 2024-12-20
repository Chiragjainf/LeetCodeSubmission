class Solution {
    public int rob(int[] nums) {
        Integer dp[] = new Integer[nums.length];
        return robHelper(nums, 0, dp);
    }


    public int robHelper(int[] nums, int i, Integer dp[]) {


        if( i >= nums.length) {
            return 0;
        }

        if(dp[i] != null) {
            return dp[i];
        }


        int incl = nums[i] + robHelper(nums, i + 2, dp);
        int excl = robHelper(nums, i + 1, dp);

        return dp[i] = Math.max(incl, excl);
        
    }
}