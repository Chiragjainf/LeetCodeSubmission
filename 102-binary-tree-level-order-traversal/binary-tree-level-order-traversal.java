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


        List<List<Integer>> res = new ArrayList<>();
         if(root == null) {
            return res;
        }

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        while(bfs.size() > 0) {

            int k = bfs.size();
            List<Integer> t = new ArrayList<>();

            for(int i = 0; i < k; i++) {
                TreeNode temp = bfs.poll();
                if(temp.left != null) {
                    bfs.offer(temp.left);
                }

                if(temp.right != null) {
                    bfs.offer(temp.right);
                }
                t.add(temp.val);
            }

            res.add(new ArrayList(t));
        }

        return res;
        
    }
}