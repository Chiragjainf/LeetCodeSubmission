class Solution {

    public int maxSubArray(int[] nums) {
        int res = nums[0], curr = nums[0];

        for(int i = 1; i < nums.length; i++){
            if(curr < 0) {
                curr = 0;
            }
            curr = curr + nums[i];
            res = Math.max(res, curr);
        }
        return res;
    }
}