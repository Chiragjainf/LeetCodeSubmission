class Solution {


    public int rob(int[] nums) {
        

        int incl = 0, excl = 0;

        for(int i = 0; i < nums.length; i++) {
            int temp = Math.max(incl, excl);

            excl = incl + nums[i];

            incl = temp;
        }

        return Math.max(incl , excl);
    }
}