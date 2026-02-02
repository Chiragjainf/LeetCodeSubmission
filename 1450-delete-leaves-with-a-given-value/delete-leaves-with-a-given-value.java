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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode left = helper(root, target);

        if(left != null && left.left == null && left.right == null && left.val == target) {
            return null;
        }

        return left;
    }

    public TreeNode helper(TreeNode root, int target) {
        if(root == null) {
            return null;
        }

        TreeNode left = helper(root.left, target);

        TreeNode right = helper(root.right, target);


        if(left != null && left.left == null && left.right == null && left.val == target) {
            root.left = null;
            left = null;
        }

        if(right != null && right.left == null && right.right == null && right.val == target) {
            root.right = null;
            right = null;
        }

        


        return root;


    }
}