class Solution {

    public String longestCommonPrefix(String[] strs) {
        
        int n = strs.length;

        if( n < 1) {
            return "";
        }

        if( n == 1) {
            return strs[0];
        }

        int minLength = 201;

        for(int i = 0; i < n; i++) {
            if(minLength >= strs[i].length()) {
                minLength = strs[i].length();
            }
        }

        String ans = "";

        for(int i = 0; i < minLength; i++) {
            for(int j = 1; j < n; j++) {
                if(strs[j].charAt(i) != strs[j - 1].charAt(i)) {
                    return ans;
                }
            }
            ans += strs[0].charAt(i);
        }

        return ans;
    }
}