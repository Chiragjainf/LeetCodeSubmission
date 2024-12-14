class Solution {
    public int findMin(int[] nums) {

        int l = 0 ,  r = nums.length - 1, res = Integer.MAX_VALUE;

        if(nums[0] < nums[r]) {
            return nums[0];
        }
        while(l <= r) {
            int mid  = l + (r - l) / 2;
            res = Math.min(res, nums[mid]);

            if(nums[mid] < nums[0]) {
                r--;
            } else {
                l++;
            }
        }
        
        return res;
    }
}