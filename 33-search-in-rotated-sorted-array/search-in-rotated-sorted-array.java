class Solution {
    public int search(int[] nums, int target) {
        int pivot = findMin(nums);

        if(nums[0] <= nums[nums.length - 1]) {
           return binarySearch(nums, 0 , nums.length - 1, target);
        } else if(target >= nums[0]) {
            return binarySearch(nums, 0 , pivot - 1, target);
        } else {
            return binarySearch(nums, pivot , nums.length - 1, target);
        }
    }

    public int binarySearch(int nums[], int l , int r , int target) {

        while(l <= r) {
            int mid = l + (r - l) / 2;
            //res = Math.min(res, nums[mid]);
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    public int findMin(int[] nums) {
        
        int l = 0, r = nums.length - 1, res = nums[0];

        while(l < r) {
            int mid = l + (r - l) / 2;
            //res = Math.min(res, nums[mid]);
            if(nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}