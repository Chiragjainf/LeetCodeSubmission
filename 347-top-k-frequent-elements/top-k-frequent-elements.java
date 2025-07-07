class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for(int key : freq.keySet()) {
            pq.add(new int[]{key, freq.get(key)});
        }

        int res[] = new int[k];

        for(int i = 0; i < k; i++) {
            int temp[] = pq.poll();
            res[i] = temp[0];
        }

        return res;
    }
}