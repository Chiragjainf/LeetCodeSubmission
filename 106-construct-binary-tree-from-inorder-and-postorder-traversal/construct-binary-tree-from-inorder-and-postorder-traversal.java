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

    int postIndex = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;
        
        return buildTreeHelper(postorder, inorder, 0 ,  postorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] postorder, int[] inorder, int l, int r) {

        if(l > r) {
            return null;
        }
        
        int index = findIndex(postorder[postIndex], inorder, l, r);

        TreeNode root = new TreeNode(postorder[postIndex--]);

        root.right = buildTreeHelper(postorder, inorder, index + 1 , r);

        root.left = buildTreeHelper(postorder, inorder, l , index - 1);

        return root;

    }

    public int findIndex(int val , int[] inorder, int l, int r) {
        for(int i = l ; i <= r ; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}