class Solution {

    public int subarraySum(int[] nums, int k) {
        
        int n = nums.length;
        int prefixSum[] = new int[n];

        prefixSum[0] = 0;

        for(int i = 1; i < n; i++) {
           prefixSum[i] = prefixSum[i - 1] + nums[i - 1]; 
        }

        int res = 0;

        for(int i = 0; i < n; i++) {
            
            int currSum = prefixSum[i] + nums[i];
            for(int j = 0; j <= i; j++) {
                //System.out.println(currSum);
                if(currSum == k) {
                    res++;
                }
                currSum = currSum - nums[j];
            }
        }

        return res;


    }
}