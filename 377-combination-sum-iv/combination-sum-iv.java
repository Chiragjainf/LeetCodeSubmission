class Solution {

    //int res = 0;
    public int combinationSum4(int[] nums, int target) {
       
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();

        dp.put(0, 1);
        return helper(nums, target, dp);

        //return res;
    }


    public int helper(int[] nums, int target, Map<Integer, Integer> dp) {
        
        if(dp.containsKey(target)) {
            return dp.get(target);
        }

        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= target) {
                res += helper(nums, target - nums[i], dp);
            }
        }

        dp.put(target, res);

        return res;
    }
}