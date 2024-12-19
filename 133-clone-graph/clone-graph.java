/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    Map<Node, Node> hs;
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }

        hs = new HashMap<>();
        Node temp = new Node(node.val);
        hs.put(node, temp);
        dfs(node);
        return temp;
    }

    public void dfs(Node node) {
        for(Node currNode: node.neighbors) {
            if(!hs.containsKey(currNode)) {
                Node temp = new Node(currNode.val);
                hs.put(currNode, temp);
                hs.get(node).neighbors.add(temp);
                //hs.get(currNode).neighbors.add(hs.get(node));
                dfs(currNode);
            } else {
                hs.get(node).neighbors.add(hs.get(currNode));
                //hs.get(currNode).neighbors.add(hs.get(node));
            }
        }
    }
}