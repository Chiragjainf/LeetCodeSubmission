class Solution {
    public int tribonacci(int n) {
        int first = 0, second = 1, third = 1;

        if(n == 0) {
            return first;
        }

        if(n <= 2) {
            return second;
        }

        int res = 0;
        for(int i = 3; i <= n; i++) {
            res = first + second + third;

            first = second;
            second = third;
            third = res;
        }

        return res;
    }
}