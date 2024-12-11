class Solution {

    public int lengthOfLongestSubstring(String s) {

        int l = 0, r = 0, ans = 0;
        Map<Character,Integer> hm = new HashMap<>();
        while(r < s.length()) {
            if(!hm.containsKey(s.charAt(r)) || hm.get(s.charAt(r)) < 1) {
                hm.put(s.charAt(r), 1);
            } else {
                ans = Math.max(ans, r - l);
                while(l < r && hm.get(s.charAt(r)) > 0) {
                    hm.put(s.charAt(l), 0);
                    l++;
                }
                hm.put(s.charAt(r), 1);
            }
            r++;
        }
        ans = Math.max(ans, r - l);
        return ans;
        
    }
}