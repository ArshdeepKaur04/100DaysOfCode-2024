import java.util.*;
public class Day84_Solution1 {

        public void  dfs(int node,ArrayList<ArrayList<Integer>> adj,  boolean vis[], ArrayList<Integer> ans){
            //add yhe current node to the ans.
            ans.add(node);
            // mark the current node as visited
            vis[node] =true;
            //explore all the adj nodes
            for(int i=0;i<adj.get(node).size();i++){
                int next = adj.get(node).get(i);
                if(!vis[next]){
                    dfs(next, adj,vis,ans);
                }
            }
        }
        // Function to return a list containing the DFS traversal of the graph.
        public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
            // Code here
            ArrayList<Integer> ans = new ArrayList<>();

            boolean vis[] = new boolean[V];

            dfs(0, adj, vis, ans);

            return ans;

        }
    }
