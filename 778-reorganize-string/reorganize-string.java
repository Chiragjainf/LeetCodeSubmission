class Solution {

    public String reorganizeString(String s) {
        Map<Character, Integer> hm = new HashMap<>();

        for(char ch: s.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch,0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((p1,p2) -> p2.cnt - p1.cnt);

        for(char key : hm.keySet()) {
            //System.out.println(key);
            pq.add(new Pair(hm.get(key), key));
        }

        StringBuilder ans = new StringBuilder("");


        while(pq.size() >= 2) {
            Pair first = pq.remove();
            Pair second = pq.remove();

            //System.out.println(first.c);

            ans.append(first.c);
            ans.append(second.c);

            first.cnt -= 1;
            second.cnt -= 1;
            if(first.cnt > 0) {
                pq.add(first);
            }
            if(second.cnt > 0) {
                pq.add(second);
            }
        }

        if(!pq.isEmpty() && pq.peek().cnt > 1) {
            return "";
        }


        if(!pq.isEmpty())
            ans.append(pq.peek().c);

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