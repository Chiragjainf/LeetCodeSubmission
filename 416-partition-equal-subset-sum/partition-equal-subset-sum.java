class Solution {


    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int x : nums) {
            sum += x;
        }

        if(sum % 2 != 0) {
            return false;
        }

        Boolean dp[][] = new Boolean[nums.length + 1][sum / 2 + 1];


        return helper(nums, 0, 0, sum / 2, dp);
        
    }


    public boolean helper(int[] nums, int index, int currSum, int target, Boolean dp[][]) {


        if(currSum == target) {
            return true;
        }

        if(index >= nums.length || currSum > target) {
            return false;
        }

        if(dp[index][currSum] != null) {
            return dp[index][currSum];
        }

        boolean pick = helper(nums, index + 1, currSum + nums[index], target, dp);

        boolean nonPick = helper(nums, index + 1, currSum, target, dp);


        return dp[index][currSum] = pick || nonPick;


        
    }



}