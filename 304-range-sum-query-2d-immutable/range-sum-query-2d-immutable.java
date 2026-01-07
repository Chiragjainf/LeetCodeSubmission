class NumMatrix {

    int sumMatrix[][];

    public NumMatrix(int[][] matrix) {

        sumMatrix = new int[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(j == 0) {
                    sumMatrix[i][j] = matrix[i][j];
                } else {
                    sumMatrix[i][j] = sumMatrix[i][j - 1] + matrix[i][j];
                }
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(i == 0) {
                    continue;
                } else {
                    sumMatrix[i][j] = sumMatrix[i -1][j] + sumMatrix[i][j];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int x = sumMatrix[row2][col2] - (row1 - 1 < 0 ? 0 : sumMatrix[row1 - 1][col2]);

        int y = col1 - 1 < 0 ? 0 : sumMatrix[row2][col1 - 1] - (row1 - 1 < 0 ? 0 : sumMatrix[row1 - 1][col1 - 1]);

        return x - y;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */