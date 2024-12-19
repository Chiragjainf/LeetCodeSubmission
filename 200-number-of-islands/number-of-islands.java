class Solution {

    public int numIslands(char[][] grid) {

        int m = grid.length, n = grid[0].length, cnt = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    cnt++;
                    numIslandsHelper(grid, i, j, m , n);
                }
            }
        }
        return cnt;
        
    }

    public void numIslandsHelper(char[][] grid, int r, int c, int m, int n) {

        if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';

        numIslandsHelper(grid, r + 1, c, m , n);
        numIslandsHelper(grid, r - 1, c, m , n);
        numIslandsHelper(grid, r, c + 1, m , n);
        numIslandsHelper(grid, r, c - 1, m , n);

    }


}