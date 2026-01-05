class Solution {
    public int majorityElement(int[] nums) {
        int me = nums[0], cnt = 1;

        for(int i = 1; i < nums.length; i++) {
            if(me != nums[i]) {
                cnt--;
                if(cnt == 0) {
                    me = nums[i];
                    cnt = 1;
                }
            } else {
                cnt++;
            }
        }
        return me;
    }
}