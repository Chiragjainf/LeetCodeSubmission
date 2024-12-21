class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int m = intervals.length;
        int[][] addInterval = new int[m + 1][2];
        int l = 0;

        boolean flag = true;
        if( m == 0) {
            addInterval[l][0] = newInterval[0];
            addInterval[l][1] = newInterval[1];
            return addInterval;
        }

        for(int i = 0; i < m; i++) {
            if(flag == true && intervals[i][0] > newInterval[0]) {
                //System.out.println(l);
                addInterval[l][0] = newInterval[0];
                addInterval[l][1] = newInterval[1];
                l++;
                flag = false;
            }
            //System.out.println(l);
            addInterval[l][0] = intervals[i][0];
            addInterval[l][1] = intervals[i][1];
            l++;
        }

         if(flag == true) {
            addInterval[l][0] = newInterval[0];
            addInterval[l][1] = newInterval[1];
            //return addInterval;
        }

        return merge(addInterval);
    }


    public int[][] merge(int[][] intervals) {

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