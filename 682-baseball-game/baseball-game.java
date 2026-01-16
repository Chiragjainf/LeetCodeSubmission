class Solution {


    public int calPoints(String[] opr) {
        Stack<Integer> scores = new Stack<>();

        for(int i = 0; i < opr.length; i++) {
            if(opr[i].charAt(0) == '+') {
                int first = !scores.isEmpty() ? scores.pop() : 0;
                int second = !scores.isEmpty() ? scores.peek() : 0;
                scores.add(first);
                scores.add(first + second);
            } else if(opr[i].charAt(0) == 'D') {
                int first = !scores.isEmpty() ? scores.peek() : 0;
                scores.add(2 * first);
            } else if(opr[i].charAt(0) == 'C') {
                int first = !scores.isEmpty() ? scores.pop() : 0;
                //scores.add(2 * first + '0');
            } else {
                scores.add(Integer.valueOf(opr[i]));
            }
        }

        return scores.stream()
             .mapToInt(Integer::intValue)
             .sum();

    }
}