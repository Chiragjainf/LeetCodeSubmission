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

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) {
            return res;
        }

        queue.add(root);

        while(!queue.isEmpty()) {
            int k  = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0 ; i < k; i++) {
                TreeNode curr = queue.remove();
                temp.add(curr.val);
                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
            res.add(temp);
        }
        return res;
    }
}