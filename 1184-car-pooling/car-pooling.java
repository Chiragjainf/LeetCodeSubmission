class Solution {

    public boolean carPooling(int[][] trips, int capacity) {

        PriorityQueue<int[]> available = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);

        PriorityQueue<int[]> used = new PriorityQueue<>((a, b) -> a[2] == b[2] ? a[1] - b[1] : a[2] - b[2]);


        for(int i = 0; i < trips.length; i++) {
            available.add(new int[]{trips[i][0], trips[i][1], trips[i][2]});
        }

        int usedCapacity = 0;



        while(!available.isEmpty()) {
            int t[] = available.remove();

            usedCapacity += t[0];

            while(!used.isEmpty() && t[1] >= used.peek()[2]) {
                int u[] = used.remove();

                usedCapacity -= u[0];
            }

            if(usedCapacity > capacity) {
                return false;
            }

            used.add(t);

        }

        return true;

    }
}