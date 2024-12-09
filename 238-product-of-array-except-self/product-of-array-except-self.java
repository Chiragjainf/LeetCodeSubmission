class Solution {
    public int[] productExceptSelf(int[] nums) {

        int cntZero = 0, mul = 1;
        for(int n : nums) {
            if(n == 0) {
                cntZero++;
            } else {
                mul *= n;
            }
        }

        int res [] = new int[nums.length];
        if(cntZero > 1) {
            return res;
        } else if(cntZero == 1) {
            for(int i  = 0; i < nums.length; i++) {
                if(nums[i] == 0) {
                    res[i] = mul;
                } else {
                    res[i] = 0;
                }
            }
        } else {
            for(int i  = 0; i < nums.length; i++) {
                res[i] = mul / nums[i];
            }
        }
        return res;
        
    }
}