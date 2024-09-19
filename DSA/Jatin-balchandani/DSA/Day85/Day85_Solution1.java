import java.util.*;

public class Day85_Solution1 {

    //Function to find number of strongly connected components in the graph.
    public void TopoSort(int curr, ArrayList<ArrayList<Integer>> adj, boolean vis[], Stack<Integer> st) {
        vis[curr] = true;
        for (Integer nbr : adj.get(curr)) {
            if (!vis[nbr]) {
                TopoSort(nbr, adj, vis, st);
            }
        }
        st.add(curr);
    }

    public void DFS(int node, ArrayList<ArrayList<Integer>> adj2, boolean vis[]) {
        vis[node] = true;
        for (Integer nbr : adj2.get(node)) {
            if (!vis[nbr]) {
                DFS(nbr, adj2, vis);
            }
        }
    }

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        //code here
        Stack<Integer> st = new Stack<>();
        boolean vis[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                TopoSort(i, adj, vis, st);
            }
        }

        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj2.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int v : adj.get(i)) {
                adj2.get(v).add(i);
            }
        }
        for (int i = 0; i < V; i++) {
            vis[i] = false;
        }
        int ans = 0;
        while (!st.isEmpty()) {
            int curr = st.pop();
            if (!vis[curr]) {
                DFS(curr, adj2, vis);
                ans++;
            }

        }

        return ans;
    }
}