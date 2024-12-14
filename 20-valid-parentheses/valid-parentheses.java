class Solution {

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == '(' || s.charAt(i) == '{'  || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            } else {
                char c = s.charAt(i);
                if(st.isEmpty()) {
                    return false;
                }
                char top = st.peek();
                st.pop();
                if(c == ')' && top == '(') {
                    continue;
                } else if(c == '}' && top == '{') {
                    continue;
                } else if(c == ']' && top == '[') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return st.isEmpty() ? true : false;
        
    }
}