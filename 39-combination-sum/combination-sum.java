class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        combinationSumHelper(candidates, target, 0, 0, new ArrayList<>());
        return res;
    }


    public void combinationSumHelper(int[] candidates, int target, int i, int currSum, List<Integer> currList) {

        if(i >= candidates.length || currSum > target) {
            return;
        }

        if(currSum == target) {
            res.add(new ArrayList<>(currList));
            return;
        }

        combinationSumHelper(candidates, target, i + 1, currSum, currList);
        currList.add(candidates[i]);
        combinationSumHelper(candidates, target, i , currSum + candidates[i], currList);
        currList.remove(currList.size() - 1);
        
    }
}