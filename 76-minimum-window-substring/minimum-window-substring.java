class Solution {


    public String minWindow(String s, String t) {
        Map<Character, Integer> tmap= new HashMap<>();
        Map<Character, Integer> smap= new HashMap<>();


        for(char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        int start = 0, cnt = 0;
        int maxLen = Integer.MAX_VALUE;
        String res = "";

        for(int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);

            smap.put(c, smap.getOrDefault(c, 0) + 1);

            if(tmap.containsKey(c) && smap.get(c) <= tmap.get(c)) {
                cnt++;
            }

            if(cnt == t.length()) {
                c = s.charAt(start);
                while(start < i && (!tmap.containsKey(c) || smap.get(c) > tmap.get(c))) {
                     smap.put(c, smap.get(c) - 1);
                     //System.out.println(smap.get('B'));
                     start++;
                     c = s.charAt(start);
                }
                if(maxLen >= (i - start + 1)) {
                    maxLen =  i - start + 1;
                    res = s.substring(start, i + 1);
                }
                char t1 = s.charAt(start);
                smap.put(t1, smap.get(t1) - 1);   
                start++;
                cnt--;
            }
        }

        return res;
    }

    public boolean isEqual(Map<Character, Integer> tmap, Map<Character, Integer> smap) {

        for(char c : tmap.keySet()) {
            if(!smap.containsKey(c) || tmap.get(c) > smap.get(c)) {
                return false;
            }
        }

        return true;

    }
}