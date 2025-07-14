class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        List<List<Integer>> ans = new ArrayList<>();

        int m = heights.length, n = heights[0].length;
        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            helper(heights, pac, i, 0, m, n, heights[i][0]);
            helper(heights, atl, i, n - 1, m, n, heights[i][n - 1]);
        }

        for(int i = 0; i < n; i++) {
            helper(heights, pac, 0, i, m, n, heights[0][i]);
            helper(heights, atl, m -1, i, m, n, heights[m-1][i]);
        }



        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pac[i][j] == true && atl[i][j] == true) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }

        return ans;
    }


    public void  helper(int[][] heights, boolean[][] res, int r , int c, int m, int n,
    int prev) {


        if(r < 0 || c < 0 || r >= m || c >= n || heights[r][c] < prev || res[r][c] == true) {
            return;
        }

        res[r][c] = true;

        helper(heights, res, r + 1, c, m, n, heights[r][c]);
        helper(heights, res, r - 1, c, m, n, heights[r][c]);
        helper(heights, res, r, c + 1, m, n, heights[r][c]);
        helper(heights, res, r, c - 1, m, n, heights[r][c]);

        return;

    }
}