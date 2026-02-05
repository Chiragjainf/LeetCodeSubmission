class Solution {
    public String longestDiverseString(int a, int b, int c) {
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2) -> p2.cnt - p1.cnt);

        boolean ignored;

        ignored =  a > 0 ? pq.add(new Pair(a, 'a')) : false;
        ignored = b > 0 ? pq.add(new Pair(b, 'b')): false;
        ignored = c > 0 ? pq.add(new Pair(c, 'c')): false;

        StringBuilder ans = new StringBuilder("");


        while(pq.size() >= 2) {
            Pair first = pq.remove();
            Pair second = pq.remove();

            //System.out.println(first.c);

            int pair1 = first.cnt / 2 + first.cnt % 2;
            int pair2 = second.cnt / 2 + second.cnt % 2;

            int diff = pair1 - pair2;

            if(first.cnt >= 2) {
                ans.append(first.c);
                ans.append(first.c);
                first.cnt -= 2;
            } else {
                ans.append(first.c);
                first.cnt -= 1;
            }

            if(second.cnt >= 2 && diff <= 1) {
                ans.append(second.c);
                ans.append(second.c);
                second.cnt -= 2;
            } else {
                ans.append(second.c);
                second.cnt -= 1;
            }


            if(first.cnt > 0) {
                pq.add(first);
            }
            if(second.cnt > 0) {
                pq.add(second);
            }
        }

        if(!pq.isEmpty() ) {
            Pair first = pq.remove();
            if(first.cnt >= 2) {
                ans.append(first.c);
                ans.append(first.c);
            } else {
                ans.append(first.c);
            }
        }



        return ans.toString();
    }
}

class Pair {
    int cnt;
    char c;
    Pair(int c, char ch) {
        this.cnt = c;
        this.c = ch;
    }
}