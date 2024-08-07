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
    boolean ans = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null) {
            return false;
        }
        
        hasPathSumHelper(root, targetSum, 0);


        return ans;
    }


    public void hasPathSumHelper(TreeNode root, int targetSum, int sum) {

        if(root == null) {
            return;
        }

        hasPathSumHelper(root.left, targetSum, sum + root.val);
        hasPathSumHelper(root.right, targetSum, sum + root.val);

        if(root.left == null && root.right == null && targetSum == sum + root.val) {
            ans = true;
            //return;
        }

        //System.out.println(targetSum)
    }
}