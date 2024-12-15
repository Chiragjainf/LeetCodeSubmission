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

        if(root == null) {
            return false;
        }
        Set<String> hs = new HashSet<>();
        isSameTreeHelper(root, hs);
        if(hs.contains(isSameTreeHelper2(subRoot))) {
            return true;
        }
        return false;

    }

    public String isSameTreeHelper(TreeNode root, Set<String> hs) {

        if(root == null) {
            return "N";
        }

        String left = isSameTreeHelper(root.left, hs);
        String right = isSameTreeHelper(root.right, hs);

        hs.add("( " + left + " " + root.val +  " " + right + ")");
        return "( " + left + " " + root.val +  " " + right + ")";
        
    }

    public String isSameTreeHelper2(TreeNode root) {

        if(root == null) {
            return "N";
        }

        String left = isSameTreeHelper2(root.left);
        String right = isSameTreeHelper2(root.right);

        //hs.add(left + " " + root.val +  " " + right);
        return "( " + left + " " + root.val +  " " + right + ")";
        
    }


}