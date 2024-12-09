class Solution {
    public boolean isPalindrome(String s) {
        //String t = s.toLowerCase();
        String k = s.toLowerCase().trim();
        String t = "";
        for(char c : k.toCharArray()) {
            if(Character.isLetterOrDigit(c)) {
                t += c;
            }
        }
        int l = 0, r = t.length() - 1;
        //System.out.println(t);
        while(l < r) {
            if(t.charAt(l) != t.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;

    }
}