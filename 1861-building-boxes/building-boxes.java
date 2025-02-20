class Solution {
    public int minimumBoxes(int n) {
        int base = 0;
        int add = 0;
        while(base <= n){
            n -= base;
            base += ++add;
        }
        base -= add;
        double rem = Math.ceil(Math.sqrt(2 * n + 0.25) - 0.5d);
        return base + (int) rem;
    }
}