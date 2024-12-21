class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        return mergeHelper(intervals);
    }

    public int[][] mergeHelper(int[][] intervals) {

        int m = intervals.length;
        int[][] res = new int[m][2];
        res[0][0] = intervals[0][0];
        res[0][1] = intervals[0][1];

        int l = 0;

        for(int i = 1; i < m; i++) {
            int prev = res[l][1];
            int curr = intervals[i][0];

            if(prev < curr) {
                l++;
                res[l][0] = intervals[i][0];
                res[l][1] = intervals[i][1];
            } else {
                res[l][1] = Math.max(res[l][1], intervals[i][1]);
            }
        }


        return Arrays.copyOf(res,l + 1);
    }
}