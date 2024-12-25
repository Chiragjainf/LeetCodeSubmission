class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxProduct(int[] nums) {

        int mn = nums[0], mx = nums[0], ans = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < 0) {
                int temp = mn;
                mn = mx;
                mx = temp;
            }
            mx = Math.max(nums[i], mx * nums[i]);
            mn = Math.min(nums[i], mn * nums[i]);
            ans = Math.max(ans, mx);
        }

        return ans;
    }


    public void helper(int[] nums, int i, int curr) {
        
        if( i >= nums.length) {
            return;
        }


        ans = Math.max(ans, curr);

        helper(nums, i + 1, curr * nums[i]);
        helper(nums, i + 1, curr);
    }



}