class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> hm = new HashMap<>();

        int n = s.length();

        if(n != t.length()) {
            return false;
        }

        for(int i = 0; i < n; i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
            hm.put(t.charAt(i), hm.getOrDefault(t.charAt(i), 0) - 1);
        }

        for(char c : hm.keySet()) {
            if(hm.get(c) != 0) {
                return false;
            }
        }
        return true;

    }
}