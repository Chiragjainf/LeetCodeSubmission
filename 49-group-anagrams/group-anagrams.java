class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hm = new HashMap<>();
        for(String str : strs) {
            char temp[] = str.toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            hm.putIfAbsent(key, new ArrayList<>());
            hm.get(key).add(str);
        }
        //for()
        List<List<String>> res = new ArrayList<>();
        for(List<String> list: hm.values()) {
            res.add(list);
        }
        return res;

    }
}