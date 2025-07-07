class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> freq.get(b) - freq.get(a));

        for(int key : freq.keySet()) {
            pq.add(key);
        }

        int res[] = new int[k];

        for(int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }
}