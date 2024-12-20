class Solution {
    public int rob(int[] nums) {
        //Integer dp[] = new Integer[nums.length];
        //return robHelper(nums, 0, dp);

        int incl = 0, excl = 0, res = 0;

        for(int i = 0; i < nums.length; i++) {
            int temp = Math.max(incl + nums[i], excl);
            incl = excl;
            excl = temp;
        }
        return Math.max(incl, excl);
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