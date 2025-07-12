/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int cnt = 0, ans = -1;
    boolean flag = false;
    public int kthSmallest(TreeNode root, int k) {
        kthSmallestHelper(root, k);
        return ans;
    }

    public int kthSmallestHelper(TreeNode root, int k) {
        if(root == null) {
            return 0;
        }

        kthSmallestHelper(root.left, k);

        cnt++;

        if(flag == false && cnt == k) {
            ans = root.val;
            flag = true;
        }

        if(flag == true) {
            return 0;
        }

        kthSmallestHelper(root.right, k);
        
        return 0;

    }
}