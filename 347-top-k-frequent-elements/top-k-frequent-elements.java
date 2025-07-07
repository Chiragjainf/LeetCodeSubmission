class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        int n = nums.length;

        List<Integer> bucket[] = new List[n + 1];

        for(int i = 0; i <= n; i++) {
            bucket[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry: freq.entrySet()) {
            bucket[entry.getValue()].add(entry.getKey());
        }

        int res[] = new int[k];
        int j = 0;
        
        for(int i = n; i >= 0; i--) {
            for(int num : bucket[i]) {
                res[j++] = num;
                if(j == k) {
                    return res;
                }
            }
        }

        return res;

    } 
}