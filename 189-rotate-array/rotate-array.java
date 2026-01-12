class Solution {

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        rotate(nums, 0, n - 1);

        rotate(nums, 0, k - 1);
        rotate(nums, k, n - 1);

    }

    public void rotate(int[] s, int l, int r) {
        while(l <= r) {
            int temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }


}