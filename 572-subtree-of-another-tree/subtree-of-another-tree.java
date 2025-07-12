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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
       Set<String> hs1 = new HashSet<>();
       Set<String> hs2 = new HashSet<>();
       constructTree(root, hs1);

       String subRootPrefix = constructTree(subRoot, hs2);

       if(hs1.contains(subRootPrefix)) {
        return true;
       }

       return false;
    }

    public String constructTree(TreeNode root, Set<String> hs) {
        if(root == null) {
            return "(N";
        }

        String left = constructTree(root.left, hs);
        String right = constructTree(root.right, hs);

        hs.add(left + root.val + right + ")");

        return left + root.val + right + ")";

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if(p == null || q == null) {
            return false;
        }


        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}