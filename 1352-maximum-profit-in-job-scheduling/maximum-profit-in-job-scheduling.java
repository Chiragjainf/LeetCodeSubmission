class Solution {

    int res = 0;


    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        Pair jobs[] = new Pair[n];

        for(int i = 0; i < n; i++) {
            jobs[i] = new Pair(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, (a,b) -> a.start == b.start ? a.end - b.end : a.start - b.start);
        
        Integer dp[] = new Integer[n];


        
        return helper(jobs, 0, n, dp);

        //return res;
    }


    public int helper(Pair jobs[], int index, int n, Integer dp[]) {
        

        if(index >= n) {
            //res = Math.max(res, currProfit);
            return 0;
        }

        if(dp[index] != null) {
            return dp[index];
        }

        int x = 0, y = 0;

        y += helper(jobs, index + 1, n, dp);

        int j = index + 1;
        while(j < n) {
            if(jobs[index].end <= jobs[j].start) {
                break;
            }
            j++;
        } 
    
        x += jobs[index].profit + helper(jobs, j, n, dp);

        return dp[index] = Math.max(x, y);

    }
}

class Pair {
    int start;
    int end;
    int profit;
    Pair(int x, int y, int z) {
        start = x; 
        end = y;
        profit = z;
    }
}
