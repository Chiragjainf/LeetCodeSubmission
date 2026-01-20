class StockSpanner {

    Stack<Pair> spanner;

    public StockSpanner() {
        spanner = new Stack<>();
    }
    
    public int next(int price) {
        int cnt = 0;
        
        while(!spanner.isEmpty() && price >= spanner.peek().price) {
            Pair p = spanner.pop();
            cnt = cnt + 1 + p.grt; 
        }
        spanner.push(new Pair(price, cnt));

        return cnt + 1;
    }
}

class Pair {
    int price;
    int grt;

    Pair(int price, int grt) {
        this.price = price;
        this.grt = grt;
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */