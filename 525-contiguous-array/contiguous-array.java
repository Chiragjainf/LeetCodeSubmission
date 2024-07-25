class Solution {

    public int findMaxLength(int[] nums) {

        int cnt = 0, mx = 0;
        Map<Integer,Integer> freq = new HashMap<>();
        freq.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                cnt--;
            }
            if(nums[i] == 1) {
                cnt++;
            }

            if(freq.containsKey(cnt)) {
                mx = Math.max(mx, i - freq.get(cnt));
            } else {
                freq.put(cnt, i);
            }
        }

        return mx;
    }

}