class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if(seen.containsKey(target - n)) {
                return new int[]{seen.get(target - n), i};
            }
            seen.put(n, i);
        }
        return new int[]{-1, -1};
    }
}