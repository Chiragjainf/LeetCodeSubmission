class Solution {

    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) ->  {
            if(a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            } else {
                return Integer.compare(a[0], b[0]);
            }
        });
        //System.out.println(intervals);

        int l = 0, cnt = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[l][1] > intervals[i][0]) {
                intervals[l][1] = Math.min(intervals[l][1], intervals[i][1]);
                cnt++;
            } else {
                l = i;
            }
        }
        return cnt;
    }
}