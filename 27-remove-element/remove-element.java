class Solution {
    public int removeElement(int[] nums, int val) {
        
        int r = nums.length - 1, i = 0;

        while( i <= r) {
            if(nums[i] == val) {
                int t = nums[r];
                nums[r] = nums[i];
                nums[i] = t;
                //swap(nums[i], r);
                r--;
            } else {
                i++;
            }
        }

        return i ;
    }
}