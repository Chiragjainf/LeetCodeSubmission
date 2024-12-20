class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean dp[] = new Boolean[s.length() + 1];
        return helper(s, wordDict, dp);
    }


    public boolean helper(String s, List<String> wordDict, Boolean dp[]) {

        if(s.length() == 0) {
            return true;
        }

        if(dp[s.length()] != null) {
            return dp[s.length()];
        }

        for(int i = 1; i <= s.length(); i++) {
            String word = s.substring(0, i);
            if(wordDict.contains(word)) {
                if(helper(s.substring(i), wordDict, dp)) {
                    return dp[s.length()] = true;
                }
            }
        }
        
        return dp[s.length()] = false;
    }



}