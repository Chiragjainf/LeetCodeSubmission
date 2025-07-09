class Solution {
    public int characterReplacement(String s, int k) {
        
        int l = 0,  res = 0, n = s.length(), maxFreq = 0;
        Map<Character, Integer> hm = new HashMap<>();

        for(int r = 0; r < n; r++) {
            char c = s.charAt(r);
            hm.put(c, hm.getOrDefault(c, 0) + 1);

            maxFreq =  Math.max(maxFreq, hm.get(c));

            if((r - l + 1 - maxFreq) > k ) {
                char t = s.charAt(l);
                hm.put(t, hm.getOrDefault(t, 0) - 1);
                maxFreq =  Math.max(hm.get(t), hm.get(c));
                l++;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    
    }
}