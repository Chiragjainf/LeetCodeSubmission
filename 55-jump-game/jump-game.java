class Solution {
    public boolean canJump(int[] nums) {
        int step = nums[0], maxStep = nums[0], res = 1, n = nums.length;

        if(n == 1) {
            return true;
        }

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