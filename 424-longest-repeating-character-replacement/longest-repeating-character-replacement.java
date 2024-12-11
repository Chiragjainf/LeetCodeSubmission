class Solution {

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> hm = new HashMap<>();
        int res = 0, n = s.length();
        int l = 0, r = 0, currMax = 0;
        while(r < n) {
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0) + 1);
            if(currMax <= hm.get(s.charAt(r))) {
                currMax = hm.get(s.charAt(r));
            }
            while((r - l + 1) - currMax > k){
                hm.put(s.charAt(l), hm.get(s.charAt(l)) - 1);
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        //res = Math.max(res, r - l + 1);
        return res;
    }
}