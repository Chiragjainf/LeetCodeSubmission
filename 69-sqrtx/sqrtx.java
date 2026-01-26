class Solution {
    public int mySqrt(int x) {

        if(x <= 1) {
            return x;
        }

        int l = 1, r = x >> 1;

        while(l <= r) {
            int mid = l + (r - l) / 2;

            long target = (long) mid * mid;

            if(target == x) {
                return mid;
            } else if(target > x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return r;

        
    }
}