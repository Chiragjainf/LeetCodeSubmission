class Solution {
    public int jump(int[] nums) {
        int step = nums[0], maxStep = nums[0], res = 1, n = nums.length;

        if(n <= 1) {
            return 0;
        }

        for(int i = 1; i < nums.length; i++) {
            step--;

            maxStep = Math.max(maxStep, i + nums[i]);
            
            if(step == 0) {
                if(i == n - 1) {
                    return res;
                }
                res++;
                step = maxStep - i;
            }
        }

        return res;
    }
}