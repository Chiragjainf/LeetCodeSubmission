class Solution {

    public String longestPalindrome(String s) {
        int n = s.length(), maxLen = 0;
        String res = "";

        for(int i = 0; i < n; i++) {
            int l = i, r = i;

            //odd length
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if(maxLen < (r - l + 1)) {
                    maxLen = r - l + 1;
                    res = s.substring(l, r + 1);
                }
                l--;
                r++;
            }

            l = i;
            r = i + 1;
            System.out.println(maxLen);

            //even length
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if(maxLen < (r - l + 1)) {
                    maxLen = r - l + 1;
                    res = s.substring(l, r + 1);
                    System.out.println(res);
                }
                l--;
                r++;
            }
        }

        return res;
    }
}