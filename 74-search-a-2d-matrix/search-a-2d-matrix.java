class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length, i;
        for(i = 0; i < m; i++) {
            if(target <= matrix[i][n-1]) {
                break;
            }
        }
        if(i >= m) {
            return false;
        }
        else {
            return searchHelper(matrix[i],target,0, n);
        }
    }

    boolean searchHelper(int nums[], int target, int l , int r) {
        if(l <= r) {
         int m = l + (r-l) / 2;
         if(nums[m] == target) {
             return true;
         } else if(  nums[m] > target) {
              return searchHelper(nums, target, l, m-1);
         } else {
             return searchHelper(nums, target, m+1, r);
         }
        }
        return false;
    }
}