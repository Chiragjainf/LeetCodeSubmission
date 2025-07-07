class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        for(int n: nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
            if(freq.get(n) > 1) {
                return true;
            }
        }
        return false;
    }
}