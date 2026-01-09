class Solution {
    public int majorityElement(int[] nums) {
        int me = Integer.MIN_VALUE, cnt = 0;

        for(int i = 0; i < nums.length; i++) {
            if(me == nums[i]) {
                cnt++;
            }else if(cnt == 0) {
                me = nums[i];
                cnt = 1;
            } else {
                cnt--;
            }
        }
        return me;
    }
}