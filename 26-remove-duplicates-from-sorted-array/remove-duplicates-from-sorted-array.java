class Solution {

    public int removeDuplicates(int[] nums) {

        int n = nums.length;

        for(int i = 1; i < n; i++) {
            if(nums[i] == nums[i - 1]) {
                nums[i - 1] = 101;
            }
        }

        int l = 0;

        for(int i = 0; i < n; i++) {
            if(nums[i] != 101) {
                nums[l++] = nums[i];
            }
        }

        return l;
    }
}