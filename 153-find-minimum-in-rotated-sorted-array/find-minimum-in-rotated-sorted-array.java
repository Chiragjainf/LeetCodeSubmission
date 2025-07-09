class Solution {


    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, res = nums[0];

        while(l <= r) {
            int mid = l + (r - l) / 2;
            res = Math.min(res, nums[mid]);
            if(nums[mid] < nums[r]) {
                r = mid;
            } else {
                l  = mid + 1;
            }
        }

        return res;
    }
}