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

    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, 0 , inorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder , int l, int r) {

        if(l > r) {
            return null;
        }

        int preIndex = findIndex(inorder, preorder[index]);


        if(preIndex == -1) {
            return null; 
        }

        
        TreeNode root = new TreeNode(preorder[index++]);

        root.left = buildTreeHelper(preorder, inorder, l , preIndex - 1);

        root.right = buildTreeHelper(preorder, inorder, preIndex + 1 , r);

        return root;
        
    }

    public int findIndex(int[] inorder, int v) {
        int n = inorder.length;
        for(int j = 0; j < n; j++) {
            if(inorder[j] == v ) {
                return j;
            }
        }
        return -1;
    }

}