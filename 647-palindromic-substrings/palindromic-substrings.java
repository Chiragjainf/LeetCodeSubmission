class Solution {
    int res = 0;
    public int countSubstrings(String s) {

        int n = s.length();
        if(n == 1) {
            return 1;
        }

        int cnt = 1;

        for(int i = 1; i < n; i++) {
            //odd length
            int l = i - 1, r = i + 1;
            cnt++;
            while(l >= 0 && r < n) {
                if(s.charAt(l) == s.charAt(r)) {
                    l--;
                    r++;
                    cnt++;
                } else {
                    break;
                }
            }
            //e lvenength
            if(s.charAt(i) == s.charAt(i - 1)) {
                l = i - 2;
                r = i + 1;
                cnt++;
                while(l >= 0 && r < n) {
                    if(s.charAt(l) == s.charAt(r)) {
                        l--;
                        r++;
                        cnt++;
                    } else {
                        break;
                    }
                }
            }
        }
        return cnt;
    }


    public void countSubstringsHelper(String s) {

        
        for(int i = 1; i <= s.length(); i++) {

            String str = s.substring(0, i);
            System.out.println(str);
            countSubstringsHelper(s.substring(i));

        }
        
    }



}