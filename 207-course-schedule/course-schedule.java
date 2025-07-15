class Solution {


    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> adj[] = new List[numCourses];

        for(int i = 0 ; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        int n = prerequisites.length;

        if(n == 0 || numCourses == 1) {
            return true;
        }

        for(int i = 0; i < n; i++) {
            adj[prerequisites[i][0]].add(prerequisites[i][1]);
        }


        boolean vis[] = new boolean[numCourses];
        boolean rec[] = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(vis[i] == false) {
                if(cycleExist(adj, vis, rec, i)) {
                    return false;
                }
            }
        }

        return true;

    }

    public boolean cycleExist(List<Integer> adj[], boolean vis[], boolean rec[], int src) {

        vis[src] = true;

        rec[src] = true;


        for(int nextNode : adj[src]) {
            if(vis[nextNode] == false) {
                if(cycleExist(adj, vis, rec, nextNode)) {
                    return true;
                }
            } else if(rec[nextNode] == true) {
                return true;
            }
        }

        rec[src] = false;

        return false;

    }




}