class Solution {
    public int maxProduct(int[] nums) {

        int maxProduct = nums[0], minProduct = nums[0];

        int n = nums.length, res = nums[0];

        for(int i = 1; i < n; i++) {

            if(nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(nums[i], maxProduct * nums[i]);
            minProduct = Math.min(nums[i], minProduct * nums[i]);

            res = Math.max(res, maxProduct);
            
        }

        return res;
        
    }
}