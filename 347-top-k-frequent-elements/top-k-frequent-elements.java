class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        for(Map.Entry<Integer,Integer> entry: freq.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
        }
        int res[] = new int[k];
        int j = 0;
        for(int i = 0; i < k; i++) {
            int temp[] = pq.remove();
            res[i] = temp[0];
        }
        return res;
    }
}