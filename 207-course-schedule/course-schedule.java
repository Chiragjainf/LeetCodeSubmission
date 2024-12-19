class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> adj[] = new List[numCourses];

        for(int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        boolean vis[] = new boolean[numCourses];
        boolean rec[] = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(vis[i] == false) {
                if(isCycle(adj, i, vis, rec)) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public boolean isCycle(List<Integer> adj[], int src, boolean vis[], boolean rec[]) {

        vis[src] = true;
        rec[src] = true;

        for(int node : adj[src]) {
            if(vis[node] == false && isCycle(adj, node, vis, rec)) {
                    return true;
            } else if(rec[node] == true){
                return true;
            }
        }

        rec[src] = false;
        return false;
    }
}