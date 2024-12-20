class Solution {
    public int rob(int[] nums) {
        Integer dp[] = new Integer[nums.length];
        Integer dp2[] = new Integer[nums.length];
        if(nums.length == 1) {
            return nums[0];
        }
        int x = robHelper(nums, 0, nums.length - 1, dp);
        int y = robHelper(nums, 1, nums.length, dp2);
        return Math.max(x, y);
    }


    public int robHelper(int[] nums, int i, int n ,Integer dp[]) {

        if( i >= n) {
            return 0;
        }

        if(dp[i] != null) {
            return dp[i];
        }


        int incl = nums[i] + robHelper(nums, i + 2, n,  dp);
        int excl = robHelper(nums, i + 1, n,  dp);

        return dp[i] = Math.max(incl, excl);
        
    }
}