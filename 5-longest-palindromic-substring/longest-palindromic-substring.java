class Solution {
    public String longestPalindrome(String s) {

        int n = s.length();
        if(n == 1) {
            return s;
        }

        int maxLen = 0;
        String ans = "";

        for(int i = 1; i < n; i++) {
            //odd length
            int l = i - 1, r = i + 1;
            while(l >= 0 && r < n) {
                if(s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                } else {
                    break;
                }
            }
            if(maxLen < (r - l - 1)) {
                maxLen = (r -l - 1);
                ans = s.substring(l + 1, r);
            }

            //e lvenength
            if(s.charAt(i) == s.charAt(i - 1)) {
                l = i - 2;
                r = i + 1;
                while(l >= 0 && r < n) {
                    if(s.charAt(l) == s.charAt(r)) {
                        l--;
                        r++;
                    } else {
                        break;
                    }
                }

                if(maxLen < (r - l - 1)) {
                    maxLen = (r -l - 1);
                    ans = s.substring(l + 1, r);
                }
            }
        }

        return ans;
        
    }
}