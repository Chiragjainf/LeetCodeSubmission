class Solution {
    public boolean canJump(int[] nums) {
        int step = nums[0];
        // if(step == 0 && nums.length > 1) {
        //     return false;
        // }
        for(int i = 1; i < nums.length; i++) {
            if(step <= 0) {
                return false;
            }
            step--;
            step = Math.max(step, nums[i]);
        }

        return true;
    }
}