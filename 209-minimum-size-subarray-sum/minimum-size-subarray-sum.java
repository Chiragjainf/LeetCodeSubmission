class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, l = 0, r = n -1, res = 100001;

        long sum  = 0;
        for(int i = 0 ; i < n; i++) {
            sum += nums[i];

            while(l <= i && (sum - nums[l] >= target)) {
                sum -= nums[l];
                l++;
            }

            if(sum >= target) {
                res = Math.min(res, (i - l + 1));
            }

        }

        return res == 100001 ? 0 : res;

    }
}