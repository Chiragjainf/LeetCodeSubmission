/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    int i = 0;
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if(root == null) {
            return "N";
        }

        String temp = root.val + " ";

        String left = serialize(root.left);
        String right = serialize(root.right);

        return temp + left + right;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //System.out.println(data);

        if(data.charAt(i) == 'N') {
            i++;
            return null;
        }

        String temp = "";
        while(data.charAt(i) != ' ') {
            temp += data.charAt(i);
            i++;
        }
        i++;
        TreeNode root = new TreeNode(Integer.valueOf(temp));
        root.left = deserialize(data);
        root.right = deserialize(data);

        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));