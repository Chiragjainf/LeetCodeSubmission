class Solution {


    public int searchInsert(int[] nums, int target) {
        int l = 0 ,  r = nums.length - 1;

        if(target > nums[r]) {
            return r + 1;
        }

        if(target <= nums[0]) {
            return 0;
        }

        while(l <= r) {
            int mid = l + (r - l) / 2;

            if(nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return r + 1;
    }
}