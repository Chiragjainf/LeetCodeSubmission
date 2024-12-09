class Solution {
    public int longestConsecutive(int[] nums) {

        Set<Integer> hs = new HashSet<>();

        if(nums.length == 0) {
            return 0;
        }
        for(int n : nums) {
            hs.add(n);
        }

        int ans = 1;
        
        for(int n : nums) {
            if(hs.contains(n -1)) {
                continue;
            } else {
                int curr = 0;
                while(hs.contains(n)) {
                    curr++;
                    n++;
                }
                ans = Math.max(ans, curr);
            }
        }
        return ans;
        
    }
}