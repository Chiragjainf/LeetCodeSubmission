class Solution {

    int ri[] = new int[]{0,0,1,-1};
    int ci[] = new int[]{1,-1,0,0};

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        boolean vis[][] = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(existHelper(board, word, i, j, m, n, 0, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean existHelper(char[][] board, String word, int r,
     int c, int m, int n, int i, boolean vis[][]) {

        if(i == word.length()) {
            return true;
        }

        if( r >= m || c >= n || r < 0 || c < 0 || board[r][c] != word.charAt(i) || 
          i > word.length() || vis[r][c] == true) {
            return false;
        }
        //System.out.println("abcd" + currWord);

        vis[r][c] = true;

        boolean res = existHelper(board, word, r + 1, c, m, n, i + 1, vis)
        || existHelper(board, word, r - 1, c, m, n, i + 1, vis)
        || existHelper(board, word, r , c + 1, m, n, i + 1, vis)
        || existHelper(board, word, r , c - 1, m, n, i + 1, vis);

        vis[r][c] = false;

        return res;






        // for(int i = 0; i < 4; i++) {
        //     int x = r + ri[i];
        //     int y = c + ci[i];

        //     if(isValid(char[][] board, x, y , m, n, vis)) {
        //         vis[x][y] = true;
        //         if(existHelper()) {
        //             return true;
        //         }
        //         vis[x][y] = false;
        //     }

        // }
        
    }


}