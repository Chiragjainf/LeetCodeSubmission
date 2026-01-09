class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        int cnt1 = 0, cnt2 = 0, me1 = Integer.MIN_VALUE , me2 = Integer.MIN_VALUE, n = nums.length;

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            if(me1 == nums[i]) {
                cnt1++;
            }else if(me2 == nums[i]) {
                cnt2++;
            } else if(cnt1 == 0) {
                me1 = nums[i];
                cnt1 = 1;
            } else if(cnt2 == 0) {
                me2 = nums[i];
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        int cnt3 = 0, cnt4 = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == me1) {
                cnt3++;
            }
            if(nums[i] == me2) {
                cnt4++;
            }
        }

        if(cnt3 > n / 3) {
            res.add(me1);
        }
        if(cnt4 > n / 3) {
            res.add(me2);
        }

        return res;
    }
}