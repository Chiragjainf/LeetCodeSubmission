class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int top = 0, left = 0, right = matrix[0].length, bottom = matrix.length;
        List<Integer> res = new ArrayList<>();
        while(top < bottom && left < right) {
            //top left to right
            for(int i = left; i < right; i++) {
                res.add(matrix[top][i]);
            }
            top++;

            //right top to bottom
            for(int i = top ; i < bottom; i++) {
                res.add(matrix[i][right - 1]);
            }
            right--;

            if (!(left < right && top < bottom)) {
                break;
            }

            // right bottom to left bottom
            for(int i = right - 1; i >= left; i--) {
                res.add(matrix[bottom - 1][i]);
            }
            bottom--;
            // left bottom to left top
            for(int i = bottom - 1; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            left++;
        }

        return res;
    }
}