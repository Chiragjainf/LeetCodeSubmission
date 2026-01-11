class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        

        if(n == 0) {
            return;
        }

        for(int i = 0 ; i < m; i++) {

            if(nums1[i] > nums2[0]) {
                int temp = nums1[i];
                nums1[i] = nums2[0];
                nums2[0] = temp;
                sort(nums2, n);
            }
        }

        for(int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }

    }

    public void sort(int nums[], int n) {
        for(int i = 1; i < n; i++) {
            if(nums[i - 1] <= nums[i]) {
                break;
            } else {
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }
        }
    }
}