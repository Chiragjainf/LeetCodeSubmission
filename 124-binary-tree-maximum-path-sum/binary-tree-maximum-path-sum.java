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
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        return ans;
    }

    public int maxPathSumHelper(TreeNode root) {
        

        if(root == null) {
            return 0;
        }

        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);

        ans = Math.max(ans , root.val + left + right);
        ans = Math.max(ans , root.val + Math.max(0, Math.max(left , right)));
        //ans = Math.max(ans , root.val );

        return Math.max(root.val, root.val + Math.max(left , right));

    }
}