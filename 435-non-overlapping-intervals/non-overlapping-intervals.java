class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if(a[1] == b[1]){
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });


        int res = 0;
        int l = 0;
        for(int i = 1; i < intervals.length; i++) {

            int prev = intervals[l][1];
            int curr = intervals[i][0];

            if(prev <= curr) {
                l = i;
                continue;
            } else {
                res++;
            }
        }

        return res;
    }
}