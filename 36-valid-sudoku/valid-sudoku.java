class Solution {


    public boolean isValidSudoku(char[][] board) {

        int row[] = new int[10];
        int col[] = new int[10];
        int box[] = new int[10];

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {

                if(board[i][j] == '.') {
                    continue;
                }

                int currNum = board[i][j] - '0';

                int x = (i / 3) * 3 + j / 3;

                if((row[i] & 1 << currNum) > 0
                || (col[j] & 1 << currNum) > 0
                || (box[x] & 1 << currNum) > 0) {
                    return false;
                }

                row[i] |= 1 << currNum;
                col[j] |= 1 << currNum;
                box[x] |= 1 << currNum;

            }
        }

        return true;

    }
}