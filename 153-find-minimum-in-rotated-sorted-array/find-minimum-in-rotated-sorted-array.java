class Solution {


    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, res = nums[0];

        while(l <= r) {
            int mid = l + (r - l) / 2;
            res = Math.min(res, nums[mid]);
            if(nums[mid] >= nums[0]) {
                l++;
            } else {
                r--;
            }
        }

        return res;
    }
}