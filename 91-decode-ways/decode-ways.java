class Solution {

    public int numDecodings(String s) {
        Integer dp[] = new Integer[s.length() + 1];
        return helper(s, dp);
    }


    // public int helper(String s, Integer dp[]) {

    //     if(s.length() == 0) {
    //         return 1;
    //     }

    //     if(dp[s.length()] != null) {
    //         return dp[s.length()];
    //     }

        
    //     int one = 0;
    //     int two = 0;
    //     if(s.length() > 0 && isValid(s.substring(0, 1))) {
    //         one = helper(s.substring(1), dp);
    //     }
    //     if(s.length() > 1 && isValid(s.substring(0, 2))) {
    //         two = helper(s.substring(2), dp);
    //     }

    //     return dp[s.length()] = one + two;

    // }




    public int helper(String s, Integer dp[]) {

        if(s.length() == 0) {
            return 1;
        }

        if(dp[s.length()] != null) {
            return dp[s.length()];
        }

        int cnt = 0;
        for(int i = 1; i <=  2 &&  i <= s.length(); i++) {
            String str = s.substring(0, i);
            if(isValid(str)) {
                cnt += helper(s.substring(i), dp);
            }
        }
        return dp[s.length()] = cnt;
    }

    public boolean isValid(String s) {
        if(s.length() >  2) {
            return false;
        }
        int i = Integer.valueOf(s);
        return s.charAt(0) != '0' && i > 0 && i < 27; 
    }
}