class Solution {
    public boolean isPalindrome(String s) {
        String t = s.toLowerCase();

        StringBuilder sb = new StringBuilder();
        for(char c : t.toCharArray()) {
            if(c >= 'a' && c <= 'z' || c >= '0' && c <= '9'){
                sb.append(c);
            }
        }

        s = sb.toString();

        int l = 0 , r = s.length() - 1;

        //System.out.println(s);
        while(l <= r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;

    }
}