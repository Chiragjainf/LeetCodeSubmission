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
    public boolean isValidBST(TreeNode root) {

        if(root == null) {
            return true;
        }

        return isValidBSTHelper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }

    public boolean isValidBSTHelper(TreeNode root, long mn , long mx) {

        if(root == null) {
            return true;
        }

        if(root.val >= mx  || root.val <= mn) {
            return false;
        }

        return isValidBSTHelper(root.left, mn, root.val) && isValidBSTHelper(root.right, root.val, mx);
    }
}