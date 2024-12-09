class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if(sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    l++;
                } else if(sum < 0) {
                    l++;
                } else {
                    r--;
                }
                while(i < nums.length - 1 && nums[i] == nums[i+1]) {
                    i++;
                }
            }
        }
        //System.out.println(res);
        return res;

    }
}