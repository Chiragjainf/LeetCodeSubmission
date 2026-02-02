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

 class Pair {
    int incl;
    int excl;

    Pair(int i, int j) {
        incl = i;
        excl = j;
    }
}


class Solution {
    public int rob(TreeNode root) {
        Pair res = helper(root);

        return Math.max(res.incl, res.excl);
    }

    public Pair helper(TreeNode root) {
        
        if(root == null) {
            return new Pair(0,0);
        }

        Pair l = helper(root.left);
        Pair r = helper(root.right);


        int temp = Math.max(l.incl, l.excl)  + Math.max(r.incl, r.excl);

        int excl = root.val + l.incl + r.incl;


        return new Pair(temp , excl);
        
    }
}