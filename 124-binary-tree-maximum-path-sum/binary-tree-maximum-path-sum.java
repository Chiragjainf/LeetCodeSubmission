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

    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        maxPathSumHelper(root);
        return res;
        
    }

    public int maxPathSumHelper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);

        int currSum = root.val;
        int temp = Math.max(0, Math.max(left + right, Math.max(left ,right)));

        res = Math.max(res, currSum + temp);

        return root.val + Math.max(0,  Math.max(left ,right));

    }
}