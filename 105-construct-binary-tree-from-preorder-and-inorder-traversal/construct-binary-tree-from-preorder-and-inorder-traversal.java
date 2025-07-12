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
    int preIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int l, int r) {

        if(l > r) {
            return null;
        }
        
        int index = findIndex(preorder[preIndex], inorder, l, r);

        TreeNode root = new TreeNode(preorder[preIndex++]);

        root.left = buildTreeHelper(preorder, inorder, l , index - 1);

        root.right = buildTreeHelper(preorder, inorder, index + 1 , r);

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