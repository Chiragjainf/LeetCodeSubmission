class Solution {

    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while( l < r) {
            int m =  l + (r - l) / 2;
            if(nums[m] < nums[r]) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if( l == 0) {
            return bSearch(nums, target, l , nums.length - 1);
        }
        return target >= nums[0] ? bSearch(nums, target, 0 , l - 1): bSearch(nums, target, l , nums.length - 1);
    }

    public int bSearch(int[] nums, int target, int l , int r) {

        while( l <= r) {
            int m =  l + (r - l) / 2;
            if(target == nums[m]) {
                return m;
            } else if(nums[m] < target) {
                l = m + 1;
            } else {
                r  = m - 1;
            }
        }
        return -1;
    }
}