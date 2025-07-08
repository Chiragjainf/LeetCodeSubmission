class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> hs = new HashSet<>();

        for(int n : nums) {
            hs.add(n);
        }

        int n = nums.length, res = 1;
        if(n == 0) {
            return 0;
        }

        for(int i : hs) {
            if(!hs.contains(i - 1)) {
                int cnt = 0;
                int j = i;
                while(hs.contains(j)) {
                    cnt++;
                    j++;
                }
                res = Math.max(res, cnt);
            }
        }
        return res;
    }
}