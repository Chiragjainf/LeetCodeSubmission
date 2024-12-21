class Solution {


    public int lengthOfLIS(int[] nums) {
        Integer dp[][] = new Integer[nums.length + 1][nums.length];
        return helper(nums, -1, 0, nums.length, dp);
    }

    public int helper(int[] nums, int prev , int index, int n, Integer dp[][]) {

        if(index >= n) {
            return 0;
        }

        if(dp[prev + 1][index] != null) {
            return dp[prev + 1][index];
        }


        int pick = ((prev == -1 || nums[index] > nums[prev]) ? 1 + helper(nums, index, index + 1, n, dp) : 0);

        int nonpick = helper(nums, prev, index + 1, n, dp);

        return dp[prev + 1][index] = Math.max(pick , nonpick);
    

    }



}