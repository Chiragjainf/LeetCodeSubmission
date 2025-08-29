class Solution {


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        int n = equations.size();

        Map<String, Integer> hm = new HashMap<>();

        int cnt = 0;

        for(List<String> temp: equations) {
            if(!hm.containsKey(temp.get(0))) {
                hm.put(temp.get(0), cnt++);
            }
            if(!hm.containsKey(temp.get(1))) {
                hm.put(temp.get(1), cnt++);
            }
        }

        List<Node> adj[] = new List[cnt];

        for(int i = 0; i < cnt; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            List<String> curr = equations.get(i);

            int first = hm.get(curr.get(0));
            int second = hm.get(curr.get(1));

            adj[first].add(new Node(second, values[i]));
            adj[second].add(new Node(first, (double)1 / values[i]));
        }

        int qs = queries.size();

        double res[] = new double[qs];

        for(int i = 0; i < qs; i++) {
            List<String> curr = queries.get(i);

            if(!hm.containsKey(curr.get(0))|| !hm.containsKey(curr.get(1))) {
                res[i] = -1;
            } else {
                int first = hm.get(curr.get(0));
                int second = hm.get(curr.get(1));

                res[i] = dfs(adj, first, second, new boolean[cnt]);
            }
        }

        return res;

    }

    public double dfs(List<Node> adj[], int src, int des, boolean vis[]) {
        
        vis[src] = true;

        if(src == des ) {
            return 1.0;
        }


        //double weight = 1.0;
        for(Node currNode: adj[src]) {
            int n = currNode.node;
            if(!vis[n]) {
                double ans = dfs(adj, n, des, vis);
                if(ans != -1.0) {
                    return ans * currNode.value;
                }
            }
        }

        return -1.0;
    }




}

class Node{
    int node;
    double value;

    Node(int x, double y) {
        node = x;
        value = y;
    }
}