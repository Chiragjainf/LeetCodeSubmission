class Solution {
    public int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }

    public int helper (int[] nums, int i, int x) {

        if(i == nums.length) {
            return x;
        }


        int sum = 0;

        sum += helper(nums, i + 1, x ^ nums[i]);

        sum += helper(nums, i + 1, x);

        return sum;
        
    }
}