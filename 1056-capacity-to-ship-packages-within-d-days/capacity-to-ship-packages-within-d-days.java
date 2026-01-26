class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l = Arrays.stream(weights).max().getAsInt(), res = -1;

        int r = Arrays.stream(weights).sum();

        while(l <= r) {
            int mid = l + (r - l) / 2;

            int requireDay = calculate(weights, mid);
            //System.out.println( mid + " " + requireDay);

            if(requireDay <= days && requireDay != -1) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }

        return res;
    }


     public int calculate(int[] weights, int capacity) {

        int cnt = 0, currSum = 0;

        for(int i = 0; i < weights.length; i++) {

            if(weights[i] > capacity) {
                return -1;
            }
            currSum += weights[i];
            if(currSum > capacity) {
                cnt++;
                currSum = weights[i];
            }
        }
        return cnt  + 1;
     }
}