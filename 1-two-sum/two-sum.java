class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(hm.containsKey(target - nums[i])) {
                return new int[]{hm.get(target - nums[i]), i};
            }
            hm.put(nums[i], i);
        }

        
        // Arrays.sort(nums);
        // int l = 0, r = nums.length - 1;
        // while(l < r) {
        //     int sum = nums[l] + nums[r];
        //     if(sum == target) {
        //         return new int[]{l, r};
        //     } else if(sum < target) {
        //         l++;
        //     } else {
        //         r--;
        //     }
        // }
        return new int[]{-1, -1};
    }
}