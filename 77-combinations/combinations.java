class Solution {


    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res = new ArrayList<>();

        helper(1, n, k, new ArrayList<>(), res);

        return res;
        
    }


    public void helper (int start, int n, int k, List<Integer> temp, List<List<Integer>> res) {

        if(temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        } 

        if(start > n) {
            return;
        }


        temp.add(start);

        helper(start + 1, n, k , temp, res);

        temp.remove(temp.size() - 1);

        helper(start + 1, n, k , temp, res);
        
    }
}