class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character,Integer> hs = new HashMap<>();
        for(char n : s.toCharArray()) {
            hs.put(n, hs.getOrDefault(n, 0) + 1);
        }

        for(char n : t.toCharArray()) {
            if(!hs.containsKey(n) || hs.get(n) == 0) {
                return false;
            }
            hs.put(n, hs.get(n) - 1);
        }
        return true;
        

        
    }
}